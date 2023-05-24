package com.example.platformproject.service;

import com.example.platformproject.domain.Course;
import com.example.platformproject.domain.Student;
import com.example.platformproject.repository.StudentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return studentRepository.findStudentById(id);
    }

    public void updateParameterStudent(Long id, String param, String new_value){
        Student student = studentRepository.findStudentById(id);
        if(Objects.equals(param, "group_id")){
            student.setGroup_id(Integer.parseInt(new_value));
            studentRepository.save(student);
        }
        if(Objects.equals(param, "full_address")){
            student.setFull_address(new_value);
            studentRepository.save(student);
        }
        if(Objects.equals(param, "point")){
            student.setPoint(Long.parseLong(new_value));
            studentRepository.save(student);
        }
        if(Objects.equals(param, "course_id")){
            Course course = courseService.findCourse(Long.parseLong(new_value));
            student.setCourse(course);
            studentRepository.save(student);
        }
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }

}
