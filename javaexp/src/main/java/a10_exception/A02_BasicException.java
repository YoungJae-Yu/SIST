package javaexp.a10_exception;

public class A02_BasicException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// e.XXX : 여러 기능메서드를 통해서 예외에 대한 상세 내용을 처리한다.
		// ex) A02_BasicException.java를 만들고,
		// 	   try{}catch블럭을 만들고, 각 라인별로 표시하고,
		//	   특정 라인에 sysout(1/0); 코드를 넣어 에러 발생하게 하고
		//     추리 내용을 수행 하게 하세요..
		//     2단계 try{}안에 1~100 for문으로 처리하여 조건으로 50일 때
		//     1/0코드가 수행되게 처리해보세요..
		try { 
			System.out.println("#코드 블럭#");
			int i = 0;
			for(i=0;i<=100;i++) {
				if(i==50) {
					System.out.println(1/0);
				}
				System.out.println(i);
			}
		}catch(Exception e) {
			System.out.println("#예외 처리 블럭#");
			System.out.println(e.getMessage());
		}		
		System.out.println("#예외 처리 후 블럭#");
	}

}
