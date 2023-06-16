package javaexp.a05_process;

public class A06_for {

	public static void main(String[] args) {
		
		/*		
		# for문을 통한 반복문
		1. 특정 step단위로 반복문을 수행할 때, 사용된다.
		2. 기본 형식
			for(초기값;반복조건;증/감연산자){
				반복해서 수행할 구문..
			}
		3. 기본 구성 요소 내용
			1) 초기값 : 1번만 수행, for문 안에서 사용할 변수 선언
				최소값을 선언
				cnt = 100; 최대값으로 감소할 가망성 높음
				cnt = 0; 최소값으로 증가할 가망성 높음
			2) 반복조건 : for문을 반복할 조건
				cnt<=10 : 증가 연산자때.
				cnt>=0 : 감소 처리할 떄 조건.
			3) 반복해서 수행할 구문 : 실제 반복처리할 내용
			4) 증/감연산자 : 증가하거나 감소 처리
				cnt++ : 1씩 증가
				cnt-- : 1씩 감소
		*/
//		int cnt는 for문 블럭 안에 사용되는 지역변수이기에
//		동일하게 선언하더라도 변수의 이중 선언이 아니다.
		for(int cnt=1;cnt<=10;cnt++) {
			System.out.println("카운트 업:"+cnt);
		}
		System.out.println("# 감소 데이터 처리 #");
		for(int cnt=10;cnt>=0;cnt--) {
			System.out.println("카운트 다운:"+cnt);
		}
//		15~40
		for(int cnt=15;cnt<=40;cnt++) {
			System.out.print(cnt+",");
		}
		System.out.println();
//		20~100까지 출력하되 3단위로 증가 처리
		for(int cnt=20;cnt<=100;cnt+=3) {
			System.out.print(cnt+"&");
		}
		System.out.println();
//		ex1) 20~30 출력
		for(int cnt=20;cnt<=30;cnt++) {
			System.out.println(cnt+",");
		}
//		ex2) 100~70 출력
		for(int cnt=100;cnt>=70;cnt--) {
			System.out.println(cnt+",");
		}
//		ex3) 1~20 2개씩 증가
		for(int cnt=1;cnt<=20;cnt+=2) {
			System.out.println(cnt+",");
		}
//	 	ex4) 50~30 5씩 감소
		for(int cnt=50;cnt>=30;cnt-=5) {
			System.out.println(cnt+",");
		}
//		프로세서 문제 발생시 
//		1. 실행창 상단에 []빨간색 - terminator 클릭
//		2. ctrl+alt+del 작업관리자에서 eclipse 종료	
	}
}
