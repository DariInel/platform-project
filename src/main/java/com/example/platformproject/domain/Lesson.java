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
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;
    private String name;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "submodele_id")
    private Submodule submodule;

    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    private List<LessonAbstract> lessonAbstracts = new LinkedList<>();
}
