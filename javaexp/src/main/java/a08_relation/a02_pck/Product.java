package javaexp.a08_relation.a02_pck;

public class Product {
	// Product p01;
	public static String pCode="제품코드1000";
	static int no=9999;
	// 모든 외부 패키지에서 접근 가능
	public String name;
	// 같은 패키지만 접근 가능
	int age;
	// 현재 클래스 내에서만 사용 가능
	private String loc;
//	Product p01 = new Product();
//	p01.name;
	public Product(){}
	public Product(String name, int age){
		this.name = name;
		this.age = age;
	}
	
//	X : 다른 패키지는 접근 불가
	Product(String name){
		this.name=name;
	}
//	public : 다른 패키지에서 접근 가능
	public Product(int age){
		this.age=age;
	}
//	default생성자의 접근범위는 public
}
//public이 아닌 클래스
class Fruit{}