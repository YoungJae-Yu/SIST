package javaexp.a11_api;

public class A01_API_Start {

	public static void main(String[] args) {
		/*
		# 자바 API 도큐먼트
		1. 자바에서 기본적으로 제공하는 라이브러리
			프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음
		2. API 도큐먼트
			1) 쉽게 api찾아 활용할 수 있도록 문서화한 것
			2) html 페이지로 작성되어 있어 웹브라우저로 바로 볼 수 있다.
		# java.lang 패키지
		1. 자바 프로그램의 기본적인 클래스를 담는 패키지
		2. 포함된 클래스와 인터페이스는 import없이 사용 가능
		3. 주요 클래스
			1) Object
				자바의 모든 클래스의 최상위 클래스로 사용
				모든 클래스(api내장/상용자정의)는 Object를 상속하고 있다.
				그러므로, Object가 가지고 있는 기본적인 메서드는 재정의하거나 사용할 수 있다.
				ex)
				ArrayList list == ArrayList<Object> list
				Object ob = new Person();
				ob.getName(); (X) : 하위 클래스에서 추가 정의된 내용을 사용할 수 없다.
									하위 클래스에서 상위 클래스의 기능메서드 중에
									재정의된 경우에는 하위 클래스의 정의된 내용으로
									사용할 수 있다.
				Person p01 = (Person)ob;
				p01.getName();
		*/
		Person p = new Person();
		Person p1 = new Person();
		Person p2 = p;
		
		System.out.println("참조변수 : "+p);
		// toString()으로 정의된 내용이 출력된다.
		System.out.println("hashCode : "+p.hashCode());
		System.out.println("hashCode : "+p1.hashCode());
		System.out.println("hashCode : "+p2.hashCode());
		// 특정한 객체의 고유 코드값으로 생성시 마다 다른 코드값을 가지고 있다.
		// 해당 객체의 참조변수가 같은지 확인할 때, 사용된다.
		System.out.println("equals : "+p.equals(new Object()));
		try {
			System.out.println("clone : "+p.clone());
		}catch(CloneNotSupportedException e) {
			System.out.println("예외 발생 : "+e.getMessage());
		}
		System.out.println("toString : "+p.toString());
	}

}
//최상위 Object
//class Person extends Object
class Person{
	// 주소값을 hash코드로 가져온다.
	// 같은 값이 있는 경우에는 동이한 hash코드가 나오기에
	// String이나 Wrapper의 동일한 데이터의 경우 한계가 있다.
	// 객체는 주소값을 가져올 수 있다.
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode(); //10진수로 고유코드값을 가져온다.
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 패키지명.클래스명@16진수 주소값
		return "안녕하세요! totString()";
//		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		//deplicated 메서드 : 폐기될 예정
	}
	
}
