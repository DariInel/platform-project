package com.example.platformproject.web.controller;

import com.example.platformproject.domain.Example;
import com.example.platformproject.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private ExampleRepository exampleRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping(produces = "text/html; charset=utf-8")
    public String main(Map<String, Object> model){
        Iterable<Example> examples = exampleRepository.findAll();

        model.put("examples", examples);
        return "main";
    }

    @PostMapping(produces = "text/html; charset=utf-8")
    public String add(@RequestParam String firstName, @RequestParam String secondName, Map<String, Object> model){
        Example example = new Example(firstName, secondName);
        exampleRepository.save(example);
        Iterable<Example> examples = exampleRepository.findAll();

        model.put("examples", examples);
        return "main";
    }

/*    @GetMapping(path="/all")
    public @ResponseBody Iterable<Example> getAllUsers() {
        // This returns a JSON or XML with the users
        return exampleRepository.findAll();
    } */
}
