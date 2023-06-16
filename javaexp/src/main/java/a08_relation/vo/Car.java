package javaexp.a08_relation.vo;

public class Car {
//	자동차종류, 배기량
//	driving() @@자동차가 운행을 합니다.
	private String carName;
	private int carCC;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public void driving() {
		System.out.println(carName+"자동차를 운행합니다.");
	}
	public Car(String carName, int carCC) {
		this.carName = carName;
		this.carCC = carCC;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getCarCC() {
		return carCC;
	}
	public void setCarCC(int carCC) {
		this.carCC = carCC;
	}
	
}
