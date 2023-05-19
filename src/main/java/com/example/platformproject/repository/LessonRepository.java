package com.example.platformproject.repository;

import com.example.platformproject.domain.Lesson;
import com.example.platformproject.domain.Submodule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllBySubmoduleId(Long submodule_id);
    Lesson findLessonByName(String name);
}
