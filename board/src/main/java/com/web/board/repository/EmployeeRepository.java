package com.web.board.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.board.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.ename LIKE %:#{#sch.ename}%  AND e.job LIKE %:#{#sch.job}%")
    List<Employee> findByNameAndJob(@Param("sch") Employee sch);



}