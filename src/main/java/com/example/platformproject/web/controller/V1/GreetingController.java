package com.example.platformproject.web.controller.V1;

import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
/*
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

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Example> getAllUsers() {
        // This returns a JSON or XML with the users
        return exampleRepository.findAll();
    } */
}
