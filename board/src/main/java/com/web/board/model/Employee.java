package com.web.board.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "EMP")
public class Employee {
    @Id
    @Column(name = "EMPNO", nullable = false)	
	private Long empno;
    @Column(name = "ENAME", nullable = false)
	private String ename;
    @Column(name = "JOB", nullable = false)
	private String job;
    @Column(name = "MGR", nullable = false)
	private Long mgr;
    @Column(name = "HIREDATE", nullable = false)
	private Date hiredate;
    @Column(name = "SAL", nullable = false)
	private Double sal;
    @Column(name = "comm", nullable = false)
	private Double comm;
    @Column(name = "DEPTNO", nullable = false)
	private Long deptno;
	public Long getEmpno() {
		return empno;
	}
	public void setEmpno(Long empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Long getMgr() {
		return mgr;
	}
	public void setMgr(Long mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

    
}
