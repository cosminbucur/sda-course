package com.sda.spring.boot.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    public static final String HELLO_VIEW = "hello";

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/hello")
    public String sayHello(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return HELLO_VIEW;
    }
}
