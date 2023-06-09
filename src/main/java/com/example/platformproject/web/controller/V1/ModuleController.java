package com.example.platformproject.web.controller.V1;

import com.example.platformproject.domain.Module;
import com.example.platformproject.service.ModuleService;
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
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private SubmoduleService submoduleService;

    @GetMapping("/module/{moduleName}")
    public ModelAndView getSubmodules(@PathVariable String moduleName, Model model) {
        Module module = moduleService.findModule(moduleName);
        model.addAttribute("name", moduleName);
        model.addAttribute("module", module);
        model.addAttribute("submodules", submoduleService.findSubmodules(module.getId()));
        return new ModelAndView("module");
    }
}
