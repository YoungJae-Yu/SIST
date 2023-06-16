package javaexp.a05_process;

import java.util.Scanner;

public class A07_forUsing {

	public static void main(String[] args) {
		/*		
		# for의 활용
		1. 여러가지 출력형식 처리
		2. for문과 전역변수 사용
		3. for문에서 조건문 사용
		4. for문 안에 for문(이중 for문) 사용	
		*/
		for(int cnt = 1;cnt<=10;cnt++) {
//			줄바꿈 처리 : System.out.println();
//			특수문자/일반문자 활용 처리 : \t, \n
			System.out.print(cnt+"\t");
		}
//		1 + 2 + 3 ...
		for(int cnt = 1;cnt<=10;cnt++) {
			System.out.print(cnt+"+");
		}
		System.out.println();
		
//		ex) 다음과 같은 형태로 출력해보세요
//		1. 카운트 다운 시작 10, 9...0. 완료
		System.out.println("#카운트 다운 시작#");
		for(int cnt = 10;cnt>=0;cnt--) {
			System.out.print(cnt+", ");			
		}
		System.out.println("완료");
//		2. 100에서부터 120까지 합산 처리
//			100 + 101 + ... 120 +
//			합산처리 완료
		System.out.println("#100에서부터 120까지 합산 처리#");
		for(int cnt = 100;cnt<=120;cnt++) {
			System.out.print(cnt+" + ");			
		}
		System.out.println("합산처리 완료");
//		3. 학생 번호 (1~10)과 점수 (임의의 점수0~100)
//			번호 점수
//			1   78
		System.out.println("#학생 번호와 점수 출력#");
		System.out.println("번호\t점수");
		for(int cnt = 1;cnt<=10;cnt++) {
			System.out.print(cnt+"\t");
			System.out.println((int)(Math.random()*101));
		}
//		4. 임의의 구구단 출력
//			단수 : 00단(2~9) (임의값) for문 1~9 반복
//			00X1 = 00
		int num1 = (int)(Math.random()*8)+2;
		for(int cnt = 1;cnt<=9;cnt++) {
			System.out.println(num1+"X"+cnt+" = "+num1*cnt);
		}
		
//		과일의 단가를 입력하고 해당 과일의 1~10까지 구매 총계를
//		아래 형식으로 출력하세요 ..
//		단가 : @@@
//		갯수  총계
//		1개   @@원
//		...
//		10개  @@원
		Scanner sc = new Scanner(System.in);
		System.out.print("과일의 단가를 입력하세요 : ");
		int price = sc.nextInt();
		System.out.println("과일의 단가:"+price);
		System.out.println("갯수\t총계");
		for(int cnt = 1;cnt<=10;cnt++) {
			System.out.print(cnt+"개"+"\t");
			System.out.println(cnt*price+"원");
		}
	}
}
