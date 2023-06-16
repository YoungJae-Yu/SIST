package javaexp.y01_review;

import java.util.Scanner;

public class A06 {

	public static void main(String[] args) {
	       String id = "himan";
	        String pw = "abcd1234";
	        
	        int maxCnt = 5;
	        int cnt = 0;

	        Scanner sc = new Scanner(System.in);

	        while (cnt < maxCnt) {
	            try {
	                System.out.print("아이디 입력: ");
	                String userId = sc.nextLine();

	                System.out.print("비밀번호 입력: ");
	                String userPw = sc.nextLine();

	                if (userId.equals(id) && userPw.equals(pw)) {
	                    System.out.println("로그인 성공!");
	                    break;
	                } else {
	                   cnt++;
	                    System.out.println("아이디 또는 비밀번호를 확인해주세요.");
	                    System.out.println("남은 시도 횟수: " + (maxCnt - cnt));
	                }
	            } catch (Exception e) {
	                System.out.println("올바른 형식으로 입력해주세요.");
	            }
	        }

	        if (cnt == maxCnt) {
	            System.out.println("로그인 시도 횟수 초과. 계정이 비활성화 되었습니다.");
	        }
	}
}