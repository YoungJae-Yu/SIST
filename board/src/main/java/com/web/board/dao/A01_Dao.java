package com.web.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.board.vo.Emp;
// com.web.board.dao.A01_Dao
@Mapper
public interface A01_Dao {
	public List<Emp> empList(Emp sch);
}
