package in.tejas.service;

import org.springframework.stereotype.Service;

import in.tejas.enity.Course;
import in.tejas.enity.Student;
import in.tejas.repo.CourseRepository;
import in.tejas.repo.StudentRepository;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo,
                          CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    // single method does ALL work
    public void insertAndFetchData() {

        // create courses
        Course java = new Course();
        java.setTitle("Java");
        courseRepo.save(java);

        Course spring = new Course();
        spring.setTitle("Spring Boot");
        courseRepo.save(spring);

        // create student
        Student student = new Student();
        student.setName("Tejas");

        // enroll student (owning side)
        student.getCourses().add(java);
        student.getCourses().add(spring);

        studentRepo.save(student);

        // fetch & print
        Student result =
                studentRepo.findStudentWithCourses(student.getId()).orElseThrow();

        System.out.println("Student: " + result.getName());
        result.getCourses()
              .forEach(c -> System.out.println("Course: " + c.getTitle()));
    }
}

