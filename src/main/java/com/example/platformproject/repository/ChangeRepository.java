package com.example.platformproject.repository;

import com.example.platformproject.domain.Change;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeRepository extends JpaRepository<Change, Long> {
    Change findChangeById(Long id);
    List <Change> findAllByViewed(Boolean viewed);
}
