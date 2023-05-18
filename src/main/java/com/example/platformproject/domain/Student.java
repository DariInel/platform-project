package com.example.platformproject.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String second_name;
    private String patronymic;
    private Integer age;
    private Date birth_date;
    private Integer group_id;
    private  String full_address;
    private Long point;

    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(mappedBy = "student")
    private UserAccess userAccess;
}
