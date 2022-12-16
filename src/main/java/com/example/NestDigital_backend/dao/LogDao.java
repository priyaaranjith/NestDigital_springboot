package com.example.NestDigital_backend.dao;

import com.example.NestDigital_backend.model.Logs;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<Logs,Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE `logS` SET`check_out`= :check_out,`out_date`=:out_date WHERE `id`= :id",nativeQuery = true)
    void logOutStatus(@Param("check_out")Integer check_out, @Param("out_date")String out_date,@Param("id") Integer id);

    @Query(value = "SELECT l.`id`, l.`check_in`, l.`empid`, l.`in_date`, l.`out_date`,e.name,e.designation FROM `logs` l JOIN employees e ON l.empid=e.empid",nativeQuery = true)
    List<Map<String,String>> viewAllLogBy();

    @Query(value = "SELECT l.`id`, l.`check_in`, l.`empid`, l.`in_date`, l.`out_date`,e.name FROM `logs`l JOIN employees e ON l.`empid`=e.empid WHERE l.`empid`= :empid",nativeQuery = true)
    List<Map<String,String>> viewlogByEmpid(@Param("empid")Integer empid);

    @Query(value = "SELECT l.`id`, l.`check_in`, l.`empid`, l.`in_date`, l.`out_date`,e.name,e.designation FROM `logs` l JOIN employees e ON l.empid=e.empid WHERE `check_out`=0",nativeQuery = true)
    List<Map<String,String>> viewlogByStatus();

    }





