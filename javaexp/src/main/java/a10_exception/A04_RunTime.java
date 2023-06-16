package javaexp.a10_exception;

public class A04_RunTime {

	public static void main(String[] args) {
		// ex) A04_RunTime args에 회원아이디와 패스워드를 입력받아
		// 처리되는 프로그램으로 입력이 안될때, 예외 처리하는 내용을 하고.
		// 예외 처리 내용으로 아이디와 패스워드를 입력하세요 라고 표시되게 하세요.
		System.out.println("프로그램 시작");
		try {
			System.out.println("회원아이디와 패스워드를 입력하세요.");
			String id = args[0];
			String pwd = args[1];
			System.out.println("입력한 아이디:"+id);
			System.out.println("입력한 패스워드:"+pwd);
		// 에러가 발생시 복사한 예외를 catch에 입력한다.
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("아이디와 패스워드를 입력하세요.");
		}
		System.out.println("프로그램 종료");
	}
}
