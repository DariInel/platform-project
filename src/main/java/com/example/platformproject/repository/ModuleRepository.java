package com.example.platformproject.repository;

import com.example.platformproject.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    List <Module> findAllByCourseId(Long course_id);
}
