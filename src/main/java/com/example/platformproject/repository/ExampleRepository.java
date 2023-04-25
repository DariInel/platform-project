package com.example.platformproject.repository;

import com.example.platformproject.domain.Example;
import com.example.platformproject.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface ExampleRepository extends CrudRepository<Example, Integer> {
}
