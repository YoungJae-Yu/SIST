package javaexp.a08_relation.vo;

public class CarRacer {
//  필드 : 이름, Car
//  메서드 : buyCar()
//		   drivingCar()
//			Car객체가 있으면 @@가 차를 운행
//			TT차가 없네요..
	private String name;
	private Car car;
	
	public CarRacer(String name) {
		this.name = name;
	}
	public void buyCar(Car car) {
		this.car = car;		
		System.out.println(name+" "+
		car.getCarName()+"차량을 구매하다.");
	}
	public void drivingCar() {
		System.out.println(name+"운행하려합니다.");
		if(car==null) {
			System.out.println("TT 차가 없네요..");
		}else {
			car.driving();
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public CarRacer() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
