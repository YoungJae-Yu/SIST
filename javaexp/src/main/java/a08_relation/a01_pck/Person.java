package javaexp.a08_relation.a01_pck;

import javaexp.a08_relation.a02_pck.Product;

public class Person {
	// 외부 패키지에 있는 public class
	Product p01;
	
	void call() {
		// static이고 public이라서 객체 생성없이 바로 사용
		System.out.println(Product.pCode);
//		static 이지만 no가 public이 아니라 접근 불가
//		System.out.println(Product.no);
		p01 = new Product(); // default 생성자는
//		public이기에 생성이 가능하다.
//		p01 = new Product("사과"); //X접근 불가
		p01 = new Product(25);
		
		p01 = new Product("사과",3000);
		System.out.println(p01.name); //name접근가능(public)
//		System.out.println(p01.age); // age(X) 접근불가
		
	}
//	외부 패키지에 public이 아닌 클래스는
//	호출을 할 수 없다.
//	Man m01;
}
//ex) a08_relation 패키지 하위에
//	  a03_pck, a04_pck
//	  Computer public인 Mouse, X KeyBoard
//	  Computer에서 필드로 해당 객체를 선언하세요.