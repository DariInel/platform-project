package com.example.platformproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coursename;
    private String short_description;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Module> module = new LinkedList<>();

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Student> students = new LinkedList<>();
}
