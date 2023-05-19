package com.example.platformproject.web.controller.V1;

import com.example.platformproject.domain.Course;
import com.example.platformproject.service.CourseService;
import com.example.platformproject.service.ModuleService;
import com.example.platformproject.web.annotation.ApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@ApiV1
@RequiredArgsConstructor
@Controller
public class CourseController {

    @Autowired
    private ModuleService moduleService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/course/{courseName}")
    public ModelAndView getModules(@PathVariable String courseName, Model model) {
        Course course = courseService.findCourseByName(courseName);
        model.addAttribute("name", courseName);
        model.addAttribute("course", course);
        model.addAttribute("modules", moduleService.findModules(course.getId()));
        return new ModelAndView("course");
    }

}
