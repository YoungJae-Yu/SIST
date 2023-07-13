package a01_diexp.z01_vo;
// a01_diexp.z01_vo.HPUser
public class HPUser {
	private String name;
	private HandPhone handPhone;
	public HPUser() {
		// TODO Auto-generated constructor stub
	}
	public HPUser(String name) {
		this.name = name;
	}
	public void usingMyPhone() {
		System.out.println("#핸드폰 사용#");
		System.out.println("사용자:"+name);
		if(handPhone!=null) {
			System.out.println("#소유한 핸드폰 정보#");
			System.out.println("폰번호:"+handPhone.getNumber());
			System.out.println("폰제조사:"+handPhone.getCompany());
		}else {
			System.out.println("소유한 핸드폰이 없네요");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HandPhone getHandPhone() {
		return handPhone;
	}
	public void setHandPhone(HandPhone handPhone) {
		this.handPhone = handPhone;
	}
	
}
