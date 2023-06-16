package backWeb.saram_vo;

public class Member {
    private int memberid;
    private String memName;
    private int memBirth;
    private String memSex;
    private int memPhone;
    private String memEmail;
    private String memAddr;
    private String empNoticeld;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int memberid, String memName, int memBirth, String memSex, int memPhone, String memEmail,
			String memAddr, String empNoticeld) {
		super();
		this.memberid = memberid;
		this.memName = memName;
		this.memBirth = memBirth;
		this.memSex = memSex;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
		this.memAddr = memAddr;
		this.empNoticeld = empNoticeld;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(int memBirth) {
		this.memBirth = memBirth;
	}
	public String getMemSex() {
		return memSex;
	}
	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}
	public int getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(int memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public String getEmpNoticeld() {
		return empNoticeld;
	}
	public void setEmpNoticeld(String empNoticeld) {
		this.empNoticeld = empNoticeld;
	}
}