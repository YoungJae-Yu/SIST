package javaexp.a09_inherit.abstrac;

import java.util.ArrayList;

public class A01_StarcraftWorld {

	public static void main(String[] args) {
		// 추상 클래스는 혼자 객체를 생성하지 못한다.
		// 추상 클래스의 목적이 하위 클래스의 공통 기능 선언과
		//    다형성(메서드 재정의를 통해)이기 때문에
		// 추상 클래스는 다형성 처리할 메서드를 강제성 있게 처리할 목적이기에
		// 실제 클래스가 필요없게 만든다.
//		Larba lb = new Larba("드론","빨강"); 에러 발생.
		Larba lb100 = new Dron(); // 추상 = 하위실제();
		lb100.move();  // 상속해서 사용할 공통 내용
		lb100.getUnit(); // 상속해서 사용할 공통 내용
		lb100.attack(); 
		// 상속해서 사용할 다형성 처리 내용, 재정의가 강제하고 있다.
		
		
		
		// TODO Auto-generated method stub
		/*
	    # 추상클래스의 목적
	    	1) 기능적인 통일성을 가진 상위클래스를 상속 받게하기 위한 것이다.
	    	 	- 기능적 통일성 
	    	 		공통 필드/메서드 : 그대로 재활용
	    	 		이름은 같지만 다양한 기능을 처리하는 메서드를 강제화 한다***
		# 추상클래스를 통한 실제클래스 만들기
			abstract class Larba{
				공통필드 : 유닉종류, 색상
				공통 생성자 : 매개변수1개 : 하위에 반드시 호출 
				공통메서드 : 유닉이 이동 한다..
				abstract 재정의 메서드(); : 유닉의 공격방법..
			}
			class Dron extends Larba{
				Dron(String color){
					super("드론",color);
				}
				// 위에 있는 abstract을 재정의하지 않으면 컴파일 에러.
			}
			
			
		
		# 추상클래스를 통한 다형성 처리하기
		 * */
		ArrayList<Larba> myUnits = new ArrayList<Larba>();
		myUnits.add(new Dron());
		myUnits.add(new Zerggling());
		myUnits.add(new Zerggling());
		myUnits.add(new Hydralisk());
		System.out.println("사용할 유닉들");
		for(Larba lb:myUnits) {
			lb.move(); // 공통메서드
			lb.attack(); // 재정의 메서드
		}
		
	}

}
// 추상메서드가 하나라도 있으면 추상클래스가 되고, 
// 드디어 혼자 객체생성을 하지 못한다. Larba l1 = new Larba(); (X)
// 다형성에 의해서 상속받은 하위객체가 할당할 때만 생성 
// Larba l1 = new Dron();
// Larba l2 = new Zerggling();
// Larba l3 = new Hydralist();
abstract class Larba{ 
	private String kind;
	//private String color;
	public Larba(String kind) {
		this.kind = kind;
		//this.color = color;
	}
	public String getUnit() {
		return kind;
	}
	// 공통 메서드.
	public void move() {
		System.out.println(kind+" 이동합니다.");
	}
	// 상속받는 하위에서 반드시 재정의 메서드
	public abstract void attack();
}
class Dron extends Larba{
	public Dron() {
		super("드론");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack() {
		System.out.println(getUnit()+" 채집유닉이라 공격을 못합니다.");
		System.out.println(getUnit()+" 공격력 5로 미약하게 공격합니다.");
	}
}
class Zerggling extends Larba{
	public Zerggling() {
		super("저글링");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack() {
		System.out.println(getUnit()+" 초기 공격 유닉으로 공격력 5로 빠르게 공격합니다.");
	}
}
class Hydralisk extends Larba{
	public Hydralisk() {
		super("히드라리스크");
	}
	@Override
	public void attack() {
		System.out.println(getUnit()+"중대형 공격 유닉으로 공격력 15로 원거리 공격합니다.");
		
	}
	@Override
	public void move() {
		super.move();
		System.out.println("속도 업그레이드시 빠르게 이동합니다.");
	}
}
