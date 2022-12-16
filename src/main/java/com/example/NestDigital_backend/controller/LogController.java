package com.example.NestDigital_backend.controller;

import com.example.NestDigital_backend.dao.LogDao;
import com.example.NestDigital_backend.model.Logs;
import com.example.NestDigital_backend.model.Visitor;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    private LogDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addlog",consumes = "application/json",produces = "application/json")
    public String addLog(@RequestBody Logs l){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        l.setInDate(currentdate);
        l.setCheckOut(0);
        dao.save(l);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/logout",consumes = "application/json",produces = "application/json")
    public String logOutStatus(@RequestBody Logs l){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        l.setOutDate(currentdate);
        dao.logOutStatus(l.getCheckOut(),l.getOutDate(),l.getId());
        return "{status:success}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/viewalllogs",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewAllLog(@RequestBody Logs l){
        return (List<Map<String, String>>) dao.viewAllLogBy();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewlogbyid",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewLogByEmp(@RequestBody Logs l){
        return (List<Map<String, String>>) dao.viewlogByEmpid(l.getEmpid());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewcheckin")
    public List<Map<String,String>> viewAllcheckin(){
        return (List<Map<String, String>>) dao.viewlogByStatus();

    }




}






