package com.example.platformproject.web.controller.V1;

import com.example.platformproject.domain.Student;
import com.example.platformproject.domain.UserAccess;
import com.example.platformproject.service.StudentService;
import com.example.platformproject.service.UserAccessService;
import com.example.platformproject.web.annotation.ApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


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
}
