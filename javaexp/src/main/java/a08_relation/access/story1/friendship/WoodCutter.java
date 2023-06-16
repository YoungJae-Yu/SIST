package javaexp.a08_relation.access.story1.friendship;

public class WoodCutter {
//	내부 클래스의 전역변수로만 사용하지, 외부 클래스에서는 직접 호출불가
	private String hiddenCloth="뒷동산 바위밑";
//	접근제어자가 없는 default 접근제어자
	String hiddenDeer = "뒤쪽 더불속";
//	public WoodCutter(){} default 생성자에 의해 자동생성되는 생성자 형태
}
