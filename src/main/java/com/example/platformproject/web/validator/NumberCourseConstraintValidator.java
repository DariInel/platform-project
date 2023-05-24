package com.example.platformproject.web.validator;

import com.example.platformproject.service.CourseService;
import com.example.platformproject.web.annotation.NumberCourse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberCourseConstraintValidator implements ConstraintValidator<NumberCourse, Long> {
    @Autowired
    CourseService courseService;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(value <= 0)
            return false;
        return courseService.findCourse(value) != null;
    }
}
