package javaexp.a04_calcu;

public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		# 연산자란?
		1. 데이터를 처리하여 결과를 산출하는 거슬 말한다.
		2. 연산자(operations)
			1) 연산에 사용되는 표시나 기호
				+,-,*,/,%,=,!=,...
		3. 피연산자(operand)
			연산 대상이 되는 데이터
		4.연산식(expressions) = 연산자 + 피연산자
			연산자와 피연산자를 이용하여 연산의 과정을 기술한 것
			ex) 25 + 2, num01 + num02
			30 * 2 =5
			30, 2 : 피연산자
			*, = : 연산자
			피연산자 + 연산자 : 연산식
			
		# 연산자의 종류
		1. 산술연산자 : 사칙연산자 + 나머지연산자
			+, -, *, /, %
		*/
		int num01 = 25;
		int num02 = 7;
		System.out.println(num01+" + "+num02+" = "+(num01+num02));
		System.out.println(num01+" - "+num02+" = "+(num01-num02));
		System.out.println(num01+" × "+num02+" = "+(num01*num02));
		System.out.println(num01+" ÷ "+num02+" = "+(num01/num02));
		System.out.println(num01+" % "+num02+" = "+(num01%num02));
//		ex1) 곰돌이 3마리가 빵 25개를 먹었다. 공평하게 나눈갯수와 나머지 빵의 갯수를 출력하되,
//			 변수를 효과적으로 사용하고 연산자를 처리하여 출력하세요.
		int a = 25;
		int b = 3;		
		System.out.println("공평하게 나눈 빵의 갯수 : "+(a/b));
		System.out.println("나머지 빵의 갯수 : "+(a%b));
		
//		ex2) 사과 단가가 2000원 하는 것을 5개 구매하였다. 총비용을 출력하세요.
		int g = 2000;
		int h = 5;		
		System.out.println("사과 5개 구매 비용 : "+(g*h));
		
//		ex3) 현재 지갑속에 20000원이 있는데, 교통비로 2000원 2번 식대로7000원을 지출하였다.
//			 잔액을 출력하세요(변수활용)
		int c = 20000;
		int d = 2000;
		int e = 2;
		int f = 7000;
		System.out.println("잔액 : "+(c-d*e-f));
		/*
		
		2. 부호 : +, -
			ex) int num01 = 25;
				int num02 = -num01; //-25
				int num03 = -num02; //25
		*/
		int num03 = 25;
		int num04 = -num03;
		System.out.println("부호연산자 - 추가시 : "+num04);
		int num05 = -num04;
		System.out.println("한번더 부호연산자 - 추가시 : "+num05);

//		ex) 총금액과 지출금액을 지정/선언하고, 위에 부호연산자를
//		    이용해서 남은 잔액을 출력하세요.
		int totPay2 = 10000;		
		int spendPay2 = 5000;
		int spendPay3 = -spendPay2;
		int tot = spendPay3+spendPay2;
		System.out.println(tot);
		/*
		3. 대입 : =
			왼쪽데이터에서 오른쪽 변수에 할당할 때 사용
			int num04 = 50;
		*/
		int cnt1,cnt2,cnt3,cnt4,cnt5;
		cnt1=cnt2=cnt3=cnt4=cnt5=1;
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
		System.out.println(cnt4);
		System.out.println(cnt5);
		/*
		4. 증감연산자 : ++, --
			1씩 증가하고 감소하는 연산
			int cnt = 0;
			cnt++; 1씩증가
			cnt++;
			System.out.println(cnt); 2
			cnt--;cnt--;cnt--; 1씩감소
			System.out.println(cnt); -1
		*/
		System.out.println("증감연산자 처리");
		System.out.println(cnt1++);//출력하고 더하기
		System.out.println(cnt1++);//출력하고 더해서 마지막에 cnt3
		System.out.println(++cnt1);//더하고 출력
		System.out.println(++cnt1);//더하고 출력
		System.out.println(cnt1--);//출력하고 빼기
		System.out.println(--cnt1);//빼고 출력		
		/*
		5. 증감대입연산자 : +=, -=, (+=,/=,%=...)
			특정한 수만큼 증가하고 감소하는 연산자 처리
			int cnt = 0;
			cnt = cnt + 2
			cnt = cnt + 2 // cnt = 4
			cnt += 2; // cnt = 6
			cnt += 5; // cnt = 11
			cnt = cnt - 3; // cnt = 8
			cnt -= 3; // cnt = 5
		*/
		System.out.println("#증감 대입연산자");
		cnt2 = cnt2 + 2; System.out.println(cnt2);
		cnt2 += 2; System.out.println(cnt2);
		cnt2 += 5; System.out.println(cnt2);
		cnt2 += 5; System.out.println(cnt2);
		
		/*
		6. 비교연산자 : 비교식을 이용해서 true/false 값을 리턴하는 연산자를 말한다.
			== (동일할 때), !=(동일하지 않을 때)
			>(초과), <(미만), >=(이상), <=(이하)
			int point = 30;
			boolean isPass1 = point==60; false
			boolean isPass2 = point!=60; true
			boolean isPass3 = point>=60; 
				piont가 60이상일 때, true, 현재는 결과가 false
			ps) 자바에서만 사용하는 문자열 비교
			String str1 = new String("himan");
			String str2 = new String("himan");
			String str3 = "higirl";
			String str4 = "higirl";
			System.out.println(str1==str2); //false
			System.out.println(str3==str4); //true
			
			# 결론 자바에서는 문자열을 비교할 때는 .equals()를 이용해서 비교해야 한다.
		*/
		int point = 50;
		System.out.println("합격여부(60점이상):"+(point>=60));
		boolean isPass = point>=60;
		System.out.println("합격여부(변수할당):"+isPass);
		/*
		7. 논리연산자
			- 비교연산식이 2개이상, 또는 not(!) 연산자를 이용할 때 논리연산자를 이용해서 처리한다.
			&& : (and) 논리합 두가지 비교연산자가 모두 true일 때, true 그외는 false
				ex) 나이에 따라 청소년요금제 적용 여부
				boolean isAdolPay = age>=14 && age<18
			|| : (or) 논리곱 두가지 비교연산자중 하나이상 true이면, 둘다 false일 때 false
				ex) 놀이공원 나이에 따라 무료입장 적용 여부
				boolean isFree = age<5 || age>=65
			! : 비교연산식이나 논리연산식의 결과가 true이면 false로, false이면 true로 처리
				boolean isPass = point>=60; 합격하는 경우
				boolean isNotPass = !isPass; 불합격하는 경우
				boolean isPay = !isFree; 유료인경우
		
		8. 삼항연산자
			조건(비교연산자, 논리연산자)? A : B
			조건식이 Trus일 때는 A로 처리하고,
			조건식이 False일 때는 B로 처리하는 경우를 말한다.
			한라인에서 조건에 따라 결과를 처리하기에 효과적으로 데이터를 처리를 할 수 있다.
			System.out.println(age>=18?"성인":"미성년자");
					
			
			
			
			
			
			
			
			
			
			
			
		
				
			
			
			
			
			
			
		*/
	}

}
