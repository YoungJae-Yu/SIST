package javaexp.z01_JavaPro;

public class Z02_JavaPro {

	public static void main(String[] args) {
	
		
		
//		17:05~
//		0331 과제_3강의실_유영재
//		[1단계:개념] 1. 연산자, 피연산자, 연산식을 예제로 만들어, 해당 내용을 구분하여 설명하세요
	
//		1. 연산자(operations)
//	 		연산에 사용되는 표시나 기호
//				+,-,*,/,%,=,!=,...
//		2. 피연산자(operand)
//			연산 대상이 되는 데이터 98, 16 = 피연산자	
//		3. 연산식(expressions) = 연산자 + 피연산자
//			연산자와 피연산자를 이용하여 연산의 과정을 기술한 것
//			ex) 숫자를 2개 할당하여 연산자를 사용하여 수식을 만들고 출력하세요.
		int num01 = 98;
		int num02 = 16;
		System.out.println(num01+" + "+num02+" = "+(num01+num02));
		System.out.println(num01+" - "+num02+" = "+(num01-num02));
		System.out.println(num01+" × "+num02+" = "+(num01*num02));
		System.out.println(num01+" ÷ "+num02+" = "+(num01/num02));
		System.out.println(num01+" % "+num02+" = "+(num01%num02));		
		
//		[1단계:개념] 2. 산술연산자의 종류와 그 특징을 예제를 통하여 설명하세요.
//		산술연산자 : 사칙연산자 + 나머지연산자
//		+, -, *, /, %
//		ex) 피연산자를 할당 하세요.
		int applePrice = 3000; //사과가격
		System.out.println("사과 구매가격:"+applePrice);
		int buyCnt = 10; //사과 구매갯수
		System.out.println("사과 구매갯수:"+buyCnt);
//		각잔 용량
//		ex) 위 피연산자를 활용하여 연산식을 만들고 출력하세요.
//		3000 사과를 10개 구매하였고, 총 금액을 출력하세요.
		int totPrice = applePrice*buyCnt;
		System.out.println("사과 구매금액:"+totPrice);
		
//		[1단계:코드] 3. 500cc의 오렌지쥬스를 3잔에 나누어 할당할려고 한다. 소숫점 이하가 처리된 경우와
//		         소숫점 이하가 처리되지 않는 경우를 나누어 코딩하세요
//		소숫점 이하 처리된 경우
		double oranJus = 500;
		double glass = 3;
		double volume = (oranJus/glass);
		System.out.println(volume); 
//		소숫점 이하 처리되지 않는 경우
		int oranJus1 = 500;
		int glass1 = 3;
		int volume1 = (oranJus1/glass1);
		System.out.println(volume1);
		
//		[1단계:개념] 3. 증감연산식의 앞에 ++, 뒤에 ++의 차이점을 예제를 통하여 기술하세요.
//		증감연산자++,-- : 1씩 증가하고 감소하는 연산
		int cnt = 0; //ex) 초기값이 0인 경우
		System.out.println(cnt++); //뒤에 ++은 출력하고 더한다 ==> 출력값0 실제값1
		System.out.println(++cnt); //앞에 ++은 더하고 출력한다 ==> 출력값2 실제값2

//		[1단계:개념] 5. 증감대입연산자의 종류를 기술하고 예제를 통하여 설명하세요. 
//		증감대입연산자 종류 : +=, -=, (+=,/=,%=...) 특정한 수만큼 증가하고 감소하는 연산자
		
		int cnt2 = 0;
		cnt2 += 1 ;System.out.println(cnt2); //+= ==> cnt2 = cnt2 + 1 의 연산을 해준다.
		cnt2 -= 1 ;System.out.println(cnt2); //+= ==> cnt2 = cnt2 - 1 의 연산을 해준다.
		
//		[2단계:코드] 4.구매하는 김밥의 갯수를 선언하고, 1씩 증가하여 김밥의 단가(2500) 아래와 같이 출력
//		      김밥 1개 구매  2500 
//		      김밥 2개 구매  5000
//		      김밥 3개 구매  10000
		int kimbapNum1 = 1;
		int kimbapNum2 = (++kimbapNum1);
		int kimbapNum3 = (++kimbapNum2);
		int kimbapPrice1 = kimbapNum1*2500;
		int kimbapPrice2 = kimbapNum2*2500;
		int kimbapPrice3 = kimbapNum3*2500+2500; //확인 후 수정 必
		System.out.println("김밥 1개 구매 "+kimbapPrice1);
		System.out.println("김밥 2개 구매 "+kimbapPrice2);
		System.out.println("김밥 3개 구매 "+kimbapPrice3);
		
//		[1단계:개념] 6. 문자열의 비교연산자 사용에서 ==, equals()의 차이점을 기술하세요.
//		== Stack,Heap데이터 전송시 동일 문자열인 경우 동일 주소를 받는다 A==B ture
//		equals() Stack,Heap데이터 전송시 각 각 생성되어 다른 주소를 받아 문자열은 같아보여도 A==B false가 출력된다.
//		자바에서만 적용되는 내용이지만, 원리적으로는 반드시 equals()를 사용하는게 옳다.
		
//		[1단계:개념] 7. main()의 args[]의 처리 내용방법 자바 코드를 통한 처리와 함께 기술하세요. 
		
//		System.out.println(args[0]); //매개변수를 활용한다.
//		System.out.println(args[1]); //run configuration에 데이터를 입력하고 args[]배열로 출력
//		System.out.println(args.length); //args.length로 배열의 크기를 알 수 있다.
		
//		[2단계:코드] 8. args로 물건명1 가격1 갯수1 물건명2 가격2 갯수2로 입력받아 계산서(전체 총계포함)를 출력하세요.
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[4]);
		System.out.println(args[5]);
			
//		[1단계:개념] 9. Scanner의 처리방법을 간단한 예제와 함께 기술하세요.
//		[1단계:코드] 10. Scanner객체를 활용하여 타율계산방법을 확인(검색)하고, 선수명, 타석수, 안타수를 입력 받아 해당 타자의 타율을 출력하세요.
//		[1단계:개념] 11. 비교연산자의 종류를 예시와 함께 기술하세요.
//		[1단계:코드] 12. Scanner를 활용하여 나이를 입력 받아 성인(18이상)여부를 출력하세요 
//		[1단계:개념] 13. 논리연산자의 종류를 예제와 함께 기술하세요.

		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
