package backendWeb.z01_vo;

import java.util.Date;

public class Job_history {
	private int employee_id;
    private Date start_date;
    private String start_dateS;
    private Date end_date;
    private String end_dateS;
    private String job_id;
    private int deprtment_id;
	public Job_history() {
		// TODO Auto-generated constructor stub
	}
	public Job_history(int employee_id, String start_dateS, String end_dateS, String job_id, int deprtment_id) {
		this.employee_id = employee_id;
		this.start_dateS = start_dateS;
		this.end_dateS = end_dateS;
		this.job_id = job_id;
		this.deprtment_id = deprtment_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public String getStart_dateS() {
		return start_dateS;
	}
	public void setStart_dateS(String start_dateS) {
		this.start_dateS = start_dateS;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getEnd_dateS() {
		return end_dateS;
	}
	public void setEnd_dateS(String end_dateS) {
		this.end_dateS = end_dateS;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public int getDeprtment_id() {
		return deprtment_id;
	}
	public void setDeprtment_id(int deprtment_id) {
		this.deprtment_id = deprtment_id;
	}
    
}
