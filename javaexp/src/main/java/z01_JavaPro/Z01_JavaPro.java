package javaexp.z01_JavaPro;

public class Z01_JavaPro {

	public static void main(String[] args) {
		
/*
[1단계:개념] 1. Z01_JavaPro.java의 실행과정의 오늘한 예제 기준으로 정리해보세요.
		
		실행과정		
		Z01_JavaPro.java : 소스코드를 만든다.
		javac Z01_JavaPro.java  : 컴파일 파일을 만든다.
		Z01_JavaPro.class 생성
		java Z01_JavaPro : main()이 있는 파일에서 메모리를 로딩시키고, 실행되는 처리를 한다.		
	    
		실행문
		1) 변수의선언, 값저장, 메서드 호출에 해당하는 코드
		2)실행문의 끝에는 반드시(**) 세미콜론(;)을 붙여 실행문의 끝 표시
		3)한라인에 여러 실행문은 세미콜론(;) 구분자로 처리할 수 있다.
*/
		int num01 = 10;
		int num02 = 20;
		int num03 = 30; 
		int num04 = 40;
/*		
[1단계:코드] 2. 변수명과 타입을 적절하게 선언하여 아래와 같이 선언하고 출력하세요
       
        - 이름, 나이, 키 
        - 좋아하는 음악명, 발매연도
        - 오늘 지출금액 목록과 비용, 합산
*/
		var name = "유영재, "; 
		System.out.print(name);
		var age = "26세, ";
		System.out.print(age);
		var key = "171cm";
		System.out.println(key);
		
		var FM = "아이유-좋은 날, ";
		var FMD = "2010년도 발매";
		System.out.println(FM+FMD);
		
		int lunch = 7500;
		int coffee = 1300;
		System.out.println("지출금액 "+(lunch+coffee)+"원");
		
/*		
[1단계:개념] 3. 기본 출력형식과 특수문자에 대하여 예제를 통해 기술하세요
		
		1) 자바는 기본적으로 System.out.println("출력문자열");
		   명령을 통해서 줄바꿈과 함깨 문자열을 출력한다.
		   sysout+ctrl+space : 자동 출력문 생성 명령어    
*/
		System.out.println("반갑습니다.");
		
//		2)줄바꾸지 않는 출력 : System.out.print("출력문자열")
/*
		  ex) 국어 70
		      영어 80
		      수학 90
		      위 모양 출력하기 
*/
		System.out.print("국어 ");
		System.out.println(70);
		System.out.print("영어 ");
		System.out.println(80);
		System.out.print("수학 ");
		System.out.println(90);             
		
/*
		3) 문자열 출력 특수 문자
		1. \t : 탭간격 출력명령어
		2. \n : 줄바꿈명령어
		3. \" : ""사이 문자열 안에 " 표시
			''는 ""사이에 있기에 허용하고 있다.
*/
//		ex) 다음과 같이 출력하세요
//		국어		영어		수학
//		90		80		90
//		내가 아는 학교 친구들
//		1. 김길동
//		2. 홍길동
//		3. 마길동 ==> 한라인에 문자열 표현
//		오늘은 "자바 프로그래밍과정" 시작입니다!!
		System.out.println("국어\t영어\t수학");
		System.out.println("90\t80\t90");
		System.out.println("내가 아는 학교 친구들");
		System.out.println("1. 김길동\n2. 홍길동\n3. 마길동");
		System.out.println("오늘은 \"자바 프로그래밍과정\" 시작입니다!!");
/*
[1단계:개념] 4. 변수명의 선언 규칙을 예제를 통하여 기술하세요
		
		번수의 명명규칙
		1. 첫번째 글자는 문자이어야 한다. - 숫자로 시작하면 에러발생 
		2. 특수문자는 $, _만 허용된다. 그외는 에러발생
		3. 대소문자를 구분하여, 같은 글자라도 대소문자가 다르면 다른 변수로 인식한다.
		   => 동일한 변수명으로 선언하지 못한다.
		   => 선언할 때만 동일한 변수를 선언하지 못하지,
		      할당은 재할당 되는 것이므로 동일한 변수로 사용할 수 있다.
		4. 내장된 예약어는 변수로 사용할 수 없다.
		   for, if, break, while 등 명령처리시 사용되는 예약어를 변수로 사용할 수 없다.
 */
//		int num01 = 25;
//		ins 01num01 = 25; 숫자로 시작해서 에러발생
		String $str = "안녕";
		String apple_name = "사과";
//		var #num01; // 기타 특수문자는 에러가 발생
		int Num01 = 30;
//		int Num01 = 30;
//		var num02 = 70;
//		var num02 = 50; 선언은 동일한 변수 불가
		num02 = 90; // 선언된 내용을 할당하는 것은 가능
//		num02 = "안녕"; 한번 할당한 변수는 다른 데이터로 할당 불가능(프로그램마다 차이 있음)
//		int for = 30; 예약어를 번수로 사용할 수 없다. 대부분 예약어는 진하게 표현되어 있고, 에러를 표기해준다.
		
/*
[1단계:개념] 5. 기본 데이터 유형을 나열하고, 해당 데이터를 할당하여 출력하는 예제를 만드세요
		
		기본 데이터 유형
		1) stack 영역에서 바로 할당하여 사용하는 데이터 유형
		2) 숫자형 (정수,실수)
		3) 문자형 - 형태는 숫자형 *주의-문자형은 기본데이터유형, 문자열은 객체유형이다.
		4) 논리형 boolean 1byte
		
		ex) byte유형으로 100를 할당
			int 유형으로 50000을 할당
			long 유형으로 30억을 할당
			float 유형으로 3.141592를 할당
*/
		byte num1 = 100;
		int num2 = 50000;
		long num3 = 3000000000L;
		float num4 = 3.141592F;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		
/*
[1단계:개념] 6. 형변환이란 무엇인가 예제를 통해서 기술하세요.
		
		형변환
		형변환이란? 데이터 타입을 다른 타입으로 변환하는 것을 말한다.
		1) 기본 데이터 타입끼리
			작 <==> 큰, 실수 <==> 정수
		2) 객체형끼리 변경
			문자열 데이터와 숫자변경
			
		!!매우 중요한 부분!!
		자바는 정수/정수형은 정수형 처리된다.
		소숫점이하를 처리해주지 않는다.
		==> 소숫점이하를 처리하기 위해서는 나눗셈의 데이터중 적어도 하나는
		실수형으로 형변환하여 처리하여야 한다.(강제형변환-casting)
		cf) casting은 무조건 큰데이터를 작은데이터에 할당하는 것이 아니라,
		데이터유형의 크기/종류에 상관없이 강제 형변환 시 사용한다.
		
		ex) 문자열 "80"과 "10"을 정수형으로 형변환하여, 합산된 결과를 출력하세요.
		ex) 문자열 "31.7"과 "41.2"을 실수형으로 형변환하여, 합산된 결과를 출력하세요.
 */
		int num001 = Integer.parseInt("80");
		int num002 = Integer.parseInt("10");
		System.out.println(num001+num002);
		
		String num7Str = "80";
		String num8Str = "10";
		int num7 = Integer.parseInt(num7Str);
		int num8 = Integer.parseInt(num8Str);
		System.out.println(Integer.parseInt(num7Str)+Integer.parseInt(num8Str));
							
		String num3Str = "31.7";
		String num4Str = "41.2";
		double num003 = Double.parseDouble(num3Str);
		double num004 = Double.parseDouble(num4Str);
		System.out.println(num003+num004);
	
//		String num3Str = "30.7";
//		String num4Str = "40.2";
		double num5 = Double.parseDouble("31.7");
		double num6 = Double.parseDouble("41.2");
		System.out.println(num5+num6);
		System.out.println(Double.parseDouble("31.7")+Double.parseDouble("41.2"));
		
/*
[1단계:코드] 7. 21억, 15억 데이터를 int에 할당하고, 합산결과를 변수를 선언하여 할당 출력하세요
*/		
		int num111 = 2100000000;
//		21억 초과시 long에 할당하여 L/l을 붙여야함
//		ex) long num111 = 220000000L;
		int num222 = 1500000000;
		System.out.println((long)num111+(long)num222);
		
/*
[1단계:개념] 8. char유형과 code값의 관계에 대하여 기술하세요.
		
		자바에서는 char유형과 String 구분한다.
		char code01 = 'A'; // ''한자만 입력
		char[] code02 = {'H','e','l','l','o'}; // ''한자만 입력
		자바에선 {}를 통해 배열을 나타낸다.
		String str01 = "Hello"; // ""한자를 포함하여 입력
*/		
	
/*		
[1단계:코드] 9. 알파벳의 코드값 범위와, 문자 0부터 9까지 범위의 코드값 범위를 확인하고 출력하세요.
*/		
//		알파벳 대문자 : 65~90
//		알파벳 소문자 : 97~122
		
//		알파벳 대문자
		for(int num011=65;num011<=90;num011++) {
			System.out.print(num011+":");
			System.out.println((char)num011);
		}
//		알파벳 소문자
		for(int num012=97;num012<=122;num012++) {
			System.out.print(num012+":");
			System.out.println((char)num012);
		}
//		문자 0부터 9까지 범위의 코드값
		for(int num013=0;num013<=9;num013++) {
			System.out.print(num013+":");
			System.out.println((char)num013);
		
		}

	}

}