package javaexp.a04_calcu;

import java.util.Scanner;

public class A02_equalsCalcu {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

//		System.out.print("획득한 점수를 입력:");
//		int point = Integer.parseInt(sc.nextLine());
//		boolean isPass = point>=60;
//		System.out.println("합격여부:"+isPass);
		
		System.out.println("등록할 회원 아이디를 입력:");
		String inputId = sc.nextLine();
//		# == 쓰면 동일한 문자열을 입력하더라도 false 처리된다.
//		자바에서는 문자열 비교는 equals()메서드를 활용한다.
		boolean hasMember = inputId.equals("himan");
		System.out.println("등록된 회원 여부:"+hasMember);
		int chNum = 3;
		boolean isCorrect = chNum == 2; //정답이 2일 떄
		System.out.println("정답여부:"+isCorrect);
		String idInput = "홍길동";
//		문자열 데이터의 입력 여부에 따른 boolean 처리.
		System.out.println("입력여부:"+(idInput!=null));
	}

}
