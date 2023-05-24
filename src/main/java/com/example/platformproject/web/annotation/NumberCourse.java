package com.example.platformproject.web.annotation;

import com.example.platformproject.web.validator.NumberCourseConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target( {ElementType.FIELD })
@Constraint(validatedBy = NumberCourseConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberCourse {
    String message() default "{NumberCourse}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
