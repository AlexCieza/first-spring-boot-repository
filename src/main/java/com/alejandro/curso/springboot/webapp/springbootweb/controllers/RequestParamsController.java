package com.alejandro.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandro.curso.springboot.webapp.springbootweb.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Default") String message) 
    {
        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(message);

        return paramDto;
    } 

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code) 
    {
        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(text);
        paramDto.setCode(code);

        return paramDto;
    }

    @GetMapping("/requestNative")
    public ParamDto requestNative(HttpServletRequest httpServlet) 
    {
        ParamDto paramDto = new ParamDto();

        Integer code = 0;
        
        try {
            code = Integer.parseInt(httpServlet.getParameter("code"));   
        } catch (Exception e) {
        }

        paramDto.setMessage(httpServlet.getParameter("text"));
        paramDto.setCode(code);

        return paramDto;
    }
}
