package com.example.platformproject.web.controller.Admin;

import com.example.platformproject.domain.Student;
import com.example.platformproject.domain.dto.request.StudentRequest;
import com.example.platformproject.service.ChangeService;
import com.example.platformproject.service.CourseService;
import com.example.platformproject.service.StudentService;
import com.example.platformproject.util.CustomResponse;
import com.example.platformproject.web.annotation.AdminApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AdminApiV1
@Validated
@RequiredArgsConstructor
@Controller
public class AdminMainController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ChangeService changeService;

    @GetMapping("/main")
    public ModelAndView getListStudent(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("changes", changeService.findChangesForView());
        model.addAttribute("students", students);
        return new ModelAndView("admin_main");
    }
    @GetMapping("/student/{id_student}")
    public ModelAndView getStudent(Model model, @PathVariable @NotBlank String id_student) {
        Student student = studentService.getStudent(Long.parseLong(id_student));
        model.addAttribute("student", student);
        return new ModelAndView("change_student");
    }
    @PostMapping("/change/{id}")
    public ModelAndView deleteChange(Model model, @PathVariable @NotBlank String id){
        changeService.updateChange(Long.parseLong(id));
        return getListStudent(model);
    }

    @PostMapping("/student/{id_student}")
    public ModelAndView changeParam(Model model, @PathVariable @NotBlank String id_student,
                                     @RequestParam(required = true, defaultValue = "" ) @NotBlank String param, @ModelAttribute("new_value") @NotBlank String new_value) {
        CustomResponse response = studentService.updateParameterStudent(Long.parseLong(id_student), param, new_value);
        if(response.getCode() == 1){
            String error = "Студент не найден";
            model.addAttribute("error", error);
        }
        if(response.getCode() == 2){
            String error = "Что-то пошло не так :(";
            model.addAttribute("error", error);
        }
        return getStudent(model, id_student);

    }
    @GetMapping("/student/add")
    public ModelAndView student(Model model, StudentRequest request) {
        model.addAttribute("student", request);
        return new ModelAndView("add_student");
    }
    @PostMapping(value = "/student/add")
    public ModelAndView add(Model model, @Valid StudentRequest student) {
        CustomResponse response = studentService.addStudent(student);
          if(response.getCode() == 2){
              String error = "Что-то пошло не так :(";
              model.addAttribute("error", error);
          }
        return getListStudent(model);
    }

    /*
    @PostMapping("/student/add")
    public ModelAndView add(Model model, @ModelAttribute("second_name") @NotBlank String second_name, @ModelAttribute("first_name") @NotBlank String first_name,
                            @ModelAttribute("patronymic") @NotBlank String patronymic, @ModelAttribute("age") @NotBlank @Size(min = 1, max = 2) String age,
                            @ModelAttribute("birth_date") Date birth_date, @ModelAttribute("full_address") @NotBlank String full_address,
                            @ModelAttribute("group_id") @NotBlank String group_id, @ModelAttribute("course_id") @NotBlank String course_id) {
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

     */
}

