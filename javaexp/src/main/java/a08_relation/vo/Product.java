package javaexp.a08_relation.vo;

public class Product {
	private String name;
	private int price;
	private int cnt;
	public String getName() {
		return name;
	}
//	출력과 함께 단위계를 리턴 처리..
	public int totBuyInfo() {
		System.out.print(name+"\t");
		System.out.print(price+"\t");
		System.out.print(cnt+"\t");
		int tot = price*cnt;
		System.out.print(tot+"\n");
		return tot;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPirce() {
		return price;
	}
	public void setPirce(int pirce) {
		this.price = pirce;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Product(String name, int pirce, int cnt) {
		this.name = name;
		this.price = pirce;
		this.cnt = cnt;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
}
