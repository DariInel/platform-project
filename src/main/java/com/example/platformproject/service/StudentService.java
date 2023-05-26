package com.example.platformproject.service;

import com.example.platformproject.domain.Course;
import com.example.platformproject.domain.Student;
import com.example.platformproject.domain.dto.request.ChangeAddress;
import com.example.platformproject.domain.dto.request.StudentRequest;
import com.example.platformproject.event.ChangeAddressEvent;
import com.example.platformproject.repository.StudentRepository;
import com.example.platformproject.util.CustomResponse;
import com.example.platformproject.util.CustomStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Log4j2
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return studentRepository.findStudentById(id);
    }
    public CustomResponse updateAddressStudent(ChangeAddress data){
        Student student = studentRepository.findStudentById(data.getId_student());
        student.setFull_address(data.getNew_address());
        studentRepository.save(student);
        ChangeAddressEvent event = new ChangeAddressEvent(this, data);
        applicationEventPublisher.publishEvent(event);
        log.info("Студент изменил адрес");
        return new CustomResponse<>(null, CustomStatus.SUCCESS);
    }

    public CustomResponse updateParameterStudent(Long id, String param, String new_value){
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
        return new CustomResponse<>(null, CustomStatus.SUCCESS);
    }
    public CustomResponse addStudent(StudentRequest student){
        Student newStudent = new Student();
        newStudent.setAge(student.getAge());
        newStudent.setBirth_date(student.getBirth_date());
        newStudent.setFirst_name(student.getFirst_name());
        newStudent.setFull_address(student.getFull_address());
        newStudent.setGroup_id(student.getGroup_id());
        newStudent.setPatronymic(student.getPatronymic());
        newStudent.setSecond_name(student.getSecond_name());
        newStudent.setPoint(0L);
        newStudent.setCourse(courseService.findCourse(student.getCourse_id()));

        studentRepository.save(newStudent);
        log.info("Добавлен студент");
        return new CustomResponse<>(null, CustomStatus.SUCCESS);
    }

}
