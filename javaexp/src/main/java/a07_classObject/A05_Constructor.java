package javaexp.a07_classObject;

public class A05_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Person_ p01 = new Person_("홍길동",25,"서울");
		Person_ p02 = new Person_("김길동",27,"인천");
		System.out.println(p01.name);
		System.out.println(p01.age);
		System.out.println(p01.loc);
		System.out.println(p02.name);
		System.out.println(p02.age);
		System.out.println(p02.loc);
		
		Product_ prd1 = new Product_("물병",2500,3);
		Product_ prd2 = new Product_("화분",7500,5);
		System.out.println(prd1.name+"의 정보");
		System.out.print(prd1.price+"원 ");
		System.out.println(prd1.cnt+"개");
		System.out.println(prd2.name+"의 정보");
		System.out.print(prd2.price+"원 ");
		System.out.println(prd2.cnt+"개");
		
		ProductVO p100 = new ProductVO("사과");
		// p100 : 객체의 특정한 heap영역의 주소를 간단하게
		// 선언한 것이다. 참조변수
		System.out.println(p100);
		System.out.println(p100.name);
		ProductVO p101 = new ProductVO("바나나");
		System.out.println(p101.name);
		ProductVO p102 = new ProductVO("오렌지",2000,5);
		System.out.println("#물건객체#");
		System.out.println(p102.name);
		System.out.println(p102.price);
		System.out.println(p102.cnt);
	
	}
}
// ex) Product_ 클래스 선언 필드로 물건, 가격, 갯수 영문으로 선언
// 생성자를 통해서 초기화
// main()에서 prd1,prd2를 참조변수로 객체를 생성해서 필드값을 출력하세요..
class Product_{
	String name;
	int price;
	int cnt;
	Product_(String name, int price, int cnt){
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
}

// class 선언시 에러가 발생하면
// package javaexp.a07_classObject;
// 동일한 패키지명 하위에 동일한 클래스 선언시 에러발생.
class Person_{
	String name;
	int age;
	String loc;
	
	// default생성자는 사용자정의 생성자를 선언하는 순간 사라진다.
	// 1. 생성자의 핵심 임무 - 필드의 초기화 처리
	Person_(String name, int age, String loc){
		// 필드로 선언한 name과 매개변수로 전달된 name구분
		// 그 구분자가 this.
		this.name = name;
		this.age = age;
		
		this.loc = loc;
	}
}