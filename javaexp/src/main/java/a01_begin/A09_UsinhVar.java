package javaexp.a01_begin;

public class A09_UsinhVar {
	int num02;
//	클래스명 바로 밑에 있는 변수를 클래스 전역변수라고 한다.
	public static void main(String[] args) {
		/*
		# 변수명 사용
		1. 변수는 초기화하여야 읽기와 쓰기가 가능하다.
		   - 단, 클래스안에서는 자동 초기화 된다.
			ps) 초기화란 변수에 데이터를 처음 할당하는 것을 말한다.
			숫자형데이터 일반적으로 초기값을 0으로 할당
			그외 boolean false, 이외에는 객체형이고, 객체형의 초기값은 null로 설정한다.
		*/		
		int num01;
//		int sum = num01 + 25; num01에 초기화 데이터가 할당되지 않아서 에러가 발생
		int num02 = 30;
		int sum02 = num02 + 30;
		String name = null;
//		int ==> char ==> char[] ==> String
		Person p01 = null;
		Person p02 = new Person();
		
		System.out.println(p01);
		System.out.println(p02);
		
	}

}

class Person{}