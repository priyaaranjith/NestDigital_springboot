package com.example.NestDigital_backend.dao;

import com.example.NestDigital_backend.model.Employees;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employees,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `empid`, `name`, `password`, `phone`, `salary`, `username` FROM `employees` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<Employees> Emplogin(@Param("username") String username , @Param("password") String password);

    @Query(value = "SELECT `id`, `designation`, `email`, `empid`, `name`, `password`, `phone`, `salary`, `username` FROM `employees` WHERE `empid` LIKE %:empid%",nativeQuery = true)
    List<Employees>SearchEmployee (@Param("empid") Integer empid);


}
