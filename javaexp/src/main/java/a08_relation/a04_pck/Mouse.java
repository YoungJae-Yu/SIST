package javaexp.a08_relation.a04_pck;

public class Mouse {
	int num1;
	String str;

	public void a(int num1,String str) {
		this.num1 = num1;
		this.str = str;
	}
	void b(String str,int num1) {
		this.str = str;
		this.num1 = num1;
	}
}
//ex) Mouse에 생성자를 2개(생성자 오버로딩규칙) public/X
//선언하고.. call()에서 객체 생성 여부를 확인