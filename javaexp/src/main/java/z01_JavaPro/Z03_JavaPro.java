// 3강의실 유영재 과제
package javaexp.z01_JavaPro;

import java.util.Scanner;

public class Z03_JavaPro {

	public static void main(String[] args) {
	
//		04/03
//		[1단계:개념] 1. 3항 연산자의 기본형식을 새로운 예제로 설명하세요
		
//		ex) 주민등록번호 앞자리가 1또는3 이라면 국방의 의무를 지켜야 한다.
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호 앞자리를 입력하세요(1~2)");
		int num = Integer.parseInt(sc.nextLine());
		String mill = num==1?"입대확정..":"군대안감!"; // 비교연산자|논리연산자?true일때:false일때
		System.out.println("당신은.. "+mill);
		
//		[1단계:코드] 2. 3항 연산자를 활용하여 문제(3+4=?)를 내고, 해당 문제의 정답이 맞을 때, 정답 그외는 오답으로 처리하세요
		Scanner sc2 = new Scanner(System.in);
		System.out.print("3 + 4 = ?");
		int num1 = sc2.nextInt();
		String num2 = num1==7?"정답":"오답";
		System.out.println(num2);
		
//		[1단계:개념] 3. Math.random 클래스와 메서드의 기능을 정수의 임의범위 처리 예제를 통해서 기술하세요
//		ex) 1~3사이의 값을 랜덤으로 출력하세요.
		double rd = Math.random(); //기본 범위는 0.0~1.0이며, Math.random()*경우의수+시작수 공식을 활용하여 값을 추출 할 수 있다.
		System.out.println("임의의 수:"+(int)(rd*3+1)); //1~3의 값을 추출하기 위해서는 정수로 캐스팅이 필요하다.
		
//		[1단계:코드] 4. 두 친구가 주사위 2개를 던져서 값을 확인려고 한다. 각각 홍길동/김길동일 때, 각각 나온 주사위 합을 출력하세요
		int rdD = (int)(Math.random()*6)+1;
		System.out.println("홍길동의 주사위 값:"+rdD);
		int rdD1 = (int)(Math.random()*6)+1;	
		System.out.println("김길동의 주사위 값:"+rdD1);
		int tot = rdD+rdD1;
		System.out.println("주사위 값의 합:"+(tot)); //?
		
//		[1단계:개념] 5. if 조건 구문의 기본형식 3개를 예제를 만들어 기술하세요 
//		ex) 치킨을 3마리 시켜먹을때마다 감자튀김을 서비스로 받는다.
//			5마리 시켜먹으면 피자를 서비스로 받는다.
//			7마리 시켜먹으면 치킨을 한마리 서비스로 받는다.
		int ck = 0;
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		if(ck%3==0) {
			System.out.println("감자튀김 서비스!!");
		}
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		if(ck==5) {
			System.out.println("피자 서비스!!");
		}
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		if(ck==7) {
			System.out.println("치킨1마리 서비스!!");
		}
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		System.out.println("치킨을"+(++ck)+"마리 시켜먹었다.");
		
//		[1단계:코드] 6. 넌센스 퀴즈를 검색해서 문제로 만들어 문제가 맞을 때, 정답 그외는 오답이 되게 처리하세요
//		ex) Q) 닿기만 하면 취하는 술은??
		Scanner sc3 = new Scanner(System.in);
		System.out.println("#넌센스 퀴즈#");
		System.out.print("Q) 세상에서 가장 쉬운 숫자는??");
		int answer = sc3.nextInt();
		System.out.println(answer==190000?"정답":"오답"); 
		
//		[1단계:코드] 7. Math.random/Scanner활용하여 컴퓨터가 임의로 구슬을 1~10개 랜덤으로 쥐게하되,
//		           0) 해당 갯수를 맞추는지 여부에 따라 success/failure 처리하게 하세요
//		           1) 1입력시 홀, 0입력시 짝으로 하여 success/failure 처리하게 하세요
//		           2) 홀/짝을 입력하여, success/failure 처리하세요.
		Scanner sc4 = new Scanner(System.in);
		System.out.print("컴퓨터가 임의로 뽑은 구슬은 몇개일까요? (1~10개) : ");
		double rdD2 = Math.random();
		int marble = (int)(rdD2*10+1);
		int inputNum = sc4.nextInt();
		System.out.println(marble==inputNum?"success":"failure");
		
		if(inputNum==1) {
			System.out.println("홀");
		}else if(inputNum==0) {
			System.out.println("짝");
		}
		
		Scanner sc5 = new Scanner(System.in);
		System.out.println("컴퓨터가 임의로 뽑은 구슬은 홀일까요 짝일까요?? (홀&짝)");
		String inputNum1 = sc5.nextLine();
		if(marble%2==0) {
			System.out.println(inputNum1.equals("짝")?"success":"failure");
		}
		
//		[1단계:개념] 8. if else if 구문의 기본예제를 만들어 해당 구문의 기본형식을 설명하세요.
//		ex) 임의로 나이를(숫자) 출력해 나이에 따른 학년을 출력하세요. (17 = 고등학교1학년..)
		int age = (int)(Math.random()*3+17);
		if(age==17) {
			System.out.println("고등학교1학년");
		}else if(age==18) { // 위 조건이 아닌 새로운 조건에 해당하는 코드 처리
			System.out.println("고등학교2학년");
		}else { // 상단에 나열된 조건이외의 경우 처리할 코드 수행
			System.out.println("고등학교3학년");
		}
//		[1단계:코드] 9. 주사위가 임의로 나오게 하여, 컴퓨터가 낸 임의 주사위 수와 내가 낸 임의 주사위 수를
//		           비교하여, 승/무/패를 출력하세요.
		int comRd = (int)(Math.random()*6)+1;
		int myRd = (int)(Math.random()*6)+1;
		if(comRd>myRd) {
			System.out.println("컴퓨터 승!");
			System.out.println("나의 패!");
		}else if(comRd<myRd) {
			System.out.println("나의 승!");
			System.out.println("컴퓨터 패!");
		}else if(comRd==myRd) {
			System.out.println("무승부");
		}
		
//		[1단계:개념] 10. switch case문의 기본형식과 기능내용을 기본 예제를 만들어 설명하세요.
//		ex) 번호를 입력받아서 해당 숫자가 완전수인지 아닌지 출력하세요(1~10)
		Scanner sc6 = new Scanner(System.in);
		System.out.print("1~10중 번호를 입력하세요:");
		int inputNum2 = sc6.nextInt();
		System.out.println("입력한 숫자:"+inputNum2);
		switch(inputNum2) {
		case 1:case 2:case 3:case 4:case 5:case 7:case 8:case 9:case 10:
			System.out.println("완전수가 아닙니다.");
			break;
		case 6:
			System.out.println("완전수 입니다.");
			break;
		default:
			System.out.println("1~10 범위를 벗어났습니다.");
		}
		
//		[1단계:코드] 11. 가고자하는 위치 2개와 집에 가는 노선버스를 검색하여,
//		switch case처리하여 해당 최종 위치를 처리하고, 그외는 정보가 없습니다 라고 표시하세요.
//		ex) 교대역(bus146 --> 7단지영업소), 잠실역(bus9303 --> BRT공영버스차고지)
		Scanner sc7 = new Scanner(System.in);
		System.out.print("탑승하실 버스정류장명을 입력하세요.");
		String input1 = sc7.nextLine();
		System.out.println("입력한 정류장:"+input1);
		switch(input1) {
		case "교대역":case "잠실역":
			System.out.println("탑승하실 버스 번호를 입력하세요.");
			break;
		}
			Scanner sc8 = new Scanner(System.in);
			int input2 = sc8.nextInt();
		switch(input2) {
		case 146:
			System.out.println("입력하신 "+input2+"버스의 종점은 7단지영업소 입니다.");
			break;
		case 9303:
			System.out.println("입력하신 "+input2+"버스의 종점은 BRT공영버스차고지 입니다.");
			break;
		default:
			System.out.println("정보가 없습니다.");		
		}
	}
}
