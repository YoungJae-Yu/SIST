package javaexp.z02_util;
import java.util.Scanner;
public class A04_Scanner {

	public static void main(String[] args) {
		/*
		1. 자바 내장 기본 입력/출력 객체
			System.out : 출력 처리 (콘솔)
			System.in : 입력 처리 (콘솔)
		*/
		System.out.println("# 입력을 해볼까요?? #");
//		2. 내장된 Scanner 객체 이용 입력 처리
//			1) 기본 형식
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		System.out.println("입력된 이름:"+name);
		System.out.println("나이를 입력하세요");
		String ageStr = sc.nextLine();
		System.out.println("입력된 나이:"+ageStr);
		int age = Integer.parseInt(ageStr);
		System.out.println("숫자형 나이(10년후)"+(age+10));
		System.out.println("구매한 물건의 갯수입력");
		int prodCnt = sc.nextInt();
		System.out.println("구매한 물건의 갯수(숫자+5)"+(prodCnt+5));
		
		
		
		
	}

}
