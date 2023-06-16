package javaexp.a05_process;

import java.util.Scanner;

public class A08_for_global {

	public static void main(String[] args) {
		/*
		# for문에서 전역변수 활용
		1. 전역변수와 지역변수
			- 대상 구문
				class
				메서드
				조건문
				반복문 
			- 중괄호가 들어가서 계층적인 구문의 데이터를
				활용하는 경우에 사용된다.
				상대적 개념으로
				상위 중괄호 블럭에서 선언되어 하위 중괄호
				블럭에 영향을 미치는 데이터를 전역변수라고 하고
				하위 중괄호 블럭안에 선언되어 이 중괄호블럭
				내부에서만 사용할 수 있는 데이터를 지역변수라고 한다.
			- 전역변수는 선언한 하위 블럭에 모두 영향을 미친다.
			- 지역변수는 선언한 현재 블럭에서만 사용할 수 있다.
				포함하고 있는 상위 블럭이나, 다른 블럭에서 사용할 수 없다.
				
		
		2. for문에서 전역변수를 사용하는 경우
			1) for문 안에서 반복적으로 활용
				- for문 들어가기전에 상단에 선언되어
				for문에 데이터로 호출하거나
				재할당할 수 있게 처리할 수 있다.
				ex) int grade = 5;
				for(int cnt=1;cnt<=9;cnt++) {
					System.out.print(grade)
					System.out.print("X")
					System.out.print(cnt)
				}
			2) for문에서 증감대입연산자와 함께 활용 처리
				- ex) 물건 구매 내역을 누적하여 총합을 구하여야 한다.
				- ex) 1~10 반복 카운트를 출력하면서,
					  1~10 누적하여 합산된 데이터를 총계로 출력한다.				
		*/
//		1~100까지 누적합계 처리
		int tot = 0; // 초기값 선언
		for(int cnt=1;cnt<=100;cnt++) {
//			int sum = 0;
//			sum += cnt; 누적이 되지 않는다.
			tot+=cnt;
			System.out.print(cnt+" + ");
		}
		System.out.println("\n1~100까지 총계:"+tot);
		int totPay = 0;
		int price = 1000; 
		for(int cnt=1;cnt<=10;cnt++) {
//			int price = 1000; 
//			가능하지만 재활용 문제로 전역변수로 사용 필요
			System.out.println(cnt+"개 "+price*cnt);
			totPay += price*cnt;
		}
//		1~10개 까지 구매한 총계를 다 누적하고 싶다.
//		System.out.println("전체 총계:"+totPay);
//		int totPt = 0;
//		Scanner sc = new Scanner(System.in);
//		for(int cnt=1;cnt<=3;cnt++) {
//			System.out.print(cnt+"번째 학생의 점수입력:");
//			totPt+=sc.nextInt();
//		}
//		System.out.println("총점:"+totPt);
//		System.out.println("평균:"+totPt/3.0);
		
//		ex) 구매한 과일 5개의 각각의 가격을 입력하여
//			총비용을 출력하세요...
		int totPrice = 0;
		Scanner sc2 = new Scanner(System.in);
		for(int cnt=1;cnt<=5;cnt++) {
			System.out.print(cnt+"번째 과일 가격 입력:");
			totPrice+=sc2.nextInt();
		}
		System.out.println("총비용:"+totPrice);
	}
}
