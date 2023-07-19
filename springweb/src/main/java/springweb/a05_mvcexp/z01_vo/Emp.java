package springweb.a05_mvcexp.z01_vo;
// springweb.a05_mvcexp.z01_vo.Emp
import java.util.Date;
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private String hiredateS;
	private Double sal;
	private Double comm;
	private int deptno;
	private Double minSal;
	private Double maxSal;
	
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	// 검색시 필요한 ename, job
	public Emp(String ename, String job) {
		this.ename = ename;
		this.job = job;
	}	
	/*

	SET ENAME = '오길동(upt)',
	    job = '대리',
	    sal = 5000,
	    hiredate = to_date('2023/06/01','YYYY/MM/DD')
    WHERE empno = 7369
	Emp(7369, "오길동(upt)", "대리", "2023/06/01",5000.0)
	*/
	
	public Emp(String ename, Double minSal, Double maxSal) {
		super();
		this.ename = ename;
		this.minSal = minSal;
		this.maxSal = maxSal;
	}
	public Emp(int empno, String ename, String job,
			String hiredateS, Double sal) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredateS = hiredateS;
		this.sal = sal;
	}	

	public Emp(int empno, String ename, String job, int mgr, 
			String hiredateS, Double sal, Double comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredateS = hiredateS;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public Emp(int empno, String ename, String job, int mgr, Date hiredate, Double sal, Double comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
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

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
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

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getHiredateS() {
		return hiredateS;
	}
	public void setHiredateS(String hiredateS) {
		this.hiredateS = hiredateS;
	}
	public Double getMinSal() {
		return minSal;
	}
	public void setMinSal(Double minSal) {
		this.minSal = minSal;
	}
	public Double getMaxSal() {
		return maxSal;
	}
	public void setMaxSal(Double maxSal) {
		this.maxSal = maxSal;
	}

	
}
