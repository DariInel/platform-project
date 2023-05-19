package com.example.platformproject.repository;

import com.example.platformproject.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
  //  Course findCourseByCourse_name(String course_name);
    Course findCourseById(Long id);
    Course findCourseByCoursename(String coursename);
}
