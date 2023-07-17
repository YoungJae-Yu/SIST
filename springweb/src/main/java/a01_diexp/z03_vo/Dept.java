package a01_diexp.z03_vo;

import org.springframework.stereotype.Component;

// backendWeb.z01_vo.Dept
@Component
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	public void joining() {
		if(dname!=null) {
			System.out.println(dname+" 부서에 입사했다!");
		}else {
			System.out.println("입사지원서를 제출하세요!");
		}
	}
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
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
