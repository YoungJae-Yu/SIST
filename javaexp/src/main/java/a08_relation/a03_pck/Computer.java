package javaexp.a08_relation.a03_pck;

import javaexp.a08_relation.a04_pck.Mouse;

public class Computer {
	Mouse p1;
//	KeyBoard p01;
	
	void call() {
		Mouse m1 = new Mouse();
		m1.a(5, null);
//		m1.b(null, 5);
	}
	
	
}
//ex) Mouse에 생성자를 2개(생성자 오버로딩규칙) public/X
//	선언하고.. call()에서 객체 생성 여부를 확인