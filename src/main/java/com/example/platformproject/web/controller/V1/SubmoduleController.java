package com.example.platformproject.web.controller.V1;

import com.example.platformproject.domain.Module;
import com.example.platformproject.domain.Submodule;
import com.example.platformproject.service.LessonService;
import com.example.platformproject.service.SubmoduleService;
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
public class SubmoduleController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private SubmoduleService submoduleService;

    @GetMapping("/submodule/{submoduleName}")
    public ModelAndView getLessons(@PathVariable String submoduleName, Model model) {
        Submodule submodule = submoduleService.findSubmodule(submoduleName);
        model.addAttribute("name", submoduleName);
        model.addAttribute("submodule", submodule);
        model.addAttribute("lessons", lessonService.findLessons(submodule.getId()));
        return new ModelAndView("submodule");
    }
}
