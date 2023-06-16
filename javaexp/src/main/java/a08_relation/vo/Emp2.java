package javaexp.a08_relation.vo;

public class Emp2 {
	private int empno;
	private String ename;
	private int kor;
	private int eng;
	private int mt;
	public Emp2() {
		// TODO Auto-generated constructor stub
	}
	public Emp2(int empno, String ename, int kor, int eng, int mt) {
		this.empno = empno;
		this.ename = ename;
		this.kor = kor;
		this.eng = eng;
		this.mt = mt;
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMt() {
		return mt;
	}
	public void setMt(int mt) {
		this.mt = mt;
	}
}
