package com.example.NestDigital_backend.controller;

import com.example.NestDigital_backend.dao.LeaveDao;
import com.example.NestDigital_backend.dao.VisitorDao;
import com.example.NestDigital_backend.model.Employees;
import com.example.NestDigital_backend.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VisitorController {

    @Autowired
    private VisitorDao dao;

    @CrossOrigin(origins ="*")
    @PostMapping(path ="/viewdailyvisitorlog",consumes = "application/json",produces = "application/json")
    public List<Visitor> ViewDailyVisitorLog(@RequestBody Visitor v)
    {
        return (List<Visitor>) dao.ViewDailyVisitorLogg(v.getDate());

    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallvisitorlog")
    public List<Visitor> ViewAllVisitorLog()
    {
        return (List<Visitor>) dao.findAll();

    }

    @PostMapping("/addvisitor")
    public HashMap<String, String> AddEmployee(@RequestBody Visitor v) {
        dao.save(v);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

}
