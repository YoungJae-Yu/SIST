package springweb.a05_mvcexp.z01_vo;
// springweb.a05_mvcexp.z01_vo.EmpDept
public class EmpDept {
	private Emp emp;
	private Dept dept;
	public EmpDept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpDept(Emp emp, Dept dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
