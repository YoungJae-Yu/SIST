package javaexp.a08_relation.access.pck1;

public class OrientalMelon {
	private String taste;
	int price;
	protected int cnt;
	public String store;
	
	// 접근제어자 4가지 호출 메서드
	public void fInfo1(){
		OrientalMelon f = new OrientalMelon();
		System.out.println("private:"+f.taste);
		System.out.println("default(X):"+f.price);
		System.out.println("protected:"+f.cnt);
		System.out.println("public:"+f.store);
	}
	// 상속 클래스
	public void fInfo2(){
		System.out.println("private:"+taste);
		System.out.println("default(X):"+price);
		System.out.println("protected:"+cnt);
		System.out.println("public:"+store);
	}
}
