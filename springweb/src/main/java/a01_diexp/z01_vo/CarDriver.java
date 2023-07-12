package a01_diexp.z01_vo;

public class CarDriver {
	private String driver;
	private Car car;
	public CarDriver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void driving() {
		System.out.println("#운전한다#");
		System.out.println("운전자:"+driver);
		if(car!=null) {
			System.out.println("#탑승한 자동차 정보#");
			System.out.println("차종:"+car.getModel());
			System.out.println("배기량:"+car.getCc());
			System.out.println("최고속도:"+car.getMaximum());
		}else {
			System.out.println("자동차를 탑승하세요!");
		}
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public CarDriver(String driver) {
		super();
		this.driver = driver;
	}
}
