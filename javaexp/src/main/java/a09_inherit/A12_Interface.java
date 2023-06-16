package javaexp.a09_inherit;

public class A12_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 인터페이스..
		1. 인터페이스이해를 위한 이야기..
			Robot
			
			MZ : 지구, 초창 하늘을 날지 못 함.
				Mz에서 Flyway를 중앙장치로 컨트롤 할 수 있는 메모리
					(날개를 제어하는 제어장치)
				외부에서 실제 객체가 들어올 수 있는 입출력 메서드가 있어야함
					(어께에 실제 날개가 붙을 수 있게 처리)
			Flyway (인터페이스) : 날게됨..
				껍데기(어깨에 정보를 입/출하게하는 처리 장치를 붙여) 
					중앙 처리장치에는 이 입/출력을 받아서 기기를 제어하게 처리.
			Fly1호를 만들기 : 날개가 부착해서  붙여 놓은 인터페이스에 의해
			 		정보를 처리하게 함..(실제객체)
			Fly2호..Fly3호. 		
		2. 인터페이스란?	
			1) 개발 코드와 객체가 서로 통신하는 접점.
				- 개발 코드는 인터페이스의 메서드만 알고 있으면 OK
			2) 역할 
				- 개발 코드가 객체에 종속되지 않고 실제 객체가 교체할 수 있도록
					하는 역할..
				- 개발 코드 변경 없이 리턴값 또는 실행 내용이 다양해 질 수 있음.
			ex) Mz의 어깨위에 날개를 인식할 수 있는 장치가 인터페이스고
				이 인터페이스를 상속받아서 실제 날개1호, 날개2호등이 부착되어
				계속 업그레이드가 가능하게 만듦...
		 3. 인터페이스의 활용
		 	1) 인터페이스의 이름 - 자바 식별자 작성 규칙에 의해 대문자 시작으로 작성
		 	2) 소스 파일 또는 클래스 하위에서 생성
		 	3) 선언 
		 		접근제어자 interface 인터페이스명{}
		 	4) 구성요소
		 	 	상수 : 인터페이스에 선언된 모든 변수는 기본적으로 상수이다.
		 	 		int FLYNO=1;  앞에 public static final이
		 	 			자동을 붙는다.
		 	 	메서드 : 인터페이스의 재정의 메서드는 기본적으로 추상메서드이다.
		 	 		void fly(); 앞에 public abstract 생략..
		 	 	기타 : 디폴드 메서드, 정적 메소드 지원
		 	 		default 리턴유형 메서드명(){
			 	 		//공통으로 사용할 기능 메서드 : 상속받은 실제 클래스에서
			 	 		//사용할 공통 기능.. 
		 	 		}
		 	 		public static 리턴유형 메서드명(){// 인터페이스 혼자 사용할 수 있는
		 	 			기능선언..
		 	 			인터페이스명.메서드명();
		 	 		}
		 	 5) 인터페이스는 다중 상속이 가능하다.
		 	 	- extends 클래스 상속은 부모를 1개만 상속할 수 있지만
		 	 	인터페이스는 여러개의 상위 객체를 implements할 수 있다.
		 	 	기능적으로 여러개의 상위 인터페이스를 상속받아서 재정의 할 수 있다.
		 	 	#상위의 부모를 하나밖에 상속하지 못하는 것을 확장시켜
		 	 	기능적으로 여러 내용을 인터페이스에 의해 처리가능하게끔
		 	 	처리하는 기능이라 할 수 있다...
		 	 	ex) class 클래스명 extends 하나만선언
		 	 	ex) class 클래스명 implements 인터페이스1, 인터페이스2...

		# 처리순서
		1. 상위 인터페이스 선언
		2. 재정의할 메서드 선언
		3. 하위 실제 객체 선언	
		4. 다형성 처리 1:1관계
		 * */
		// 다형성 처리
		Wing w01 = new Wing01();
		w01.fly();
		Wing w02= new Wing02();
		w02.fly();
		// ex) SwimmingWay 인터페이스를 선언하고 상수로 "수영" 추상메서드 swimming()
		//     Swimming01 우리동네 풀장을 수영하다. Swimming02 호수를 수영하다..
		//     로 선언하여 다형성으로 호출 처리하세요..
		SwimmingWay sw1 = new Swimming01();
		SwimmingWay sw2 = new Swimming02();
		sw1.swimming();
		sw2.swimming();
		Robot r1 = new Robot("MZ");
		r1.adapterWing(new Wing01());
		r1.adapterWing(new Wing02());
		r1.flying();
		
		SwimmingPlayer wp1 = new SwimmingPlayer("홍길동");
		wp1.addSkill(new Swimming01());
		wp1.addSkill(new Swimming02());
		wp1.swimming();
		
	}
}
// ex) SwimmingPlayer 클래스 선언하여, 이름과 SwimmingWay로 필드선언
//     addSkill()로 SwimmingWay 할당하여, 
//     swimming()메서드를 통해, 해당 선수의 이름과 수영하는 것을 처리하세요.
class SwimmingPlayer{
	private String name;
	private SwimmingWay swimmingWay;
	public SwimmingPlayer(String name) {
		this.name = name;
	}
	public void addSkill(SwimmingWay swimmingWay) {
		this.swimmingWay= swimmingWay;
		System.out.println(name+" 수영 기술을 익혔습니다.");
	}
	public void swimming() {
		System.out.print(name+" ");
		if(swimmingWay==null) {
			System.out.println("아직 수영 기술을 익히지 못 했습니다.");
		}else {
			swimmingWay.swimming();
		}
	}
}



interface SwimmingWay{
	String ACTION="수영하다";
	void swimming();
}
class Swimming01 implements SwimmingWay{
	@Override
	public void swimming() {
		System.out.println("우리동네 풀장을 "+ACTION);
	}
}
class Swimming02 implements SwimmingWay{
	@Override
	public void swimming() {
		System.out.println("호수를 "+ACTION);
	}
}
class Robot{
	private String kind;
	// 인터페이식을 인식할 수 있는 메모리 선언..
	private Wing wing;
	public Robot(String kind) {
		this.kind = kind;
	}
//	r.adapterwing
	public void adapterWing(Wing wing) {
		this.wing = wing;
		System.out.println(Wing.NAME+"를 " + kind+"어깨에 붙이다");
	}
	public void flying() {
		System.out.print(kind+ "로봇은 ");
		if(wing==null) {
			System.out.println("아직 날지 못한다.");
		}else {
			wing.fly();
		}
	}
}



interface Wing{
	String NAME ="날개"; // public static final 생략..
	void fly(); // public abstract 생략됨..
}
// 인터페이스를 상속 받을 때는 implements 인터페이스로 선언한다.
class Wing01 implements Wing{
//	NAME="날개 1호"; public static final이기에 변경 불가..
	// 반드시 재정의 하여야 한다.
	@Override
	public void fly() {
		System.out.println(NAME+" 1호로 우리 동네를 날아다니다.");
	}
}
class Wing02 implements Wing{
	@Override
	public void fly() {
		System.out.println(NAME+" 2호로 아시아를 날아다니다.");
	}
}