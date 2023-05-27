package com.example.platformproject.repository;

import com.example.platformproject.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentById(Long id);

    List<Student> findStudentsByBirthdate(Date date);

}
