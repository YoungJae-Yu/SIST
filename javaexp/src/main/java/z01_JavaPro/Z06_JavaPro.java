package javaexp.z01_JavaPro;

public class Z06_JavaPro {

	public static void main(String[] args) {

//		04/06
//		[1단계:개념] 7. 2차원배열의 선언과 할당에 대하여 기본 코드로 설명하세요.
//		int[][] array1; //데이터유형 [] 배열명; 형태로 선언한다.
//		array1 = new int[0][0]; // 배열명 = new 데이터유형[상위차원크기][하위차원크기]; 형태로 할당
		
//		[1단계:코드] 8. 2차원으로 회원아이디, 회원명, 회원등급을 설정하여 회원2명을 할당하여 처리할려고 한다.		
//		           초기화하고, 데이터를 입력 후, 반복문을 통해서 출력하세요.
		
//		String [][] user = new String[2][3];
//		user [0][0] = "Apple"; 
//		user [0][1] = "김상과"; 
//		user [0][2] = "A"; 
//		user [1][0] = "Banana"; 
//		user [1][1] = "박나나"; 
//		user [1][2] = "B"; 
//		String []subj = {"아이디","회원명","회원등급"};
//		for(int idx=0;idx<user.length;idx++) {
//			for(int jdx=0;jdx<user[idx].length;jdx++) {
//				System.out.print(idx+1+"번째 회원의 ");
//				System.out.print(subj[jdx]+" : ");
//				System.out.println(user[idx][jdx]);
//			}
//		}
		
//		[1단계:코드] 9. 반에 학생이 30명, 5개반에 임의의 점수(0~100)을 할당하고 점수를 아래와 같이 출력하세요
//		           1반 1번 @@ 점...

//		int [][] sdt = new int[5][30];
//		for(int idx=0;idx<sdt.length;idx++) {
//			for(int jdx=0;jdx<sdt[idx].length;jdx++) {
//				sdt[idx][jdx] = (int)(Math.random()*101);
//				System.out.print(idx+1+"반\t"+(jdx+1)+"번\t");
//				System.out.println(sdt[idx][jdx]+"점");
//			}	
//		}	
		
//		[1단계:개념] 10. 객체의 데이터 처리 선언, 초기화, 객체 생성,  
//		호출의 각 단계별로 메모리할당 과정과 의미를 문자열과 숫자형 배열의 예로 설명하세요.
		
		//선언
		int[] arry;
		
		//초기화1
		arry=null;
		
		//초기화2(초기값 0으로 할당)
		arry = new int[3];
		
		//초기화2(초기화 데이터 할당)
		arry = new int[] {1000,2000,3000};
		
		//선언, 데이터할당 초기화
		int[] arry2 = {2000,3000,4000};
		
		//사용(호출/할당)
		System.out.println(arry[0]);
		arry[0] = 5000;
		
		//문자열
		//선언
		String str01;
		
		//초기화1
		str01=null;
		
		//초기화2(할당)
		str01 = "hello";
		String str02 = new String("hello");
	
	      // 사용(호출/재할당)
	      System.out.println(str01);
	      str01 = "Good day!";
	      
	      // 문자열의 경우 문자열자체에 대한 비교시 equals()사용
	      System.out.println(str01.equals(str02));
		
		
//		int [] arry1 = {0,1,2}; // 숫자형 선언과 데이터 할당을 동시에 진행하고,
//		String [] arry2 = {"가","나","다"};// heap영역에 객체 생성,
//		
//		for(int idx=0;idx<arry1.length;idx++) {//for문의 index를 활용하여 호출.
//			for(int jdx=0;jdx<arry1.length;idx++) {
//				System.out.println(arry1[idx]+":"+arry2[jdx]);
//			}
//		}
	}
}
