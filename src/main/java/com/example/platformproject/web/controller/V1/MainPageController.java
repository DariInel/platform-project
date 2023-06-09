package com.example.platformproject.web.controller.V1;

import com.example.platformproject.domain.Student;
import com.example.platformproject.domain.UserAccess;
import com.example.platformproject.domain.dto.request.ChangeAddress;
import com.example.platformproject.service.StudentService;
import com.example.platformproject.service.UserAccessService;
import com.example.platformproject.util.CustomResponse;
import com.example.platformproject.web.annotation.ApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;


@ApiV1
@RequiredArgsConstructor
@Controller
public class MainPageController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserAccessService userAccessService;

    @GetMapping("/home")
    public ModelAndView MainPage(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserAccess) {
           String username = ((UserAccess) principal).getUsername();
           Student student = userAccessService.findStudentByUsername(username);
           model.addAttribute("point", student.getPoint());
           model.addAttribute("nameCourse", student.getCourse().getCoursename());
           model.addAttribute("student", student);
           model.addAttribute("course", student.getCourse());
        }
        return new ModelAndView("main_page");
    }
    @PostMapping("/home/{id}")
    public ModelAndView Change(Model model, @PathVariable @NotNull String id, @ModelAttribute("new_value") @NotBlank String new_value) {
        ChangeAddress data = new ChangeAddress();
        data.setId_student(Long.parseLong(id));
        String message = "Ученик с id " + id + " изменил адрес с " + studentService.getStudent(Long.parseLong(id)).getFull_address() + " на " + new_value;
        data.setMessage(message);
        data.setNew_value(new_value);
        data.setDate(Date.valueOf(LocalDate.now()));
        CustomResponse response = studentService.updateAddressStudent(data);
        if(response.getCode() == 1) {
            String error = "Такого ученика нет";
            model.addAttribute("error", error);
        }
        if(response.getCode() == 2) {
            String error = "Что-то пошло не так, попробуйте снова :(";
            model.addAttribute("error", error);
        }
        return MainPage(model);
    }
}
