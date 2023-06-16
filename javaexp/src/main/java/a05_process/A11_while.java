package javaexp.a05_process;

import java.util.Scanner;

public class A11_while {

	public static void main(String[] args) {
		/*
		# while문 : 조건에 따라 반복을 계속할지 결정하는
			경우에 활용되는 반복문
		1. 기본형식
			while(반복할조건){
				반복할 조건이 true일 때 처리할 내용
			}
			무한 반복안에서 break
			while(true) { 
				처리할 내용
				if(반복문을 벗아날 조건) {
					break;
				}
			}
			
		2. 처리예
			1) 메뉴를 입력받아서, Q를 누를 때 까지 처리
			2) 구매한 과일의 가격을 입력받아서 -1을 입력 할 때 까지 처리
		*/
		
//		int cnt=1;
//		while(cnt<=10) {
//			System.out.println((cnt++)+"번째 반복");
//		}
//		
//		Scanner sc = new Scanner(System.in);
//		String fruit = "";
//		String flist = "";
//		while(!fruit.equals("Q")) {
//			System.out.print("구매할 과일명을 입력(종료시Q):");
//			fruit = sc.nextLine();
//			System.out.println("입력한 내용:"+fruit);
//			if(!fruit.equals("Q")) {
//				flist+=fruit+" ";
//			}
//		}		
//		System.out.println("구매한 과일 리스트:"+flist);
//		System.out.println("종료!!");
//		
//		Scanner sc = new Scanner(System.in);
//		String flist = "";
//		while(true) {
//			System.out.print("구매할 과일명을 입력(종료시Q):");
//			String fruit = sc.nextLine();
//			System.out.println("입력한 내용:"+fruit);
//			if(fruit.equals("Q")) {
//				break;
//			}else {
//				flist+=fruit+" ";
//			}
//		}		
//		System.out.println("구매한 과일 리스트:"+flist);
//		System.out.println("종료!!");
		
//		ex1) 10~20까지 while문을 통해서 출력하세요	
		int num=10;
		while(num<=20) {
			System.out.println(num++);
			}
		
//		ex2) 구매할 물건의 가격입력, 종료시 -1
//			 총비용:@@
		Scanner sc = new Scanner(System.in);
		System.out.print("구매할 물건의 가격 입력(-1입력종료):");
		int totPrise = 0;
		while(true) {
			int price = sc.nextInt();
			if(price==-1) {
				System.out.println("종료!");
				break;
			}else {
				totPrise += price;
				totPrise ++;
			}
		}
		System.out.println("총 갯수:"+totPrise);
		System.out.println("총 비용:"+totPrise);
	}
}
