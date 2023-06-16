//package javaexp.z01_JavaPro;
//
//import java.util.Scanner;
//
//public class Z04_JavaPro {
//
//	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		04/04
//		[1단계:개념] 1. for문의 기본 구성요소를 기본 예제를 통하여 특징을 기술하세요.
//		ex) 1~5 카운트 출력
//		for(int cnt = 1; cnt<=5; cnt++) { //<= 증가 >= 감소 
//			System.out.println("카운트:"+cnt); // ++ 1씩증가 --1씩감소
//		}
//		
////		[1단계:코드] 2. for(기본) 기본 형식을 활용해서 아래 데이터를 출력하세요
////		              1) 200~300 10단위 출력, 2) 1000~950 3단위 감소, 3) 100~0까지 2로 나눈값
//		for(int cnt=200;cnt<=300;cnt+=10) {
//			System.out.println(cnt);
//		}
//		for(int cnt=1000;cnt>=950;cnt-=3) {
//			System.out.println(cnt);
//		}
//		for(int cnt=100;cnt>=0;cnt--) {
//			System.out.println(cnt/2.0);
//		}
//		
////		[1단계:개념] 3. for문의 지역변수와 전연변수의 개념을 예제를 통해서 설명하세요
////		ex) 1~10 누적값을 출력하세요.
//		int tot = 0; // 초기값 전역변수
//		for(int cnt=1;cnt<=10;cnt++) {
////			int a = 0; 지역변수는 cnt와 같이 쓰인다.
////			a += cnt; 지역변수는 누적이 되지 않는다.
//			tot+=cnt;
//		}
//		System.out.println("1~10의 누적값:"+tot);
//		
////		[1단계:개념] 4. for문의 전역변수를 활용한 출력형태를 예제를 통해 설명하세요 
////		ex) 김밥 3줄을 구매하고, 각각의 가격을 입력하여 총비용을 출력하세요.
//		int totPrice = 0;
//		Scanner sc = new Scanner(System.in);
//		for(int cnt=1;cnt<=3;cnt++) {
//			System.out.print(cnt+"번째 김밥 가격 입력:");
//			totPrice+=sc.nextInt();
//		}
//		System.out.println("총비용:"+totPrice);
		
//		[1단계:코드] 5. 입력할 과일의 3개의  과일명과 과일가격을 입력받아, 아래 형식으로 출력하되 총비용을 출력 하세요
//		                no 과일명  가격
//		                 1 사과    3000            
//		                 2 바나나   4000           
//		                 3 딸기    12000
//		                   총계    19000    
		/*
		전역변수 : 총계값(totPay), 전체계산내용 출력문자열(show)
		지역변수 : 번호 no, 과일명(fname), 과일의가격(price)
		Scanner sc = new Scanner(System.in);
		.nextInt(), nextLine(),
		Integer.parseInt()
		for(int cnt=1;cnt<=3;cnt++){}
		*/
		
//		Scanner sc = new Scanner(System.in);
//		int totPay = 0;
//		String show="no\t과일명\t가격\n";
//		for(int cnt=1;cnt<=3;cnt++) {
//			System.out.println(cnt+"번째 과일 정보 입력:");
//			System.out.print("과일명:");
//			String fname = sc.nextLine();					
//			System.out.print("과일가격:");
//			int price = Integer.parseInt(sc.nextLine());
//			show += cnt+"\t"+fname+"\t"+price+"\n";
//			totPay += price;
//		}
//		show+="\t총계\t"+totPay;
//		System.out.println(show);
		
		
		
//		int totPrice1 = 0;
//		Scanner sc1 = new Scanner(System.in);
//		
//		System.out.println("과일명과 과일 가격을 순서대로 입력하세요:");
//		System.out.println("no "+"과일명\t가격");
//		for(int cnt=1;cnt<=3;cnt++) {
//			
//			
//			int fNum = sc1.nextInt();	
//			totPrice1+=fNum;
//			System.out.print(cnt+" 사과\t"+fNum); // 재검토 필요
//		}
//		
//		System.out.println("총계\t"+totPrice1);		
		
		
//		[1단계:코드] 6. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 
//					 총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
//		               # 출력 형식
//		               날짜  갯수 누적
//		               1일차 2개  2개
//		               2일차 4개  6개
//		               3일차 6개 12개
//		int bread = 0;
//		int tot = 0;
//		System.out.println("날짜\t갯수\t누적");
//		for(int cnt=1;cnt<=10;cnt++) {
//			bread += 2;
//			tot += bread;
//			System.out.print(cnt+"일차\t");
//			System.out.print(bread+"개\t");
//			System.out.print(tot+"개\n");
//		}
			
