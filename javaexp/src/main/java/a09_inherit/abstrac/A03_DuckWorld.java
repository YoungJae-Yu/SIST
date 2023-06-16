package javaexp.a09_inherit.abstrac;

public class A03_DuckWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duck d1 = new NormalDuck();
		d1.swimming(); d1.fly();
		Duck d2 = new Mallard();
		d2.swimming(); d2.fly();
		/*ex) 
		하위에 RubberDuck
			추상클래스 상속받아서 처리하되,
			swimming()재정의해서 목욕탕에서 놀다.
			추가 메서드 usingForKids() 아이들을 위해 만들어졌다.
		 * */
		Duck d3 = new RubberDuck();
		d3.swimming(); d3.fly();
//		d3.usingForKids(); 추가된 다형성에서 처리되지 않는다.(다형성 한계)
		RubberDuck d4 = (RubberDuck)d3; // 타입캐스팅
		d4.usingForKids();
		RubberDuck d5 = new RubberDuck(); // 초기 생성할 때, 해당 객체로 생성
		d5.usingForKids();
	}

}
class RubberDuck extends Duck{

	public RubberDuck() {
		super("고무오리");
		// TODO Auto-generated constructor stub
	}
	void swimming() {
		System.out.println("우리집 목욕탕에서 ");
		super.swimming();
	}
	@Override
	void fly() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"는 우리집 목욕탕에서만 놀아요!! 날지 못함.");
	}
	// 하위 클래스에서 추가된 내용
	void usingForKids() {
		System.out.println(getKind()+" 는 아이들만 주로 사용합니다.");
	}
	
}


/*
ex) 아래와 같이 추상클래스 Duck을 선언하여 main()에서 호출하세요
	Duck (추상)
		kind 종류(필드)
		매개변수1개 생성자
		swimming() 수영을 하다(공통)
		getKind() 공통
		fly() 추상메서드
	NormalDuck(실제클래스) 일반오리 : fly() 나르지 못하다.
	Mallard(실제클래스) 청둥오리	: fly() 훨훨 나르다.
 * */
abstract class Duck{
	private String kind;
	public Duck(String kind) {
		this.kind = kind;
	}
	// 공통 메서드
	void swimming() {
		System.out.println(kind+" 수영을 하다");
	}
	public String getKind() {
		return kind;
	}
	// 추상 메서드
	abstract void fly();
}
class NormalDuck extends Duck{
	/*
	# 상속을 하면
	1. 상위 생성자를 호출해야한다.
		super(매개변수) : 상위 클래스에서 선언된 생성자 호출.
	2. 추상 클래스일때는 추상메서드를 반드시 재정의 하여야 한다.	
	 * */
	public NormalDuck() {
		super("보통오리");
		// TODO Auto-generated constructor stub
	}
	@Override
	void fly() {
		System.out.println(getKind()+" 나르지 못 한다.");
	}	
}
class Mallard extends Duck{
	public Mallard() {
		super("청둥오리");
		// TODO Auto-generated constructor stub
	}
	@Override
	void fly() {
		System.out.println(getKind()+" 하늘을 훨훨 나르다!!");
		
	}
	
}

