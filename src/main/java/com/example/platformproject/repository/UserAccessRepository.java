package com.example.platformproject.repository;

import com.example.platformproject.domain.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {
    UserAccess findByLogin(String login);
}
