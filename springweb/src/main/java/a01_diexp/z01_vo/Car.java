package a01_diexp.z01_vo;

public class Car {
	private String model ;
	private int cc ;
	private int maximum  ;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String model, int cc, int maximum) {
		super();
		this.model = model;
		this.cc = cc;
		this.maximum = maximum;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
}
