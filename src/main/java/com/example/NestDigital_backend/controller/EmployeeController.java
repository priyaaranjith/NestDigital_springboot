package com.example.NestDigital_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeController {

    @GetMapping("/")
    public String HomePage(){
        return "Welcome to Employeepage";
    }

    @PostMapping("/emplogin")
    public String EmployeeLogin(){
        return "Employee login";
    }


}
