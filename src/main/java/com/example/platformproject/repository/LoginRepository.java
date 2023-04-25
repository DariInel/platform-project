package com.example.platformproject.repository;

import com.example.platformproject.domain.Login;
import com.example.platformproject.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, Integer> {
}
