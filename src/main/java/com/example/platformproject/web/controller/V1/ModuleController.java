package com.example.platformproject.web.controller.V1;

import com.example.platformproject.domain.Module;
import com.example.platformproject.service.CourseService;
import com.example.platformproject.service.ModuleService;
import com.example.platformproject.web.annotation.ApiV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@ApiV1
@RequiredArgsConstructor
@Controller
public class ModuleController {

    @Autowired
    private ModuleService moduleService;
    @Autowired
    private CourseService courseService;

  /*   @GetMapping("/{courseName}")
   public List<Module> getModules(@PathVariable String courseName) {
        Long id = courseService.findCourseId(courseName);
        return moduleService.findModules(id);
    }

   */
}
