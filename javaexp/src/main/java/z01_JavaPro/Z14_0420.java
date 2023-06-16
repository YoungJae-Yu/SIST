package javaexp.z01_JavaPro;

public class Z14_0420 {

	public static void main(String[] args) {
		// 1-3번 결과
		Polygon p1 = new Triangle();
		Polygon p2 = new Rectangle();
		Polygon p3 = new Pentagon();
		p1.drawing();
		p2.drawing();
		p3.drawing();
		// 6,7번 결과
		Chocolate c1 = new DCcookie();
		Chocolate c2 = new WCcookie();
		c1.baking();
		c2.baking();		
	}
}
//2023-04-18
//[1단계:조별] 1. 다형성을 대한 내용에 대하여 정리해보자.
//      1) 다형성을 위해 오버라이딩을 사용하는 이유를 아는가?
		/*
		공통 멤버를 가진 상위클래스를 상속받은 하위클래스에서,
		기능적 분리를 하는 메서드를 상위클래스에 정의된 이름과 매개변수를 동일하게 정의하여 다양한 기능을 처리한다.
		여러 하위객체를 통해 다양한 기능을 처리하여 재사용성을 높인다.
		*/
//      2) 다형성을 처리하기 위한 클래스 구조를 이해하고 만들 수 있는가?
		/*
		1) 상위클래스
		   필드선언, 생성자선언, 메서드 선언
		2) 하위클래스
		   생성자 오버라이딩, 메서드 오버라이딩
		*/
		/* 강사님 풀이
		1. 상위클래스 class Part
			공통필드	String name(부품명)
			오버라이딩메서드 void showInfo()
		2. 상속받는 하위클래스(계속추가)
			상위생성자를 호출하는 생성자 super("CPU")
			오버라이딩메서드		void showInfo()
								super.showInfo()
		3. 위 내용을 다형성 처리를 하는 클래스
			class 포함할클래스{		class Computer
				고유필드				String company
				상위클래스 참조명			Part part
				하위클래스를 추가할 메서드		void addPart(Part part)
					void addxxx(상위클래스 참조명){}
				void showInf() 전체정보를 표현할 메서드
									void showAll()
										if(part!=null)
			{
		 */

//      3) 상위클래스를 다각형으로 하고, 하위 클래스를 삼각형, 사각형, 오각형으로 선언하여, 필드 kind, 기능메서드 drawing()을 처리하여 출력되게 하세요
//      삼각형 ==> 삼각형 모양으로 (세모난 새집을 그리다.), 사각형 ==> 사각형 모양으로 (네모난 빌딩을 그리다)...
class Polygon {
	private String kind;

	public Polygon(String kind) {
		this.kind = kind;
	}
	public void drawing() {
		System.out.println(kind+"모양으로..");
	}
}
class Triangle extends Polygon{

	public Triangle() {
		super("삼각형");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawing() {
		// TODO Auto-generated method stub
		super.drawing();
		System.out.println("나초를 그렸다...!");
	}
}
class Rectangle extends Polygon{

	public Rectangle() {
		super("사각형");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawing() {
		// TODO Auto-generated method stub
		super.drawing();
		System.out.println("맥북을 그렸다..!");
	}
}
class Pentagon extends Polygon{

	public Pentagon() {
		super("오각형");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void drawing() {
		// TODO Auto-generated method stub
		super.drawing();
		System.out.println("미국 교도소 펜타곤을 그렸다...");
	}
}
//[1단계:개념] 6. 다형성을 위한 상위 클래스를 멤버(필드,생성자,재정의메서드) 예제와 함께 설명하세요.
//ex) Chocolate 클래스, Baking 메서드
class Chocolate{
	private String kind; //초콜릿의 종류(필드)

	public Chocolate(String kind) { // 생성자
		this.kind = kind;
	}
	public void baking() {
		System.out.println(kind+" 쿠키를 만들려고 한다!");
	}
}
//[1단계:개념] 7. 다형성을 위한 하위 클래스의 구성을 예제와 함께 설명하세요.
//초콜릿클래스를 화이트초콜릿 쿠키와 다크초콜릿 쿠키로(다형성) 만들어보겠습니다. 
class DCcookie extends Chocolate {

	public DCcookie() {
		super("다크초콜릿");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void baking() {
		// TODO Auto-generated method stub
		super.baking();
		System.out.println("맛있는 다크초콜릿 쿠키가 완성되었습니다!");
	}
}
class WCcookie extends Chocolate {

	public WCcookie() {
		super("화이트초콜릿");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void baking() {
		// TODO Auto-generated method stub
		super.baking();
		System.out.println("맛있는 화이트초콜릿 쿠키가 완성되었습니다!");
	}
}