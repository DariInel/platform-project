package com.example.platformproject.service;

import com.example.platformproject.domain.Lesson;
import com.example.platformproject.repository.LessonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LessonService {

    @Autowired
    LessonRepository lessonRepository;

    public List<Lesson> findLessons(Long submoduleId){
        return lessonRepository.findAllBySubmoduleId(submoduleId);
    }
    public Lesson findLesson(String name){
        return lessonRepository.findLessonByName(name);
    }
}