//		[1단계:코드] 7. for을 이용하여 100까지 4의 배수만 # 표시 및 합산,그 외는 숫자 표시, 하단에 4의 배수 합산표시.
//		int tot = 0;
//		for(int cnt=1;cnt<=100;cnt++) {
//			if(cnt%4==0) {
//				System.out.print("#");
//				tot += cnt;
//			}
//			System.out.println(cnt);
//		}
//		System.out.println("4의 배수 합산:"+tot);
		
		
//		[2단계:코드] 8. for을 이용하여 3,6,9게임을 출력하세요(20까지)- 마지막에 3이 포함될 때 처리
//		for(int cnt=1;cnt<=20;cnt++) {
//			if(cnt>=10) {
//				if(cnt%3==0)
//				System.out.print("짝!,");	
//			}
//			else if(cnt%10==3||cnt%10==6||cnt%10==9) {
//				System.out.print("짝!,");
//			}else
//					System.out.print(cnt+",");
//			}
//			System.out.println(); 
	
//			for(int cnt=1;cnt<=20;cnt++) {
//				if(cnt>=) {
//					System.out.print("짝!,");	
//				}if(cnt/10==3||cnt/10==6||cnt/10==9) {
//					System.out.print("짝!,");
//				}else
//						System.out.print(cnt+",");
//				}
//				System.out.println(); 
	
//		[1단계:개념] 9. 2중 for문을 기본형식을 예제를 통하여 설명하세요.
//		ex) 관중석 좌석에 번호를 부여하고 출력하세요.(가로줄 5 새로줄 9)	
//			for(int row=1;row<=9;row++) { //상위 row변수가 반복을 처리하고
//				for(int col=1;col<=5;col++) { //각 단위별로 한번더 반복처리한다.
//					System.out.print(row+""+col+" ");				
//				}
//				System.out.println();
//			}		
				
//		[1단계:코드] 10. 아래 내용을 2중 for문을 활용하여
//        1) 2X2(행X열)로 ♥를 표시 2) 3X2(행X열)로 ★표시 3) 입력한 행/열로 입력한 기호표시
//		for(int row=1;row<=3;row++) {
//			for(int col=1;col<=3;col++) {
//				System.out.print("("+row+"X"+col+")\t");				
//			}if(row==2&&col==2) {
//				System.out.println("♥\t");
//			}else if(row==3&&col==2){
//				System.out.println("★\t");
//			}
//		}

//[1단계:개념] 11. while문의 기본 형식을 예제를 통해 설명하세요.
//ex) 메뉴를 입력받아 원하는 점심 메뉴가 들어올때 까지 처리
//int cnt=1;
//while(cnt<=100) {
//System.out.println((cnt++)+"번째 반복");
//}
//Scanner sc = new Scanner(System.in);
//String food = "";
//String food1 = "";
//while(!food.equals("치킨")) {
//System.out.print("먹고싶은 메뉴 입력:");
//food = sc.nextLine();
//System.out.println("입력한 내용:"+food);
//}if(!food.equals("치킨")) {
//	food1+=food+" ";
//}
//System.out.println("먹고싶은 메뉴 리스트:"+food1);
//System.out.println("종료!!");
//}
//

//[1단계:개념] 12. while문을 이용하여 100~90까지 출력하고, 합산결과를 출력하세요.
//int tot = 0;
//int cnt = 100;
//while(cnt<=90) {
//	System.out.println(cnt--);
//	tot += cnt;
//	}
//	System.out.println("합산결과:"+tot);

//[1단계:코드] 13. while문을 이용해서 학생의 점수를 등록하고 총점과 평균을 출력하되,
//         등록을 종료시 -1를 입력해서 처리하세요.
// Scanner sc = new Scanner(System.in);
// System.out.print("학생의 점수 입력(-1입력종료):");
// int totPoint = 0;
// int avPoint = 0;
// int num = 0;
// int point = sc.nextInt();
// while(true) {
//   if(point==-1) {
//  System.out.println("종료");
//				 break;
//  	}else {
//				num++;
//				totPoint += point;
//				avPoint = totPoint/num;
//			}
//  System.out.println("총점:"+totPoint);
//  System.out.println("평균:"+avPoint);
//}

//[1단계:개념] 14. 반복문에서 break와 continue의 차이점을 기본 예제를 통하여 기술하세요		

//		ex) 1~10중에 출력을 5에서 멈추세요.
//		for(int cnt=1;cnt<=10;cnt++) {
//			if(cnt==5) {
//				break; //break는 중단처리
//			}
//		}
//		ex)1~10중에 출력을 5는 건너뛰세요.
//		for(int cnt=1;cnt<=10;cnt++) {
//			if(cnt==5) {
//				continue;
//			}
//				System.out.println(cnt);
//		}
//	}
//}