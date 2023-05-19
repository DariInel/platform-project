package com.example.platformproject.repository;

import com.example.platformproject.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    static final String SQL_UPDATE_GROUP =
            "update student set group_id = :groupId where id = :id";
    Student findStudentById(Long id);
/*
    @Override
    public void updateGroup(String groupId, Long id) {
        var params = new MapSqlParameterSource();
        params.addValue("groupId", groupId);
        params.addValue("id", id);
        jdbcTemplate.update(params, SQL_UPDATE_GROUP);
    }

 */
}
