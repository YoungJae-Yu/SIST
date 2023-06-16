package javaexp.z02_util;

public class A01_Input {

	public static void main(String[] args) {
		System.out.println("입력처리");
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args.length);
		String name = args[0];
		System.out.println(name=="홍길동");
		System.out.println(name.equals("홍길동"));
		System.out.println(name.equals("홍길동2"));
		String ageStr = args[1];
		// 숫자형문자열 숫자로 변경해주는 기능 메서드
		int age = Integer.parseInt(ageStr);
		System.out.println("2년 후 : "+(ageStr+2));
		System.out.println("2년 후 : "+(age+2));
		
		/*
		# 자바에서 입력데이터 처리
		1. String[] args 입력
			java A01_Input : 실행명령어
			실행시, 입력값을 전달 처리..
			java A01_Input 홍길동 29
			main()의 매개변수로 
			String[] args = {"홍길동","29"};
			cf) 주의 대부분 프로그래밍 - String[] args =  ["홍길동","29"];
			배열명[index번호 - 0부터시작]
			args[0] : "홍길동"
			args[1] : "29"
			args.length : 배열의 크기 - 2
			
		2. Scanner 객체(내장 api) 활용
		
		*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
