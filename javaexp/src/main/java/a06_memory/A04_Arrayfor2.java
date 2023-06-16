package javaexp.a06_memory;

public class A04_Arrayfor2 {

	public static void main(String[] args) {
		/*
		# 향상된 for문
		1. 배열이나 컬렉션객체(동적 배열형 구조체)를 효과적으로
			처리하는 for문을 말한다.
		2. 기본형식
			for(단위 데이터 : 배열변수) {
				단위 데이터
			}
			int [] arry = {1000,2000,3000};
			for(int price:arry){
				System.out.println(price);
			}
			반복문을 처리하면서, 내부에 포함된 데이터를
			하나씩 price에 할당하여 출력을 하면서,
			배열의 데이터가 없을 때까지 반복 처리해주는 구문이다.
			
		*/
		int [] intArry = {1000,2000,3000};
		System.out.println("향상된 for문 | for each문");
		for(int num:intArry) {
			System.out.println(num);
		}
//		ex)  물건명을 배열로 선언하고, 향상된 for문을 이용해서 출력하세요.
		String [] StrArry = {"시계","노트북","안경"};
		System.out.println("향상된 for문 | for each문");
		for(String name:StrArry) {
			System.out.println(name);
		}
	}
}
