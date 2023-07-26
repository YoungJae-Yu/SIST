package springweb.a05_mvcexp.z01_vo;

public class EmployeesJobs {
	private Employee employee;
	private Job jobs;
	public EmployeesJobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeesJobs(Employee employee, Job jobs) {
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
	public Job getJobs() {
		return jobs;
	}
	public void setJobs(Job jobs) {
		this.jobs = jobs;
	}
}
