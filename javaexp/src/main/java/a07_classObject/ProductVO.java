package javaexp.a07_classObject;

// 상단메뉴에 refactor ==> rename
// class명을 바꾸면 물리적 파일명도 변경 ProductVO.java
// 이 클래스 호출하는 모든 파일 변경처리해준다.
public class ProductVO {
	String name;
	int cnt;
	int price;
	
	// new ProductVO()를 매개변수가 있는 생성자 있더라도
	// 호출이 필요할 시에 ..
	public ProductVO() {
		super();// 상속시 상위객체를 지칭.		
	}
	// ProductVO p01 = new ProductVO("사과");
	// p01.name
	public ProductVO(String name) {
		// String name : 지역(매개변수)
		// this.name : 객체 전역변수/상수(필드)
		this.name = name;
	}
	public ProductVO(int cnt, int price) {
		this.cnt = cnt;
		this.price = price;
	}

	public ProductVO(String name, int cnt, int price) {
		this.name = name;
		this.cnt = cnt;
		this.price = price;
	}
}
