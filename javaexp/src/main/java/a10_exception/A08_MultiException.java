package javaexp.a10_exception;

public class A08_MultiException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		A08_MultiException
			NumberFormatException	Integer.parseInt("이십오")
			ArithmeticException		1/0
			Exception				args[0]
		위와같은 예외 처리를 다중으로 처리하고, 최종적으로 finally까지 처리하여
		예외를 계층적으로 순차별로 처리하세요..
		*/
		String name = null;
		try {
			System.out.println(Integer.parseInt("이십오"));
			System.out.println(1/0);
			System.out.println(args[0]);			
		}catch(NumberFormatException e) {
			System.out.println("데이터 입력 예외:"+e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println("수학 처리 예외:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타 예외:"+e.getMessage());
		}finally {
			System.out.println("예외 상관없이 처리할 코드 블럭");
		}
	}
}
