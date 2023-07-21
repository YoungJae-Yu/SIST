package springweb.a05_mvcexp.z01_vo;

public class EmployeesJobs {
	private Employee employee;
	private Jobs jobs;
	public EmployeesJobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeesJobs(Employee employee, Jobs jobs) {
		super();
		this.employee = employee;
		this.jobs = jobs;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Jobs getJobs() {
		return jobs;
	}
	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
}
