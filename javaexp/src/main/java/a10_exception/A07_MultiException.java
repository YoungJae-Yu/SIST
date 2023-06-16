package javaexp.a10_exception;

public class A07_MultiException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 다중 예외 처리
		//
		String name = "홍";
		try {
			System.out.println(name.toString());
			System.out.println(args[0]);
			System.out.println(name.charAt(5));
			System.out.println(1/0);
		}catch(NullPointerException e) {
			System.out.println("데이터 입력 예외:"+e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열범위 초과 예외"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타 예외"+e.getMessage());
		}finally {
			System.out.println("예외 상관없이 처리할 코드 블럭");
		}
		System.out.println("프로그램 종료");
	}
	/*
	A08_MultiException
		NumberFormatException	Integer.parseInt("이십오")
		ArithMethicException	1/0
		Exception				args[0]
	위와같은 예외 처리를 다중으로 처리하고, 최종적으로 finally까지 처리하여
	예외를 계층적으로 순차별로 처리하세요..
	 */
}
