package in.tejas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tejas.enity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

