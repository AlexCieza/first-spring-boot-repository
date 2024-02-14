package com.alejandro.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    
    @GetMapping({"", "/", "/home"})
    public String home() 
    {
        return "redirect:/list";
    }

    @GetMapping({"/home2"})
    public String home2() 
    {
        return "forward:/list";
    }
}
