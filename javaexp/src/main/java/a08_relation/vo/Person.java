package javaexp.a08_relation.vo;

public class Person {
//	일반적으로 필드는 직접 호출이 불가능하게 private로 설정
//	한번에 읽기 쓰기를 못하게 처리..
	private String name;
	private int age;
	private String loc;
	public Person() {
		// TODO Auto-generated constructor stub
	}
//	new Person("안녕");
//	new Person("홍길동");
//	new Person("서울");
	public Person(String name) {
		this.name = name;
	}
	public Person(int age) {
		this.age = age;
	}
//	오버로딩 규칙에 의해서 식별을 못하기에 선언을 할 수 없다.
//	public Person(String loc) {
//		this.loc = loc;
//	}
	public Person(String name, int age, String loc) {
		this.name = name;
		this.age = age;
		this.loc = loc;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	p01.setAge(25); 필드에 있는 값을 간접적으로 할당
//	p01.getAge(); 필드에 있는 갑슬 간접적으로 호출
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public void setName(String name) {
		this.name = name;
	}
}
