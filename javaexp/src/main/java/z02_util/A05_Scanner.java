package javaexp.z02_util;

import java.util.Scanner;

public class A05_Scanner {

	public static void main(String[] args) {
		
//		가계부 지출금액 표기
		Scanner sc = new Scanner(System.in);
		System.out.print("잔액을 입력하세요:");
//		print() 하면 입력데이터를 문자열 옆에 바로 입력
		int rest = Integer.parseInt(sc.nextLine());
		System.out.print("현재 잔액은 "+rest+"원 입니다.");
		System.out.print("지출할 내용 입력:");
		String content = sc.nextLine();
		System.out.print("지출할 금액 입력:");
		int spendMoney = Integer.parseInt(sc.nextLine());
		System.out.print("지출 내역:"+content);
		System.out.print("지출 금액:"+spendMoney);
		rest-=spendMoney;
		System.out.print("현재 잔액:"+rest);
	}

}
