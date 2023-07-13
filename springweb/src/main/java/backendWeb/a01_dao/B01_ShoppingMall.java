package backendWeb.a01_dao;

import java.util.Scanner;

import backendWeb.z01_vo.Member;


public class B01_ShoppingMall {
	private A05_MemberDao dao;
	public B01_ShoppingMall() {
		dao = new A05_MemberDao();
	}
	public void loginMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("#로그인 시작!!#");
		while(true) {
			
			System.out.print("아이디를 입력:");
			String id = sc.nextLine();
			System.out.print("패스워드를 입력:");
			String pass = sc.nextLine();
			Member mem = dao.login(id, pass);
			if(mem!=null) {
				System.out.println("로그인 성공!");
				System.out.println(mem.getName()+"님 환영합니다.");
				break;
			}else {
				System.out.println("로그인 실패");
				System.out.println(id+"는 인증계정이 아닙니다.");
				System.out.print("로그인 계속 하시겠습니까?(Y/N):");
				String isYN = sc.nextLine();
				if(!isYN.equals("Y")) {
					break;
				}
			}		
		}
		System.out.println("로그인 프로그램 종료!");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B01_ShoppingMall b = new B01_ShoppingMall();
		b.loginMenu();
	}

}
