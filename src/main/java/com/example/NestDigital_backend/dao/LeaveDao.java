package com.example.NestDigital_backend.dao;


import com.example.NestDigital_backend.model.Leaves;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository <Leaves,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaves` SET `id``status`= :status WHERE `id`= :id",nativeQuery = true)
    void updateById(Integer status,Integer id);

    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`description`, l.`empid`, l.`leave_date`, l.`status`,e.name,e.designation `type` FROM `leaves` l JOIN employees e ON l.empid=e.empid WHERE `status`=0",nativeQuery = true)
    List<Map<String,String>> viewAllLeaveBy();


    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`description`, l.`empid`, l.`leave_date`, l.`status`, l.`type`,e.name,e.designation FROM `leaves` l JOIN employees e ON l.empid=e.empid WHERE l.empid= :empid",nativeQuery = true)
    List<Map<String,String>>viewLeaveById(@Param("empid")Integer empid);
}


