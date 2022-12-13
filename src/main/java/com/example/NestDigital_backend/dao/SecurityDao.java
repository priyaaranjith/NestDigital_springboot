package com.example.NestDigital_backend.dao;

import com.example.NestDigital_backend.model.Employees;
import com.example.NestDigital_backend.model.Security;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

public interface SecurityDao extends CrudRepository<Security, Integer> {

    @Query(value = "SELECT `id`, `sid`, `email`, `name`, `password`, `phone`, `salary`, `username` FROM `security` WHERE `sid` LIKE %:sid%",nativeQuery = true)
    List<Security>SearchSecurity (@Param("sid") Integer sid);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `security` WHERE `id`= :id",nativeQuery = true)
    void DeleteSecurity(@Param("id") Integer id);

    @Query(value = "SELECT `id`, `sid`, `email`, `name`, `password`, `phone`, `salary`, `username` FROM `security` WHERE `id`= :id",nativeQuery = true)
    List<Security>ViewSecurity(@Param("id") Integer id);


    @Query(value = "SELECT `id`, `sid`, `email`, `name`, `password`, `phone`, `salary`, `username` FROM `security` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<Security> Securitylogin(@Param("username") String username , @Param("password") String password);

}
