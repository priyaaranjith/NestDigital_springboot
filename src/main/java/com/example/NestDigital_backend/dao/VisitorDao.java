package com.example.NestDigital_backend.dao;

import com.example.NestDigital_backend.model.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

public interface VisitorDao extends CrudRepository<Visitor,Integer> {

        @Query(value = "SELECT `id`, `entry_datetime`, `exit_datetime`, `name`, `purpose`, `whomtomeet`, `date` FROM `visitors` WHERE `date`= :date",nativeQuery = true)
        List<Visitor>ViewDailyVisitorLogg(@Param("date") String date);


    }



