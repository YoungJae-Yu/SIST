package backWeb.saram_vo;

import java.util.Date;

public class JobPosting {
	private String postId; 
	private String comName; 
	private String phoneNum; 
	private String placeOfWork; 
	private String fieldName; 
	private String taskInCharge; 
	private String education; 
	private String gender; 
	private int salary; 
	private Date recruitmentDate; 
	private String receptionMethod; 
	private String comId;
	public JobPosting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobPosting(String postId, String comName, String phoneNum, String placeOfWork, String fieldName,
			String taskInCharge, String education, String gender, int salary, Date recruitmentDate,
			String receptionMethod, String comId) {
		super();
		this.postId = postId;
		this.comName = comName;
		this.phoneNum = phoneNum;
		this.placeOfWork = placeOfWork;
		this.fieldName = fieldName;
		this.taskInCharge = taskInCharge;
		this.education = education;
		this.gender = gender;
		this.salary = salary;
		this.recruitmentDate = recruitmentDate;
		this.receptionMethod = receptionMethod;
		this.comId = comId;
	}
	public JobPosting(String comName, String placeOfWork, String fieldName, int salary, String receptionMethod) {
		super();
		this.comName = comName;
		this.placeOfWork = placeOfWork;
		this.fieldName = fieldName;
		this.salary = salary;
		this.receptionMethod = receptionMethod;
	}
	public JobPosting(String comName, String phoneNum, String placeOfWork, String fieldName, String taskInCharge,
			String education, int salary, Date recruitmentDate, String receptionMethod) {
		super();
		this.comName = comName;
		this.phoneNum = phoneNum;
		this.placeOfWork = placeOfWork;
		this.fieldName = fieldName;
		this.taskInCharge = taskInCharge;
		this.education = education;
		this.salary = salary;
		this.recruitmentDate = recruitmentDate;
		this.receptionMethod = receptionMethod;
	}
	public JobPosting(String placeOfWork, String fieldName) {
		super();
		this.placeOfWork = placeOfWork;
		this.fieldName = fieldName;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPlaceOfWork() {
		return placeOfWork;
	}
	public void setPlaceOfWork(String placeOfWork) {
		this.placeOfWork = placeOfWork;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getTaskInCharge() {
		return taskInCharge;
	}
	public void setTaskInCharge(String taskInCharge) {
		this.taskInCharge = taskInCharge;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getRecruitmentDate() {
		return recruitmentDate;
	}
	public void setRecruitmentDate(Date recruitmentDate) {
		this.recruitmentDate = recruitmentDate;
	}
	public String getReceptionMethod() {
		return receptionMethod;
	}
	public void setReceptionMethod(String receptionMethod) {
		this.receptionMethod = receptionMethod;
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public JobPosting(String placeOfWork) {
		super();
		this.placeOfWork = placeOfWork;
	}
}
