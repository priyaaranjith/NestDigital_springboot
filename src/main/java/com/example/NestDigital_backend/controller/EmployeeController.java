package com.example.NestDigital_backend.controller;

import com.example.NestDigital_backend.dao.EmployeeDao;
import com.example.NestDigital_backend.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")

    @GetMapping("/")
    public String HomePage() {
        return "Welcome to Employeepage";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Employees> ViewEmployees(){
        return (List<Employees>)dao.findAll();
    }


    @CrossOrigin("*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> Emplogin(@RequestBody Employees e) {
        System.out.println(e.getUsername());
        List<Employees> result = (List<Employees>) dao.Emplogin(e.getUsername(), e.getPassword());
        HashMap<String, String> map = new HashMap<>();
        if (result.size() == 0) {
            map.put("status", "failed");

        } else {
            map.put("status", "success");

        }
        return map;
    }

    @CrossOrigin(origins = "*")

    @PostMapping("/add")
    public HashMap<String, String> AddEmployee(@RequestBody Employees e) {
        dao.save(e);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Employees> SearchEmployee(@RequestBody Employees e) {
        String empid = String.valueOf(e.getEmpid());
        System.out.println(empid);
        return (List<Employees>) dao.SearchEmployee(e.getEmpid());
    }

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public HashMap DeleteEmployee(@RequestBody Employees e) {
        String id = String.valueOf(e.getId());
        System.out.println(id);
        dao.DeleteEmployee(e.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewprofile",consumes = "application/json",produces = "application/json")
    public List<Employees> ViewProfile(@RequestBody Employees e){
        return (List<Employees>) dao.ViewEmployee(e.getId());
    }



}
