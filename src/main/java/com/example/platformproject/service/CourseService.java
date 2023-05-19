package com.example.platformproject.service;

import com.example.platformproject.domain.Course;
import com.example.platformproject.repository.CourseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course findCourse(Long id){
        return courseRepository.findCourseById(id);
    }
    public Course findCourseByName(String name){
        return courseRepository.findCourseByCoursename(name);
    }
}
