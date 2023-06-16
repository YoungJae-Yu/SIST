package backWeb.saram_vo;

public class Match {
	private String placeOfWork; 
	private String comName;
	private String memCareer;
	private String hopeWorktype;
	private String fieldName;
	private int salary;
	private String receptionMethod;
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Match(String placeOfWork, String comName, String memCareer, String hopeWorktype, String fieldName,
			int salary, String receptionMethod) {
		super();
		this.placeOfWork = placeOfWork;
		this.comName = comName;
		this.memCareer = memCareer;
		this.hopeWorktype = hopeWorktype;
		this.fieldName = fieldName;
		this.salary = salary;
		this.receptionMethod = receptionMethod;
	}
	public Match(String placeOfWork) {
		super();
		this.placeOfWork = placeOfWork;
	}
	public String getPlaceOfWork() {
		return placeOfWork;
	}
	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getMemCareer() {
		return memCareer;
	}
	public void setMemCareer(String memCareer) {
		this.memCareer = memCareer;
	}
	public String getHopeWorktype() {
		return hopeWorktype;
	}
	public void setHopeWorktype(String hopeWorktype) {
		this.hopeWorktype = hopeWorktype;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getReceptionMethod() {
		return receptionMethod;
	}
	public void setReceptionMethod(String receptionMethod) {
		this.receptionMethod = receptionMethod;
	}
}
