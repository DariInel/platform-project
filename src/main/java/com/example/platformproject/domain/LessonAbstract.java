package com.example.platformproject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson_abstract")
public class LessonAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;

    @ManyToOne()
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
