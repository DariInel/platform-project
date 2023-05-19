package com.example.platformproject.web.controller.Admin;

import com.example.platformproject.domain.Student;
import com.example.platformproject.service.StudentService;
import com.example.platformproject.web.annotation.AdminApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@AdminApiV1
@RequiredArgsConstructor
@Controller
public class AdminMainController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/main")
    public ModelAndView getModules(Model model) {
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
/*
    @PostMapping("/student/change_group")
    public ModelAndView changeCourse(Model model, @RequestParam(required = true, defaultValue = "" ) String id,
                                     @RequestParam(required = true, defaultValue = "" ) String param, @ModelAttribute String new_value) {
        Student student = studentService.getStudent(Long.parseLong(id_student));
        model.addAttribute("student", student);
        return new ModelAndView("change_student");
    }

 */
}

