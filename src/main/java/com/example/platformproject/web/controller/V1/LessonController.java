package com.example.platformproject.web.controller.V1;

import com.example.platformproject.domain.Lesson;
import com.example.platformproject.service.LessonService;
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
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/lesson/{lessonName}")
    public ModelAndView getLessons(@PathVariable String lessonName, Model model) {
        Lesson lesson = lessonService.findLesson(lessonName);
        model.addAttribute("name", lessonName);
        model.addAttribute("lesson", lesson);
        return new ModelAndView("lesson");
    }
}
