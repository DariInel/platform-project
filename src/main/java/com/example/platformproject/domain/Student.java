package com.example.platformproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String secondName;
    private String patronymic;
    private Integer age;
    private Date birthDate;
    private Integer groupId;
    private  String fullAddress;
    private Boolean isWorked;
}
