package javaexp.a01_begin;

public class A12_StringTypeChange {

	public static void main(String[] args) {
		/*
		#형변환
		1. 데이터 타입을 다른 타입으로 변환하는 것을 말한다.
			1) 기본 데이터 타입끼리
				작 <==> 큰, 실수 <==> 정수
			2) 객체형끼리 변경
				- 문자열 데이터와 숫자변경
					"301" vs 301
					"301"+"101" vs 301+101
				    "301101"	   402
				    
					ps) 실무형태
					모든 데이터는 기본적으로 문자열형태로만 전송하고 전달받을 수 있다.
					내장된 객체에서 지원하는 기능메서드를 통해서 전환이 가능하다.
					
					ex) 파일에 저장된 숫자, 네트웍을 통해 전달되는 숫자
					==> 문자열형
					3000^2000^4000 ==> "3000" ==> 3000
					
					문자열을 정수형 변환 
						내장된 Integer객체의 pareInt()를 메서드를 통해서
						숫자형문자열을 숫자형으로 변환해준다.
						Integer.pareInt("")
						ex) "25.7"(x) "이십오"(x) "30"(o)
						int num01 = Integer.pareInt("25")
					문자열을 실수형 변환
						내장된 Doubler객체의 parseDouble()을 메서드를 통해서
						실수형으로 변환해준다.
						ex) "25"(o) "이십오점사"(x) "3.14"(o)
						double num02 = Double.parseDouble("3.14");
*/
					int num01 = Integer.parseInt("25");
					System.out.println(num01+25);
					String num02Str = "30.15";
//					반드시 정수형 문자열이어야 한다.
//					int num02 = Integer.parseInt(num02Str);
//					실행에러(컴파일까지 되지만 실행 시 에러발생)
//					System.out.println(num02+20);
					double num02 = Double.parseDouble(num02Str);
					System.out.println(num02+30.5);
					// 실수형변환에서 정수형문자열을 전환이 된다.
					System.out.println(Double.parseDouble("30")+0.7);

//					ex) 문자열 "70"과 "20"을 정수형으로 형변환하여, 합산된 결과를 출력하세요.
//					ex) 문자열 "30.7"과 "40.2"을 실수형으로 형변환하여, 합산된 결과를 출력하세요.
					int num1 = Integer.parseInt("70");
					int num2 = Integer.parseInt("20");
					System.out.println(num1+num2);
					
					String num7Str = "70";
					String num8Str = "20";
					int num7 = Integer.parseInt(num7Str);
					int num8 = Integer.parseInt(num8Str);
					System.out.println(Integer.parseInt(num7Str)+Integer.parseInt(num8Str));
										
					String num3Str = "30.7";
					String num4Str = "40.2";
					double num3 = Double.parseDouble(num3Str);
					double num4 = Double.parseDouble(num4Str);
					System.out.println(num3+num4);
				
//					String num3Str = "30.7";
//					String num4Str = "40.2";
					double num5 = Double.parseDouble("30.7");
					double num6 = Double.parseDouble("40.2");
					System.out.println(num5+num6);
					System.out.println(Double.parseDouble("30.7")+Double.parseDouble("40.2"));
					
					
	}

}
