package backWeb.saram_vo;
//backWeb.saram_vo.Company
import java.util.Date;

public class Company {
	   private String comId;      // 사업자 id
	   private String comName;      // 기업명
	   private String comType;      // 기업형태
	   private String businessType;   // 업종
	   private long sales;         // 매출액
	   private Date comBirth;      // 설립일
	   private String ceoName;      // 대표자명
	   private int empCnt;         // 사원 수
	   private String comAddr;      // 사업자 주소
	   private String comEmail;   // 이메일
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(String comId, String comName, String comType, String businessType, long sales, Date comBirth,
			String ceoName, int empCnt, String comAddr, String comEmail) {
		super();
		this.comId = comId;
		this.comName = comName;
		this.comType = comType;
		this.businessType = businessType;
		this.sales = sales;
		this.comBirth = comBirth;
		this.ceoName = ceoName;
		this.empCnt = empCnt;
		this.comAddr = comAddr;
		this.comEmail = comEmail;
	}
	public String getComId() {
		return comId;
	}
	public Company(String comName, String comType) {
		super();
		this.comName = comName;
		this.comType = comType;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getComType() {
		return comType;
	}
	public void setComType(String comType) {
		this.comType = comType;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public long getSales() {
		return sales;
	}
	public void setSales(long sales) {
		this.sales = sales;
	}
	public Date getComBirth() {
		return comBirth;
	}
	public void setComBirth(Date comBirth) {
		this.comBirth = comBirth;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public int getEmpCnt() {
		return empCnt;
	}
	public void setEmpCnt(int empCnt) {
		this.empCnt = empCnt;
	}
	public String getComAddr() {
		return comAddr;
	}
	public void setComAddr(String comAddr) {
		this.comAddr = comAddr;
	}
	public String getComEmail() {
		return comEmail;
	}
	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}
}
