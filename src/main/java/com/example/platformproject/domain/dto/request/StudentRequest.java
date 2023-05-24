package com.example.platformproject.domain.dto.request;

import com.example.platformproject.web.annotation.NumberCourse;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.sql.Date;

@Getter
@Setter
public class StudentRequest {

    @NotBlank
    String first_name;
    @NotBlank
    String second_name;
    @NotBlank
    String patronymic;
    @NotNull
    @Min(5)
    @Max(99)
    Integer age;
    @NotNull
    Date birth_date;
    @Positive
    Integer group_id;
    @NotBlank
    String full_address;
    @NumberCourse
    Long course_id;
}
