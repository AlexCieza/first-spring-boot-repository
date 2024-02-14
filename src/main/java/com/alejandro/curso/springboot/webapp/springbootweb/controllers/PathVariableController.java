package com.alejandro.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springbootweb.dto.ParamDto;
import com.alejandro.curso.springboot.webapp.springbootweb.models.User;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/path")
public class PathVariableController {

    @Value("${config.code}")
    private Integer code;
    @Value("${config.username}")
    private String username;
    @Value("${config.list}")
    private List<String> list;
    @Value("#{ '${config.list}'.split(',')}")
    private String listChange;
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Autowired
    private Environment environment;
    
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(message);

        return paramDto;
    }

    @PostMapping("/create")
    public User postMethodName(@RequestBody User user) {
        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> map = new HashMap<>();

        map.put("code", code);
        map.put("code2", Integer.parseInt(environment.getProperty("config.code", "0")));
        map.put("username", username);
        map.put("list", list);
        map.put("listChange", listChange);
        map.put("valuesMap", valuesMap);
        map.put("product", product);

        return map;
    }
}
