package javaexp.z01_JavaPro;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Z19_0502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		2023-05-02
//		[1단계:확인] 1. 사용자 정의 예외 4지 선다 문제를 틀리면 사용자 예외 객체 생성, 맞으면 정답으로 처리.
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Q.오늘은 몇요일인가요?\n1.화 2.수 3.목 4.금");
//		System.out.print("정답을 입력하세요:");
		
//			try {
//				System.out.print("정답을 입력하세요:");
//				int a = sc.nextInt();
//				if(a==1) {
//					throw new Exp("정답");
//				}
//			}catch(Exp e) {
//				System.out.println(e.getMessage());
//			}
//		
//		System.out.println("등록 성공");
	
//		[1단계:개념] 2. Math.random()과 Random 클래스의 차이점을 기능 메서드 위주로 기술하세요.
//		1. boolean, int, long, float, double 등의 
//			데이터를 메서드를 이용해서 임의로 처리 할 수 있다.
//      2. 난수를 만드는 알고리즘에 사용되는 종자값(seed) 설정 
//	        가능하여 처리된다. 종자값이 설정되면 처음에 나온 임의 수는 계속 보존된다. 
//	  	Random r1 = new Random();
//	  	System.out.println(r1.nextBoolean());
//	  	System.out.println(r1.nextDouble());
//	  	System.out.println(r1.nextInt()); // 실수 범위 
//	  	// r1.nextInt(경우의수)+시작수
//	  	System.out.println(r1.nextInt(5)+1);
//	  	System.out.println("주사위:"+r1.nextInt(6)+1);
//	  	System.out.println("0~100:"+r1.nextInt(101));
		
//		[1단계:확인] 3. Random를 활용하여 10번 홀짝 게임 결과를 출력하세요.
		Random r = new Random();
		System.out.println("홀짝게임!");
		for(int cnt=0;cnt<10;cnt++) {	
			System.out.print(cnt+1+"번째 게임결과:");
			System.out.println(r.nextInt(2)==1?"홀":"짝");
		}
		/*
		-출력결과-
		홀짝게임!
		1번째 게임결과:홀
		2번째 게임결과:홀
		3번째 게임결과:짝
		4번째 게임결과:짝
		5번째 게임결과:홀
		6번째 게임결과:홀
		7번째 게임결과:짝
		8번째 게임결과:홀
		9번째 게임결과:짝
		10번째 게임결과:짝
		*/
//		[1단계:확인] 4. Random를 활용하여 컴퓨터와 가위/바위/보 게임 3회를 실시하여 @승 @무 @패 출력하세요.
		
		int w = 0;
		int l = 0;
		int d = 0;
		System.out.println("컴퓨터의 가위바위보!");
		for(int cnt=0;cnt<3;cnt++) {
			System.out.print(cnt+" 번째 게임:");
			Random r1 = new Random();
			Random r2 = new Random();
			int me = r1.nextInt(3);
			int comp = r2.nextInt(3);
			if(me==comp) {//0가위 1바위 2보
				System.out.println("무승부!");
				d += 1;
			}else if(me==0 && comp==1) {
				System.out.println("패배!");
				l += 1;
			}else if(me==0 && comp==2) {
				System.out.println("승리!");
				w += 1;
			}else if(me==1 && comp==0) {
				System.out.println("승리!");
				w += 1;
			}else if(me==1 && comp==2) {
				System.out.println("패배!");
				l += 1;
			}else if(me==2 && comp==0) {
				System.out.println("패배!");
				l += 1;
			}else if(me==2 && comp==1) {
				System.out.println("승리!");
				w += 1;
			}
		}
		System.out.println(w+"승\t"+d+"무\t"+l+"패\t");
		/*
		-출력결과-
		컴퓨터의 가위바위보!
		0 번째 게임:무승부!
		1 번째 게임:승리!
		2 번째 게임:무승부!
		1승	2무	0패
		*/
		
//		[1단계:개념] 5. 컬렉션 상위 3개 인터페이스의 특징을 기술하세요.
//      1) List : 순서를 유지하고 저장 중복 저장 가능
//		2) Set : 순서를 유지하지 않고 저장 중복저장 불가능
//		3) Map : 키와 값의 쌍으로 저장 키는 중복 저장 안됨.	
		
//		[단계별:확인] 
//		1단계 1~10까지 숫자 카드를 만들어 List<String>에 담아서, 임의의 숫자를 1개를 출력하세요
		ArrayList<String> nlist = new ArrayList<String>();
		 nlist.add("1번 카드");
		 nlist.add("2번 카드");
		 nlist.add("3번 카드");
		 nlist.add("4번 카드");
		 nlist.add("5번 카드");
		 nlist.add("6번 카드");
		 nlist.add("7번 카드");
		 nlist.add("8번 카드");
		 nlist.add("9번 카드");
		 nlist.add("10번 카드");
		 System.out.println(nlist.get((int)(Math.random()*10)));
		 /* 출력결과:6번 카드 */
		 
//		2단계 A~10,J,Q,K번호 문자로 만들어 List<String>를 임의의 카드를 7장을 출력하세요
		 ArrayList<String> nlist1 = new ArrayList<String>();
		 nlist1.add("A");
		 nlist1.add("2");
		 nlist1.add("3");
		 nlist1.add("4");
		 nlist1.add("5");
		 nlist1.add("6");
		 nlist1.add("7");
		 nlist1.add("8");
		 nlist1.add("9");
		 nlist1.add("10");
		 nlist1.add("J");
		 nlist1.add("Q");
		 nlist1.add("K");
		 int rc = (int)(Math.random()*13);
		 for(int cnt=0; cnt<7; cnt++) {
			 System.out.println(cnt+1+" 번째 임의의 카드:"+nlist1.get(cnt));
		 }
//		3단계 카드클래스(두가지 속성 - 모양♣,♥,♠,◆,번호 A~10,J,Q,K)를 선언하고,
//		 52개의 카드를 만들어(for문 활용) List에 담아서 출력하세요
		 
//		4단계 카드클래스(모양,번호)를 선언하고, 52개의 카드를 만들어(for문 활용) List에 담아서,
//		 임의의 카드를 7장을 출력하세요 4명의 참가자에게 돌리세요
	}

}
//class Exp extends Exception{
//	public Exp(String message) {
//		super("입력한 답은 "+message+"입니다.");
//	}
//	@Override
//	public String getMessage() {
//		return "오답입니다.";
//	}
//}
