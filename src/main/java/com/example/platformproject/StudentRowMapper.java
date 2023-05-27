package com.example.platformproject;

import com.example.platformproject.domain.Course;
import com.example.platformproject.domain.Student;
import com.example.platformproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentRowMapper implements RowMapper<Student> {

    @Autowired
    CourseService courseService;
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setAge(rs.getInt("age"));
        student.setBirthdate(rs.getDate("birth_date"));
        student.setFirst_name(rs.getString("first_name"));
        student.setFull_address(rs.getString("full_address"));
        student.setGroup_id(rs.getInt("group_id"));
        student.setPatronymic(rs.getString("patronymic"));
        student.setSecond_name(rs.getString("second_name"));
        student.setPoint(rs.getLong("point"));
        student.setCourse(courseService.findCourse(rs.getLong("course_id")));
        return student;
    }
}
