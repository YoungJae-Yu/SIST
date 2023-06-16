package javaexp.z01_JavaPro;

public class z07_JavaPro {

	public static void main(String[] args) {
//		[1단계:개념] 1. 클래스와 객체의 차이점을 예제를 통하여 기술하세요
//		클래스 : 	클래스는 사용자 정의 객체를 위한 선언부분으로
//				객체를 만들기 위한 툴/설계도 역할을 한다.
//		ex) BBQ치킨의 황금올리브 후라이드의 레시피 ==> 클래스
//			레시피를 활용하여 만들어진 여러개의 후라이드 치킨 ==> 객체
		
//		[1단계:개념] 2. 필드의 특성을 예제를 통해 기술하세요
//		
//		ex)
//		main()
//		String name;
//		System.out.println(name);(x)
		
//		Person p01 = new Person(); //객체를 생성하면 각 객체마다 참조변수와 함께 필드명으로 사용이 가능하다.
//		System.out.println(p01.name);(o) 바로 사용가능
//		class Person(int num){
//			String name;//필드는 자동으로 초기화
//			this.num = num;
//		//클래스(객체)의 전역변수, 클래스의 모든 구성요소에영향을 미친다.
//		//지역변수와 동일할 때, 구분자로 this.필드명으로 사용된다
//		}
		
//		[1단계:개념] 3. 생성자와 일반 메서드의 기능적 차이점을 기술하세요
//		생성자 : 함수의 일부기능(저장, 로직, 리턴X)
//		메서드 : 함수의 모든 기능(저장, 로직, 리턴)

		
//		[1단계:코드] 4. Computer 클래스에서 속성으로 제조사, cpu종류, ram 메모리용랑, ssd용량을 속성을 지정하여,
//		기본생성자, 매개변수가 3개인 생성자(오버로딩규칙에 의해 2개 선언)를 선언하고, 객체를 생성하고 확인하세요.
		Compute p01 = new Compute();
		Compute p02 = new Compute("인텔I7",16,512);
		Compute p03 = new Compute(32,"apple",256);		
	}
}
class Compute{//객체 생성
	String maker; //속성 지정
	String cpu;
	int ram;
	int ssd;
	Compute() {// 기본생성자
		this.maker = maker;
		maker = "MS";
		System.out.println("제조사:"+maker);
	}
	Compute(String cpu, int ram, int ssd) {//매개변수가 3개인 생성자 선언
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
		System.out.println("cpu:"+cpu);
		System.out.println("ram:"+ram);
		System.out.println("ssd:"+ssd);
	}
	Compute(int ram, String cpu, int ssd) {//오버로딩 규칙에 의한 또다른 생성자 선언
		this.ram = ram;
		this.cpu = cpu;
		this.ssd = ssd;
		System.out.println("ram:"+ram);
		System.out.println("cpu:"+cpu);
		System.out.println("ssd:"+ssd);
	}
}