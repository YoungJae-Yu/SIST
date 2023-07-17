package a01_diexp.z02_vo;

import org.springframework.stereotype.Component;

//a01_diexp.z01_vo.Car CarDriver
@Component("cardriver01")// 변경된 id 를 사용할 수 있다.
public class CarDriver {
	private String name;
	private Car car;
	public CarDriver() {
		// TODO Auto-generated constructor stub
	}
	public CarDriver(String name) {
		this.name = name;
	}
	public void driving() {
		System.out.println("자동차를 "+name+" 타고 운행할려고 합니다.");
		if(car!=null) {
			System.out.println("# 운행할 차량 정보 #");
			System.out.println("자동차 종류:"+car.getKind());
			System.out.println("배기량:"+car.getCc());
			System.out.println("최고속도:"+car.getMaxVel());
		}else {
			System.out.println("소유한 차량이 없네요. ㅠㅠ");
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
	public void setCar02(Car car) {
		this.car = car;
	}
	
}
