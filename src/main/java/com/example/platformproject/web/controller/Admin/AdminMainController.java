package com.example.platformproject.web.controller.Admin;

import com.example.platformproject.domain.Student;
import com.example.platformproject.service.CourseService;
import com.example.platformproject.service.StudentService;
import com.example.platformproject.web.annotation.AdminApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@AdminApiV1
@RequiredArgsConstructor
@Controller
public class AdminMainController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/main")
    public ModelAndView getListStudent(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return new ModelAndView("admin_main");
    }

    @GetMapping("/student/{id_student}")
    public ModelAndView getStudent(Model model, @PathVariable String id_student) {
        Student student = studentService.getStudent(Long.parseLong(id_student));
        model.addAttribute("student", student);
        return new ModelAndView("change_student");
    }

    @PostMapping("/student/{id_student}")
    public ModelAndView changeParam(Model model, @PathVariable String id_student,
                                     @RequestParam(required = true, defaultValue = "" ) String param, @ModelAttribute("new_value") String new_value) {
        studentService.updateParameterStudent(Long.parseLong(id_student), param, new_value);
        return getStudent(model, id_student);

    }
    @GetMapping("/student/add")
    public ModelAndView student(Model model) {
        return new ModelAndView("add_student");
    }
    @PostMapping("/student/add")
    public ModelAndView add(Model model, @ModelAttribute("second_name") String second_name, @ModelAttribute("first_name") String first_name,
                            @ModelAttribute("patronymic") String patronymic, @ModelAttribute("age") String age,
                            @ModelAttribute("birth_date") Date birth_date, @ModelAttribute("full_address") String full_address,
                            @ModelAttribute("group_id") String group_id, @ModelAttribute("course_id") String course_id) {
        Student student = new Student();
        Long id;
        while (true){
            id = Double.valueOf(Math.random()*1000).longValue();
            if(studentService.getStudent(id) == null)
                break;
        }
        student.setId(id);
        student.setSecond_name(second_name);
        student.setFirst_name(first_name);
        student.setPatronymic(patronymic);
        student.setCourse(courseService.findCourse(Long.parseLong(course_id)));
        student.setAge(Integer.parseInt(age));
        student.setBirth_date(birth_date);
        student.setPoint(0L);
        student.setFull_address(full_address);
        student.setGroup_id(Integer.parseInt(group_id));
        studentService.addStudent(student);
        return getListStudent(model);

    }

}

