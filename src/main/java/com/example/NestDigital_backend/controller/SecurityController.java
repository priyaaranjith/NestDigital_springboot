package com.example.NestDigital_backend.controller;

import com.example.NestDigital_backend.dao.EmployeeDao;
import com.example.NestDigital_backend.dao.SecurityDao;
import com.example.NestDigital_backend.model.Employees;
import com.example.NestDigital_backend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/addSec",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> AddSecurity(@RequestBody Security s) {
        dao.save(s);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewAll")
    public List<Security> ViewSecurity(){
        return(List<Security>) dao.findAll();
    }
    @CrossOrigin(origins = "*")

    @PostMapping(path = "/searchSec", consumes = "application/json", produces = "application/json")
    public List<Security> SearchSecurity(@RequestBody Security s) {
        String sid = String.valueOf(s.getSid());
        System.out.println(sid);
        return (List<Security>) dao.SearchSecurity(s.getSid());
    }

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/deleteSec", consumes = "application/json", produces = "application/json")
    public HashMap DeleteSecurity(@RequestBody Security s) {
        String id = String.valueOf(s.getId());
        System.out.println(id);
        dao.DeleteSecurity(s.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewprofiles",consumes = "application/json",produces = "application/json")
    public List<Security> ViewProfiles(@RequestBody Security s){
        return (List<Security>) dao.ViewSecurity(s.getId());
    }

    @CrossOrigin("*")
    @PostMapping(path = "/loginSec", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> Securitylogin(@RequestBody Security s) {
        System.out.println(s.getUsername());
        List<Security> result = (List<Security>) dao.Securitylogin(s.getUsername(), s.getPassword());
        HashMap<String, String> map = new HashMap<>();
        if (result.size() == 0) {
            map.put("status", "failed");

        } else {
            map.put("status", "success");

        }
        return map;
    }








}
