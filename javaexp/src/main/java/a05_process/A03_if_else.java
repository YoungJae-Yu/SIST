package javaexp.a05_process;

import java.util.Scanner;

public class A03_if_else {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# if else 구문
		1. 특정 조건이 true/false에 분기하여 처하는 경우를 말한다.
		2. 기본형식
			if(조건문){
				조건문이 true일 때, 처리할 구문
			}else{
				조건문이 false일 때, 처리할 구문
			}
			ex) 
			if(iNum == 3){
				System.out.println("정답입니다!!");
			}else{
				System.out.println("오답입니다!!");
			}
		*/
		/*
		System.out.print("3 + 4 = ? 정답을 입력하세요:");
		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		if(inputNum == 7) { // 입력한 값이 7일 경우..
			System.out.println("정답입니다.");
		}else {	// 그외일 경우
			System.out.println("오답입니다.");
		}
		*/
		// 1~9 임의값 설정
//		int ranNum1 = (int)(Math.random()*9+1);
//		int ranNum2 = (int)(Math.random()*9+1);
//		int corNum = ranNum1 + ranNum2; // 임의값의 합산값
//		System.out.print(ranNum1+" + "+ranNum2+" = ? 정답을 입력하세요:");
//		Scanner sc = new Scanner(System.in);
//		int inputNum = sc.nextInt();
//		if(inputNum == corNum) { // 입력한 값이 정답인 경우
//			System.out.println("정답입니다.");
//		}else {	// 그외일 경우
//			System.out.println("오답입니다.");
//		}	
		
//		ex) 구구단 게임 컴퓨터가 낸 구구단 문제의 정답을 입력하여
//			정답/오답 처리로 하게 하세요..
//			grade(2~9, 경우의수?, 시작수?)
//			cnt(1~9, 경우의수?, 시작수?)
		
		int grade = (int)(Math.random()*8+2);
		int cnt = (int)(Math.random()*9+1);
		int corNum = grade * cnt;
		System.out.println(grade+" * "+cnt+"? 정답을 입력하세요:");
		Scanner sc = new Scanner(System.in);
		int inputNum = Integer.parseInt(sc.nextLine());
		if(inputNum == corNum) {
			System.out.println("정답입니다!!");
		}else {
			System.out.println("오답입니다!!");
	
		}
	
	}
	
}
