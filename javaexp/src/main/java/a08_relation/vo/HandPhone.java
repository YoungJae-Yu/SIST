package javaexp.a08_relation.vo;

public class HandPhone {
	private String proCompany;
	private int price;
	public HandPhone() {
		// TODO Auto-generated constructor stub
	}
	public HandPhone(String proCompany, int price) {
		this.proCompany = proCompany;
		this.price = price;
	}
	public void usingPhone() {
		System.out.println(proCompany+"폰으로 전화를 걸다!!");
	}
	public void showInfo() {
		System.out.println("핸드폰 정보");
		System.out.println("제조사:"+proCompany);
		System.out.println("가격:"+price);
	}
	public String getProCompan() {
		return proCompany;
	}
	public void setProCompan(String proCompany) {
		this.proCompany = proCompany;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
