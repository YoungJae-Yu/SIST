package javaexp.a06_memory;

public class A05_MutiArray {

	public static void main(String[] args) {
		
		/*
		# 다차원 배열
		1. 배열이 2차원 이상인 경우를 말한다.
			- 변수는 초기에 한개의 데이터를 할당
			- 1차원 배열에서는 두개 이상의 데이터를 하나의
				단위 안에 연속적으로 할당.
			- 2차원 배열에서는 위 1차원 배열이 여러개를
				처리하는 것을 말한다.
		2. 자바는 1차원 배열을 이용하여 2차원 이상의 배열을 처리한다.
			1) 선언
				- 1차원 배열
					데이터유형 [] 배열명;
				- 2차원 배열
					데이터유형 [][] 배열명;
				- 다차원 배열
					데이터유형 [][]..[] 배열명;
			2) 데이터할당
				- 1차원
					배열명 = new 데이터유형[데이터크기];
				- 2차원
					배열명 = new 데이터유형[상위차원크기][하위차원크기];
					ex)
					multi2 = new int[2][2];
					상위 차원은 2개, 그에 종속된 하위 차원도 2개.
					ex) 기차 5개의 호차 - 1차원배열
						각 호차마다 좌석 - 2차원배열..
					int [][] arry = {{1000,2000},{3000,4000}};
					데이터 사용
						배열명[상위차원배열idx][하위차원배열idx] : 호출
						arry[0][0] ==> 1000
						arry[1][0] ==> 3000
						
				- 3차원
					배열명 = new 데이터유형[상위차원크기];
					배열명 = new 데이터유형[상위차원크기];

		*/
//		숫자로 기차에 좌석이 예약되어 사용되면 1,
//		사용되고 있지 않으면 0으로 처리해보자.
		int [][] train = new int[8][60];
//		train[0] : 각 1차원의 구역안에 60개 정수
//		{{60개데이터},{},.총8개..{}}
//		train.length : 8
//		train[0].length : 60
		train[0][0] = 1;
		train[0][4] = 1;
		train[7][59] = 1;
//		train2 = {{1,0},{0,0,1},{0,0,1,1}};
//		호차를 반복
		for(int idx=0;idx<train.length;idx++) {
//			각 호차별로 좌석을 반복 : train[idx].length
			for(int jdx=0;jdx<train[idx].length;jdx++) {
				System.out.print(idx+1+"호차,");
				System.out.print(jdx+1+"좌석:");
//				배열명[호차index][좌석index]
				System.out.println(train[idx][jdx]);				
			}
		}
//		ex) 학생 3명의 국어, 영어, 수학점수를 2차원 배열에 넣고
//		초기는 모두다 0점하고, 1번째 학생의 국어점수 90
//		2번째 학생의 영어점수 80, 3번째 학생의 수학점수 80을 할당하고,
//		2중 for문을 통해서  학생의 점수를 출력하세요
		//1. 선언 및 초기화
		int [][] stdPts = new int[3][3];
//		int [][] stdPts = new int[3][5]; 학생 3명에 과목 5개
//		int [][] stdPts = new int[3][]; 학생 3명에 과목을 동적(변경)
//		int [][][] stdPts = new int[3][5][3];
//			3개반에 각 반마다 학생3명의 과목 3개. - 3차원 
//		int [][][][] stdPts = new int[3][3][5][3];
//		3개 학년에 3개반에 각 반마다 학생3명의 과목 3개. - 4차원 
		//2. 해당 학생의 점수 할당
		stdPts[0][0] = 90;
		stdPts[1][1] = 80;
		stdPts[2][2] = 80;
		String []subj = {"국어","영어","수학"};// 못풀었던 부분
		//3. 2중 for문을 통해 출력
		for(int idx=0;idx<stdPts.length;idx++) {
			for(int jdx=0;jdx<stdPts[idx].length;jdx++) {
				System.out.print(idx+1+"번째 학생의 ");
				System.out.print(subj[jdx]+"과목의 점수:");// 못풀었던 부분 
				System.out.println(stdPts[idx][jdx]);
			}
			
		}	
		
	}
	
}
