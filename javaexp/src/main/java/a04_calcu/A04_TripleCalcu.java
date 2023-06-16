package javaexp.a04_calcu;

import java.util.Scanner;

public class A04_TripleCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		# 삼항연산자
		0. 항
			단연산자 =, cnt++ ...
			이항연산자 cnt + cnt2, num01 * num02
			삼항연산자 연산자와 피연산자를3개를 사용하는 것을 말한다.
		1. 세개의 피연산자를 필요로 하는 연산식
		2. 기본 형식
			비교연산자|논리연산자?true일때:false일때
			ex) 나이가 18세이상이면 성인 처리 그외는 미성년자 처리
			String divAdult = age>=18?"성인":"미성년자";
			ex) 구매한 물건의 총계가 10만이상이면 할인율 15%
				그외는 5%처리
			double disRatio = buyProd>=100000?0.15:0.05;
		*/
//		ctrl + shift + o : 자동 import
//		Scanner sc = new Scanner(System.in);
//		System.out.print("나이를 입력하세요:");
//		int age = sc.nextInt();
//		System.out.println("입력한 나이:"+age);
//		String divAdult = age>=18?"성인":"미성년자";
//		System.out.println("구분:"+divAdult);
		
//		ex) 획득한 점수를 입력하세요 점수기준으로 60이상이면 합격
//			그외는 불합격을 출력하세요.
//		System.out.print("획득한 점수를 입력하세요:");
//		int score = Integer.parseInt(sc.nextLine());
//		System.out.println("입력한 점수:"+score);
//		String divAdult = score>=60?"합격":"불합격";
//		System.out.println("구분:"+divAdult);
		
//		ex) 나이에 따른 무료/유료 구분 처리
//		System.out.print("나이를 입력하세요:");		
//		int age = Integer.parseInt(sc.nextLine());
//		String divFree = age<5||age>=65?"무료":"유료";
//		System.out.println("입장자의 나이:"+age);
//		System.out.println("무/유료 구분:"+divFree);
		
//		ex) 나이에 따라 청소년요금제/일반요금제 구분
//			청소년요금제(14~17)
//		String divAdole = age<18&&age>=14?"청소년요금제":"일반요금제";
//		System.out.println("요금제 적용 나이:"+age);
//		System.out.println("요금제 구분:"+divAdole);
		/*
		# 기본형식..
		1. 조건문
			if(조건식){
				true일 때, 처리할 내용
			}else {
				false일 때, 처리할 내용
			}
			ex)
			String result="";
			int age = sc.nextInt(); //입력받은 나이..
			if(age>=18){
				result = "성인";
			}else {
				result = "미성년자";
			}
			System.out.println("결과:"+result);
			
		2. 삼항연산자
			조건문|논리연산식?true일 때 처리할 데이터:false일 떄 처리할 데이터;
			int age = sc.nextInt();
			String result = age>=18?"성인":"미성년자";
			
			int Point = sc.nextInt();
			// 점수를 입력받아서 합격/불합격처리
			점수가 60점 이상이면 "합격" passRst에 할당,
			그외는 "불합격" 데이터를 passRst에 할당
			String passRst= point>=60?"합격":"불합격";
			//아이디와 패스워드를 입력받아서..
			String id = sc.nextLine();
			String pass = sc.nextLine();
			
			String loginRst = id.equals("himan")&&pass.equals("7777")?"로그인성공":"로그인실패";
			System.out.println("로그인결과:"+loginRst);					
		*/
		
		//ex) 삼항 연산자를 이용해서 구매한 물건 가격과 갯수를
		//	입력받아 100000 이상이면 "고급사은품"
		//	그외는 "일반사은품"이라고 사은품을 구분하여 할당되게 하세요..
		Scanner sc = new Scanner(System.in);
		System.out.print("구매한 물건의 가격:");
		int buyprice = sc.nextInt();
		System.out.print("구매한 물건의 갯수:");
		int buycnt = sc.nextInt();
		int buytot = buyprice*buycnt;
		String gift = buytot>=100000?"고급사은품":"일반사은품";
		System.out.println("구매비용 총계:"+buytot);
		System.out.println("사은품 내용:"+gift);		
	}

}
