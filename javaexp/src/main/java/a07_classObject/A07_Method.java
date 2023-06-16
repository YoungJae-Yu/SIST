package javaexp.a07_classObject;

public class A07_Method {

	public static void main(String[] args) {
		
		/*
		# class의 구성요소 메서드
		1. 메서드는 class에서 구성된 구성요소로서 객체가 가지고
		있는 기능적인 역할을 하는 함수이다.
		2. 함수란 특정한 기능을 처리하고 결과값을 리턴하는 기능이
		있다면 이것이 객체(class)에 종속되는 경우 메서드라고 한다.
		3. 메서드의 핵심기능
			메서드는 매개변수로 데이터를 받아서, 전역변수에 저장
			하기도하고, 전역변수의 데이터와 관계에 있는 로직을
			처리하여 최종적으로 원하는 데이터를 리턴해주는 것이라
			할 수 있다.
			1) 매개변수입력 ()
			2) 저장처리(전역변수)
			3) 로직처리 : 전역변수/지역변수의 데이터를 확인해서
				조건/반복문을 통해 원하는 결과를 처리...
			4) 화면 출력
			5) 결과값 호출한 곳에 리턴처리..
		4. 메서드의 선언
			1) 메서드의 기본 형식
				리턴유형 메소드명(매개변수1, 매개변수2...){
					프로세스 처리
					return 실제 리턴할 데이터;
				}
			2) 구성요소
				리턴유형 : 이 메서드를 통해서 처리하는 결과값을
					리턴을 하는데, 메서드 선언의 가장 밑부분에
					실제 리턴할 데이터의 유형을 선언하는 것을 말한다.
					리턴하지 않을 경우는 void를 선언하지 않는다.
					ex) int ret01(){
							return 25;
						}
						double ret02(){
							return 25.75;
						}
						void ret03(){
						
						}
				메서드명(매개변수..)
					매개변수는 외부에서 입력한 데이터 받아서,
					이 기능 메서드의 지역변수로 활용하여 사용한다.
					메서드명과 매개변수의 선언기준은 외부에서 호출할때
					식별할 수 있는지 여부에 따른다. 즉, 메서드 오버로딩
					규칙이 적용된다.
				프로세스 처리
					매개변수를 받아서, 전역변수에 할당하거나,
					특정 조건 처리/반복처리를 하는 등 여러가지
					해당 기능을 통해서 처리할 로직을 포함하는 기능을 한다.
				최종 리턴값
					처음에 선언한 리턴유형에 맞는 최종 리턴값을
					해당 메서드를 통해서 처리할 수 있다.
					단, return XXX 형식으로 선언하지 않을 경우도
					있는데, 이 때는 반드시 return 유형을 void라고
					선언하여야 한다.
		*/
		Calculator c1 = new Calculator();
		c1.plus(30,25); // 55
		int ret01 = c1.plus(30,25);
		System.out.println("최종 리턴값1:"+ret01);
		MRExp r1 = new MRExp();
		System.out.println(r1.retStr01());
		String calRet = r1.retStr01();
		System.out.println(calRet);
		
		System.out.println(r1.retnum01()); //바로 출력
		int num01 = r1.retnum01(); // 변수에 넣고
		System.out.println(num01); // 출력
		
		MRExp m01 = new MRExp("홍길동",26);
		System.out.println(m01.getName());
		System.out.println(m01.myAge());
		int agee = m01.myAge();
		System.out.println(agee);
		
		MRExp2 i1 = new MRExp2("Yu","Aa");
		System.out.println(i1.getId());
		System.out.println(i1.getPass());
		System.out.println(i1.getIdPass());	
	}
}
// ex) class MRExp2 선언하고 필드로 회원아이디(id), 패스워드(pass)
//		생성자로 초기화 시키고,
//		메서드1 getId() ==> 아이디값 가져오기
//		메서드2 getPass() ==> 패스워드값 가져오기
//		메서드3 getIdPass() ==> Id와 pass를 @@@/@@@ 형식으로
//							  가져오게 처리를 선언하고
//							  main()에서 호출하세요..
class MRExp2{
	String id;
	String pass;
	public MRExp2(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
//	전역변수에 있는 id값 가져오기
	String getId() {
		return id;
	}
//	전역변수에 있는 pass값 가져오기
	String getPass() {
		return pass;
	}
	String getIdPass() {
//		전역변수에 있는 id/pass를 아래 형식으로 가져오는 메서드 선언
//		return id+"/"+pass;
		String idpass = (id+"/"+pass);
		return idpass;
	}
	
	public MRExp2() {
		// TODO Auto-generated constructor stub
	}
}

class MRExp{
	String name;
	int age;
	public MRExp(String name, int age) {
		this.name = name;
		this.age = age;
	}
	String getName() {
		return name; //여기서의 name은 전역변수의 name을 의미한다.
//		return this.name;
	}
//	나이를 리턴하는 메서드를 만들고, main()호출하여 출력하세요
	int myAge() {
		return age;
	}
	
	public MRExp() {
		// TODO Auto-generated constructor stub
	}
	// 문자열리턴
	String retStr01() {
		return "홍길동(리턴값)";
	}
	// 정수 100을 리턴할 메서드 정의하고, 위 메인 메서드에서
	// 바로 출력하는 것과 변수에 넣고 호출하는 것을 만드세요
	int retnum01() {
		return 100;
	}
}
class Calculator{
	int num01;
	int num02;
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	public Calculator(int num01, int num02) {
		this.num01 = num01;
		this.num02 = num02;
	}
	int plus(int num01, int num02) {
		//전역변수에 할당
		this.num01 = num01;
		this.num02 = num02;
		// 덧셈결과를 tot 지역변수에 할당.
		int tot = this.num01+this.num02;
		// 합산한 결과값을 return 처리해서,
		// 이 메서드를 호출한 곳에 전달.
		return tot;
		
	}
}

