package com.web.board.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.web.board.model.Dept;

public interface DeptRepository extends JpaRepository<Dept, Long> {
    @Query("SELECT d FROM Dept d WHERE d.dname LIKE %:#{#sch.dname}%  AND d.loc LIKE %:#{#sch.loc}%")
    List<Dept> findByNameAndLoc(@Param("sch") Dept sch);



}