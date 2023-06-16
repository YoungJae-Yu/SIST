package javaexp.z01_JavaPro;

import java.util.Scanner;

public class Z17_0426 {
//	[1단계:확인] 6. 예외 위임을 코드를 기본 예제와 함께 설명하세요.
//	각 기능메서드별로 예외를 처리할 때, 예외 처리를 해당 메서드를
//	호출하는 곳에서 공통/한꺼번에 처리하고자 할 때, 활용한다.
	static void c1() throws ClassNotFoundException {
		Class.forName("ll.ll");
	}
//  [1단계:조원] 1. 예외처리에 대한 이론과 실습(조원들과 아래 내용에 대한 이야기를 수업 내용을 보면서 나누세요)
//  1) 예외 처리를 왜 하는지 알고 있나요?
	/*
	프로그램 실행 도중에 발생하는 에러는 프로그램의 신뢰성에 영향을 미치기 때문에 이를 효과적으로 대응하기 위해 에러처리를 한다.
	*/
//  2) 예외 처리를 하는 기본 단계별 구조를 설명할 수 있고, 코드할 수 있는지?
/*
    1단계 기본 형식 
          try{}catch(Exception e){}
    2단계 계층적 처리 
          try{}catch(Exception e){}catch(Exception e){}..finally{}
    3단계 예외의 위임 void 메소드() 
          throws 예외1, 예외2{}, try-catch
    4단계 사용자 정의 예외 처리
        class 사용자정의예외클래스 extends Exception{ super("예외메시지"); }
*/
//  3) args값이 입력하지 않을 때, 처리되는 메서드를 선언하고, 예외를 위임하세요.
	void call01() throws ArrayIndexOutOfBoundsException{
		System.out.println("# args값을 입력하지 않았을 때 처리되는 예외 #");
	}
//  4) 아이디 입력시 8자미만 이거나 16자이상시 사용자 정의 예외를 발생하게 처리하세요	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("아이디를 입력하세요(8자리 이상 ~16자리 미만): ");
	      try {
	            String id = sc.nextLine();
	            if(id.length() < 8 || id.length() >=16) {
	               throw new IdException();
	         }
	      }catch(IdException e) {
	         System.out.println(e.getMessage());
	      }finally {
	         System.out.println("// 예외처리와 관계없이 실행되는 구문 //");
	      }
	      System.out.println("# 프로그램 종료 #");

	      System.out.println();
//		6번 예제
//		위임을 했기에 호출하는 곳에 다시 예외를 처리해야 한다.
		try {
			c1(); 
		} catch (ClassNotFoundException e) {
			//위임된 예외를 처리
			System.out.println("예외 내용(클래스없음):"+e.getMessage());
		}
		
//		7번 예제 출력
		try {
			for(int cnt=1;cnt<=10;cnt++) {
				if(cnt%2==0) {
					System.out.println(cnt);
					throw new exException();
				}
			}
		}catch(exException e) {
			System.out.println("예외 내용:"+e.getMessage());
		}
		/*
		# 예외 처리 반복문
		1. 반복문 안에서 처리
			for()
				if()
					try{
					}catch(){}
			해당 조건이 나왔을 때, 예외 catch블럭이 수행되고, 다시,
			다음 반복 step를 수행 처리한다.
		
		2. 반복문 포함 밖에 처리
			try{
				for()
			}
		 */
		
		
	}

}
// 4) 아이디 입력시 8자미만 이거나 16자이상시 사용자 정의 예외를 발생하게 처리하세요
class IdException extends Exception{
	   IdException() {
	      super("아이디를 8자 이상, 16자 미만으로 입력해주세요");
	   }
	   @Override
	   public String getMessage() {
	      String eMsg = super.getMessage();
	      return ": "+ eMsg;
	   }
	   
}

//	[1단계:확인] 7. 1~10까지 출력할 때, 짝수인 경우에 사용자 정의 예외가 처리되게 하세요.
class exException extends Exception{
	exException(){
		super("짝수입니다(예외)");
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
}