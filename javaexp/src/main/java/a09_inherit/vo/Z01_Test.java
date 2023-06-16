package javaexp.a09_inherit.vo;

public class Z01_Test {

	public static void main(String[] args) {
		Son s1 = new Son();
		// 상속에 의해서 상위가 가지고있는 멤버 사용
		System.out.println(s1.shape);
		System.out.println(s1.working);
		// 상속에 의해 상위객체가 가지고 있는 멤버 사용
		s1.running();
		s1.playBaseBall();
		s1.callSuper();
//		ex) 상속처리
//		Mother charac(현명하다) cooking()요리잘하다
//		Daughter 위 내용을 상속받아서 추가 속성과 메서드를 처리하고..
//		main()에서 호출해보세요.
		Daughter d1 = new Daughter();
		System.out.println(d1.charac);
		d1.callTalent();
//		ex) Mother 클래스에 private 접근제어자로 변수선언(height)..
//		간접적으로 할당 및 호출하는 메서드를 정의해서
//		Daughter클래스에서 호출되게 하세요..
		d1.callHeight();
	}
}
