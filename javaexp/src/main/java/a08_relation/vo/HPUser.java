package javaexp.a08_relation.vo;

public class HPUser {
	private String name;
	private HandPhone hp;
	public HPUser() {
		// TODO Auto-generated constructor stub
	}
	public HPUser(String name) {
		this.name = name;
	}
//	필드에 선언되어 있는 HandPhone메모리에 실제 객체가 할당되는
//	처리하는 메서드..
	public void setName(String name) {
		this.name = name;
	}
//	main()
//	
//	us01.setName( "홍길동" );
//	us01.buyPhone( new HandPhone() );
	public void buyPhone(HandPhone hp){
		this.hp = hp;
		System.out.print(hp.getProCompan()+"사 핸드폰을");
		System.out.println(hp.getPrice()+"원으로 구매하다.");
		
	}// : 핸드폰객체 구매 
	public void callbyPhone(){
		System.out.println(name+"가 핸드폰을 사용하려고 합니다.");
		if(hp==null) {
			System.out.println("구매하지 않아서 사용불가능합니다.");
		}else { //hp 메모리가 있을 때.. hp!=null
			hp.usingPhone();
		}
	}// : 핸드폰으로 전화
	public void checkMyPhoneInfo(){
		
	}// : 핸드폰 정보 확인
	public String getName() {
		return name;
	}

	public HandPhone getHp() {
		return hp;
	}
	public void setHp(HandPhone hp) {
		this.hp = hp;
	}
	
}
