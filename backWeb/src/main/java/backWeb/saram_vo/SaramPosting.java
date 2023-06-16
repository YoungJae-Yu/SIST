package backWeb.saram_vo;

import java.util.Date;

public class SaramPosting {
 private String postingId;
 private String comName;
 private String phoneNum;
 private String fieldName;
 private String taskInCharge;
 private String education;
 private String gender;
 private int salary;
 private Date recruitmentDate;
 private String receptionMethod;
 private String loc;
public SaramPosting() {
   // TODO Auto-generated constructor stub
}

public SaramPosting(String comName, String loc) {
   this.comName = comName;
   this.loc = loc;
}

public SaramPosting(String postingId, String comName, String phoneNum, String fieldName, String taskInCharge,
      String education, String gender, int salary, Date recruitmentDate, String receptionMethod, String loc) {
   this.postingId = postingId;
   this.comName = comName;
   this.phoneNum = phoneNum;
   this.fieldName = fieldName;
   this.taskInCharge = taskInCharge;
   this.education = education;
   this.gender = gender;
   this.salary = salary;
   this.recruitmentDate = recruitmentDate;
   this.receptionMethod = receptionMethod;
   this.loc = loc;
}
public String getPostingId() {
   return postingId;
}
public void setPostingId(String postingId) {
   this.postingId = postingId;
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
public String getLoc() {
   return loc;
}
public void setLoc(String loc) {
   this.loc = loc;
}

 
 
}