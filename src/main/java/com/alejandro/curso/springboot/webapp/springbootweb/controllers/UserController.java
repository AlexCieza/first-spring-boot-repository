package com.alejandro.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alejandro.curso.springboot.webapp.springbootweb.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) 
    {
        User user = new User("Alejandro", "Valenzuela");

        user.setEmail("alejandro@email.com");

        model.addAttribute("title", "Hello World Spring Boot");
        model.addAttribute("user", user);

        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) 
    {

        model.addAttribute("title", "Hello World Spring Boot");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel()
    {
        return Arrays.asList(
            new User("Alejandro", "Valenzuela", "Email Alejandro"),
            new User("Example", "LastName Example", "Email Example"),
            new User("Example 2", "LastName Example 2")
        );
    }
}
