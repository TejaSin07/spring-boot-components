package in.tejas.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.tejas.enity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("""
        SELECT s FROM Student s
        JOIN FETCH s.courses
        WHERE s.id = :id
    """)
    Optional<Student> findStudentWithCourses(Long id);
}
