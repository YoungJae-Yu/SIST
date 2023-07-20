package springweb.a05_mvcexp.z01_vo;
// springweb.a05_mvcexp.z01_vo.Student
public class Student {
	private int sno;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int strPoint;
	private int endPoint;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStrPoint() {
		return strPoint;
	}
	public void setStrPoint(int strPoint) {
		this.strPoint = strPoint;
	}
	public int getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}
	public Student(int sno, String name, int kor, int eng, int math) {
		super();
		this.sno = sno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
}
