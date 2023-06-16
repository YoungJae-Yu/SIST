//package javaexp.z01_JavaPro;
//
//import java.util.Scanner;
//
//public class Z05_JavaPro {
//
//	public static void main(String[] args) {
		
//		04/05
//		[1단계:개념] 1. 자바의 주요 메모리 2개의 유형에 따른 활용 내용을 기술하세요.
//		 stack과 heap
		
//		[1단계:개념] 2. 배열의 구성요소를 예제를 통해서 기술하세요
//		ex) 배열을 활용하여 1~3을 출력하고 총 배열의 갯수를 입력하세요.
//		int[] EX = new int[3]; // 구성요소로는 기본데이터유형, 문자열, 사용자정의 클래스가 있다.
//		EX[0]=1;// index값을 할당 할수있다.
//		EX[1]=2;// 0부터 시작
//		EX[2]=3;
//		System.out.println("출력값1:"+EX[0]);
//		System.out.println("출력값2:"+EX[1]);
//		System.out.println("출력값3:"+EX[2]);
//		System.out.println("총 배열의 갯수:"+EX.length); // 배열의 전체크기를 가져온다.
		
//		[1단계:개념] 3. 배열의 선언, 할당, 사용 형식을 여러가지 데이터 유형에 따라 구분하여 출력하세요.
//		int[] EX1 = new int[1]; //정수형(int) 선언
//		double EX2[] = new double[1];//실수형 선언
//		String EX3[] = new String[1];//문자열형 선언
//		long EX4[] = new long[1];//정수형(long) 선언
//		EX1[0] = 1; //할당
//		EX2[0] = 1.1; //할당
//		EX3[0] = "아메리카노"; //할당
//		EX4[0] = 1; //할당
//		System.out.println("정수형(int):"+EX1[0]);
//		System.out.println("실수형:"+EX2[0]);
//		System.out.println("문자열형:"+EX3[0]);
//		System.out.println("정수형(long):"+EX4[0]);
		
//		[1단계:개념] 4. 배열의 전체 데이터를 처리할 때 for문을 사용한다. 배열의 속성에 따라서 어떻게 활용되는지 예제를 통해 기술하세요.
//		ex) 금번 교육과정의 오늘까지의 일수를 세로로 나열하세요.
//		int[] days = new int[6];
//		days[0] = 1;
//		days[1] = 2;
//		days[2] = 3;
//		days[3] = 4;
//		days[4] = 5;
//		days[5] = 6;
//		System.out.println("쌍용교육센터의 수강일");
//		for(int idx=0;idx < days.length;idx++) {
//			System.out.println(days[idx]+"일차");		
//		}
		
//		[1단계:코드] 5. 배열로 점수를 3개를 초기화하여, 
//		반복문과 Scanner를 통해서 데이터를 입력되게 하고, 총계과 평균을 출력하세요.
//		int point[] = new int[3];
//		int totP = 0;
//		Scanner sc = new Scanner(System.in);
//		for(int idx=0;idx<point.length;idx++) {
//			System.out.print("점수를 입력하세요(3번):");
//			int pointInput = sc.nextInt();
//			totP+=pointInput;
//		}
//		System.out.println("총계:"+totP);
//		System.out.println("평균:"+totP/point.length);
		
//		[1단계:코드] 6. 배열 3개에 각각 학생명, 국어, 영어를 할당하여, 반복문을 통해서 출력하세요. 
//		String name[] = new String[3];
//		name[0] = "학생명";
//		name[1] = "국어";
//		name[2] = "영어";
//		for(int idx=0;idx<name.length;idx++) {
//			System.out.println(name[idx]);
//		}
		
//		[1단계:코드] 7. 배열로 가위,바위,보라고 선언한 후, 두 친구가 index 0~2 
//		사이에 임의로 호출하여, 임의의 가위/바위/보를 출력하게 하세요  
//		String game[] = new String[3];
//		game[0] = "가위";
//		game[1] = "바위";
//		game[2] = "보";
//		String fr1 = game[(int)(Math.random()*3)];
//		String fr2 = game[(int)(Math.random()*3)];
//		System.out.println("임의의 가위바위보!");
//		System.out.println("친구1 : "+fr1);
//		System.out.println("친구2 : "+fr2);
//	}
//}
