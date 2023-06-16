package backWeb.z01_vo;

public class Product {
	private String name;
	private int price;
	private int number;
	private String info;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Product(String name, int price, int number, String info) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
		this.info = info;
	}
}
