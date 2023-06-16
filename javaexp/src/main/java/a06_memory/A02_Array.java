package javaexp.a06_memory;

public class A02_Array {

	public static void main(String[] args) {
		/*
		# 배열이란?
		1. 같은 타입의 데이터를 연속된 공간에 저장하는 자료구조
		2. 배열의 구성 요소
			1) 배열의 데이터 유형
				기본데이터유형, 문자열, 사용자정의 클래스에 의해 만들어진 객체
			2) 배열의 INDEX
				각 데이터 저장 위치는 인덱스(0부터 부터)
				부여해서 접근할 수 있다.
				배열명[0] : 호출
				배열명[1] : "하이맨" :할당
			3) 배열의 크기
				배열명.length 배열의 전체 크기를 가져올 수 있다.
		3. 배열의 활용
			1) 배열의 선언
				데이터유형 [] 배열명;
				데이터유형 배열명 [];
				ex) int[] array;
					String array2[];
			2) 배열의 초기화
				배열은 초기화하여야지 사용을 항 수 있다.
				- 배열명 = null;
					heap영역에는 할당하지 않고,
					stack영역에서 선언한 형태
				- 배열명 = new 데이터유형[배열의크기];
					heap영역에 할당은 하였지만,
					실제 default형 데이터로 구성되어 있다.
					ps) 구성요소가 숫자형이나 boolean형이면 0,
					false로 해당크기만큼 할당되어 있고,
					객체유형은 null로 할당되어 있다.
				- 데이터를 할당해서 초기화한 경우
					배열명 = new 데이터유형[] {
						데이터1, 데이터2, 데이터3
					}
					선언과 할당을 동시에 하는 경우에는
					아래와 같이 처리할 수 있다.
					데이터유형 배열명 = {데이터1, 데이터2}
			3) 배열의 데이터 활용
				- 배열은 크기로 초기화가 되거나, 선언과 동시에
					할당한 경우에는(heap영역에 생성된 경우)
				- 배열명[index번호] : 호출
				- 배열명[index번호]=데이터 : 할당/변경
		*/
//		배열의 선언
		int[] array01;
		String[] array02;
		Math[] array03; // 내장 api 객체
		Person[] array04; // 사용자 정의 클래스 객체	
//		초기화 처리
//		1. null;
		array01 = null; // heap영역에 메모리 없음.
//			각 구성요소를 호출해서 사용할 수 없다.
//		2. 크기에 default를 값으로 설정
//			배열명 = new 데이터유형[데이터크기];
//			heap영역에 메모리가 만들어졌다.
		array01 = new int[3];
		System.out.println(array01[0]);
		System.out.println(array01[1]);
		System.out.println(array01[2]);
		array02 = new String[2];
		System.out.println("문자열 배열의 초기값 확인");
//		System.out.println(array02[0]);
//		System.out.println(array02[1]);
//		System.out.println(array02[2]); // 범위 초과
//		ex) 다음의 배열 데이터를 선언하고, 크기를 지정하여 초기화하고
//			해당 데이터를 출력하세요.
//		1) 정수형(int) 크기3, 2) 실수형(double) 크기2
//		2) 문자열형(String) 크기5, 4) 정수형(long) 선언만;
		int[] array05 = new int[3];
		System.out.println("정수형(int) 크기 3개 배열");
		for(int idx=0;idx < array05.length;idx++) {
			System.out.println(array05[0]);		
		}
		
		double array06[] = new double[2];
		System.out.println("실수형 배열");
		System.out.println(array06[0]);
		System.out.println(array06[1]);
		
		String array07[] = new String[5];
		System.out.println("문자열 배열 5");
		for(int idx=0;idx < array07.length;idx++) {
			System.out.println(array07[0]);
		}
		
		long array08[] = null;
//		객체가 heap영역에 생성되지 않았기에
//		배열의 속성을 접근할 수 없다.
//		System.out.println(array08.length);
		/*
		# 배열 데이터의 활용
		1. new를 통해서 초기화된 배열은 데이터를 index로
			접근해서 할당(변경)할 수 있다.
		*/
		String[] arry01 = new String[3];
		System.out.println("배열의 활용");
		System.out.println(arry01[0]);
		arry01[0]="사과";
		arry01[1]="바나나";
		arry01[2]="딸기";
		System.out.println("두번째 데이터:"+arry01[1]);
		for(int idx=0;idx<arry01.length;idx++) {
			System.out.print(idx+1+"번쨰 데이터 ");
			System.out.println(arry01[idx]);
		}
//		ex1) 물건가격 3개 선언하고 데이터를 할당 출력
		int[] arry02 = new int[3];
		arry02[0]=3000;
		arry02[1]=5000;
		arry02[2]=6000;
		for(int idx=0;idx<arry02.length;idx++) {
			System.out.print(idx+1+"번째 물건의 가격:");
			System.out.println(arry02[idx]);
		}
//		ex2) 학생의 몸무게(소숫점이하) 3명 선언 및 할당 출력
		double[] arry03 = new double[3];
		arry03[0]=65.5;
		arry03[1]=45.6;
		arry03[2]=70.8;
		for(int idx=0;idx<arry03.length;idx++) {
			System.out.print(idx+1+"번째 학생의 몸무게:");
			System.out.println(arry03[idx]+"Kg");
		}		
	}
}
class Person{}
