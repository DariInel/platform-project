package com.example.platformproject.service;

import com.example.platformproject.domain.Student;
import com.example.platformproject.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student findStudentById(Long studentId){
        return studentRepository.findStudentById(studentId);
    }
}