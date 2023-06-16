package javaexp.a08_relation.a05_pck;

import javaexp.a08_relation.a06_pck.Bus;

public class Passenger {
	//선언
	Bus b1;
//	Car c1; 
	void call() {
		b1 = new Bus();
//		b1 = new Bus(7788);
		b1 = new Bus("서울행",9999);
		System.out.println(b1.no);
//		System.out.println(b1.target);
//		System.out.println(b1.driver);
//		같은 패키지에 있더라도 private이기에 직접적으로 접근이 안된다.
		b1 = new Bus("인천",7777,"홍길동");
		b1.callInfo();
		
		
	}
	
}
