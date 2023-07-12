package a01_diexp.z01_vo;

public class HandPhone {
	private String number;
	private String company;
	public HandPhone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HandPhone(String number, String company) {
		super();
		this.number = number;
		this.company = company;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
