package backendWeb.z01_vo;

public class Calculator {
	private int num01;
	private int num02;
	private String cal;
	private int tot;
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	public Calculator(int num01, int num02, String cal, int tot) {
		this.num01 = num01;
		this.num02 = num02;
		this.cal = cal;
		this.tot = tot;
	}
	public int getNum01() {
		return num01;
	}
	public void setNum01(int num01) {
		this.num01 = num01;
	}
	public int getNum02() {
		return num02;
	}
	public void setNum02(int num02) {
		this.num02 = num02;
	}
	public String getCal() {
		return cal;
	}
	public void setCal(String cal) {
		this.cal = cal;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	
	
}
