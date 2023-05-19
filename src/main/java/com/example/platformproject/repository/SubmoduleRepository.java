package com.example.platformproject.repository;

import com.example.platformproject.domain.Submodule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmoduleRepository extends JpaRepository<Submodule, Long> {
    List<Submodule> findAllByModuleId(Long module_id);
    Submodule findSubmoduleByName(String name);
}
