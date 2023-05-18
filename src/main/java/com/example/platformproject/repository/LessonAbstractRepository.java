package com.example.platformproject.repository;

import com.example.platformproject.domain.LessonAbstract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonAbstractRepository extends JpaRepository<LessonAbstract, Long> {
}
