package backWeb.z01_vo;
// backWeb.z01_vo.Salgrade
public class Salgrade {
	private int grade;
	private int losal;
	private int hisal;
	public Salgrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Salgrade(int grade, int losal, int hisal) {
		super();
		this.grade = grade;
		this.losal = losal;
		this.hisal = hisal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getLosal() {
		return losal;
	}
	public void setLosal(int losal) {
		this.losal = losal;
	}
	public int getHisal() {
		return hisal;
	}
	public void setHisal(int hisal) {
		this.hisal = hisal;
	}
}
