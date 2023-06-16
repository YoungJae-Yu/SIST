package javaexp.a10_exception;

import java.util.Scanner;

public class A05_RunTimeError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 두개의 숫자를 입력받아서, 숫자형이 아닐 때는
		// 숫자형을 입력하세요 라는 예외 처리를 하는 프로그램
		// 정상적으로 입력시 @@ + @@ = @@출력...(Scanner sc)
		
		
		System.out.println("프로그램 시작");
		try {
			int num01 = Integer.parseInt("이십오");
		}catch(NumberFormatException e) {
			System.out.println("숫자형 문자열을 입력하세요 !");
		}
		System.out.println("프로그램 종료");
		Scanner sc = new Scanner(System.in);
		System.out.println("두개의 숫자 입력받아 연산 처리");
		try {
			System.out.print("첫번째 숫자 입력:");
			int num01 = Integer.parseInt((sc.nextLine()));
			System.out.print("두번째 숫자 입력:");
			int num02 = Integer.parseInt((sc.nextLine()));
			System.out.println(num01+" + "+num02+" = "+(num01+num02));
		}catch(NumberFormatException e){
			System.out.println("숫자형 데이터를 입력하세요 !");
		}
		System.out.println("프로그램 종료");
		
		
	}

}
