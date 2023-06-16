package javaexp.a08_relation.vo;

public class Emp {
	private int empno;
	private String ename;
	private String job;
	private double sal;
	private int deptno;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(int empno, String ename, String job, double sal, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
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
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
