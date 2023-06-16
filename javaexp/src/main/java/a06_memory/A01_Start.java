package javaexp.a06_memory;

public class A01_Start {

	public static void main(String[] args) {
		
		
		/*
		# 자바에서 사용하는 대표적인 메모리 stack과 heap
		1. 개요
			1) 우리가 공간에 물건을 저장할 때,
				어떻게 저장하는 것이 효율적일까요?
			2) 작은물건, 큰물건, stick(내용붙임)
			3) 큰물건을 어디에 적재할지를 저장하는 공간을
				따로만들고, 작은메모리는 바로 할당 할 수 있게 처리
				==> stack과 heap
			4) 작은물건의 저장과 큰물건이 적재된 위치
				==> stack의 메모리
			5) 큰물건이 실제 저장 ==> heap 메모리
			cf) 도서관과 서점에서 실제 도서가 있는 곳과
				단말기(컴퓨터)를 통해 위치를 가르켜주고,
				그 위치 코드를 출력해주는 것으로 stack과
				heap영역을 사용하는 내용을 비유할 수 있다.
			6) stack영역만 쓰는 데이터와
				stack과 heap영역을 쓰는 데이터의 구분기준은
				일정하게 한정되어 있는 데이터(기본유형)이냐
				확장성이 있는 데이터(객체유형)이냐로 나눈다.
				객체 - 기본유형이 배열로 선언
					문자열(String), 
					내장된 api객체(Scanner..Integer, Double...Math...)
					class를 선언하여 호출하는 객체
		2. 객체유형의 데이터들..
			1) 메모리를 stack과 heap영역을 둘다 사용하는 데이터를 말한다.
			2) 객체는 생성하면(new 키워드로) heap영역에 특정한 위치에 저장된다.
				이 특정한 위치를 보통 16진수로 설정하고 
				이 위치값을 저장하는 메모리가 stack 영역이다.
			3) 종류
				- 배열형 데이터
					ex) new int[5]; {1000, 2000}
						new String(); 문자열(문자배열형)
						new String[2]; {"사과","바나나"}
							{new Person(),new Person()}
						array[0] : 배열은 index로
							0부터 시작하는 번호로 구분한다.
						array[1]
						array.length : 배열의 길이를 나타내는 키워드
				- 내장된 api 객체
				- class로 선언하여 호출하는 사용자 정의 객체
				
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
