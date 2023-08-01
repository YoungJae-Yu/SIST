package com.web.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.board.dao.A01_Dao;
import com.web.board.vo.Emp;

@Service
public class A01_Service {
	@Autowired
	private A01_Dao dao;
	public List<Emp> empList(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		return dao.empList(sch);
	}
}
