package project.janjan.VO;

public class Alcohol {
	private String alcoholName;
	private String alcoholType;
	private int degree;
	private int price;
	private int capacity;
	private String expDate;
	private String storageWay;
	private String alcoholImg;
	private String alcoholDet;
	
	public Alcohol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alcohol(String alcoholName, String alcoholType, int degree, int price, int capacity, String expDate,
			String storageWay, String alcoholImg, String alcoholDet) {
		super();
		this.alcoholName = alcoholName;
		this.alcoholType = alcoholType;
		this.degree = degree;
		this.price = price;
		this.capacity = capacity;
		this.expDate = expDate;
		this.storageWay = storageWay;
		this.alcoholImg = alcoholImg;
		this.alcoholDet = alcoholDet;
	}

	public String getAlcoholName() {
		return alcoholName;
	}

	public void setAlcoholName(String alcoholName) {
		this.alcoholName = alcoholName;
	}

	public String getAlcoholType() {
		return alcoholType;
	}

	public void setAlcoholType(String alcoholType) {
		this.alcoholType = alcoholType;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getStorageWay() {
		return storageWay;
	}

	public void setStorageWay(String storageWay) {
		this.storageWay = storageWay;
	}

	public String getAlcoholImg() {
		return alcoholImg;
	}

	public void setAlcoholImg(String alcoholImg) {
		this.alcoholImg = alcoholImg;
	}

	public String getAlcoholDet() {
		return alcoholDet;
	}

	public void setAlcoholDet(String alcoholDet) {
		this.alcoholDet = alcoholDet;
	}
	
	
	
}
