package com.alejandro.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springbootweb.dto.UserDto;
import com.alejandro.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto detailsRest() 
    {
        User user = new User("Alejandro", "Valenzuela");

        UserDto userDto = new UserDto();

        userDto.setTitle("Hello World Spring Boot");
        userDto.setUser(user);

        return userDto;
    }

    @GetMapping("/users/list")
    public List<User> listUser() 
    {
        User user = new User("Alejandro", "Valenzuela");
        User userExample = new User("Example", "LastName Example");
        User userExampleTwo = new User("Example 2", "LastName Example 2");

        final List<User> listUsers = Arrays.asList(user, userExample, userExampleTwo);

        return listUsers;
    }
}
