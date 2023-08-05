package com.web.board.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "DEPT")
public class Dept {
    @Id
    @Column(name = "DEPTNO", nullable = false)	
	private Long deptno;
    @Column(name = "DNAME", nullable = false)
	private String dname;
    @Column(name = "LOC", nullable = false)
	private String loc;
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
