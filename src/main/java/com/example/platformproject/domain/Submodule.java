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
@Table(name = "submodule")
public class Submodule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne()
    @JoinColumn(name = "module_id")
    private Module module;

    @OneToMany(mappedBy = "submodule", fetch = FetchType.LAZY)
    private List<Lesson> lessons = new LinkedList<>();
}
