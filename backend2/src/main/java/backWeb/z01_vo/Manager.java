package backWeb.z01_vo;
//backWeb.z01_vo.Manager
public class Manager {
	private int empno;
	private String ename;
	private String dname;
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
	public String getDname() {
		return dname;
	}
	public void setDname(String danem) {
		this.dname = danem;
	}
	public Manager(int empno, String ename, String danem) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.dname = danem;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
