package javaexp.a10_exception;

import java.io.IOException;

import javaexp.a08_relation.a01_pck.Person;

public class A09_ThrowsException {
	/// 블럭내에서 처리할 내용을 위임하여 처리한다.
	static void call01() throws ClassNotFoundException {
		// Class.forName("패키지.클래스") 해당하는 클래스가 있으면
		// 메모리에 로딩 처리..
		System.out.println("메서드1");
		Class.forName("javaexp.a10_exception.A09_ThrowsException"); 
	}
	static void call03() throws ClassNotFoundException {
		// Class.forName("패키지.클래스") 해당하는 클래스가 있으면
		// 메모리에 로딩 처리..
		System.out.println("메서드2");
		Class.forName("javaexp.a09_inherit.A01_Basic"); 
	}	
	static void call04() throws ClassNotFoundException {
		// Class.forName("패키지.클래스") 해당하는 클래스가 있으면
		// 메모리에 로딩 처리..
		System.out.println("메서드3");
		Class.forName("aa.bb.ee"); 
	}	
	static void call02() throws IOException {
		System.out.println("# 문자를 한자 입력하세요(메서드1) #");
		System.out.println("입력한문자:"+(char)System.in.read()); 
	}
	static void call05() throws IOException {
		System.out.println("# 문자를 한자 입력하세요(메서드2) #");
		System.out.println("입력한문자:"+(char)System.in.read()); 
	}
	static void call06() throws IOException {
		System.out.println("# 문자를 한자 입력하세요(메서드3) #");
		System.out.println("입력한문자:"+(char)System.in.read()); 
	}	
	static void call07(String[] arry) throws ArrayIndexOutOfBoundsException{
		String name = arry[0];
	}
	static void call08(String str) {} //String str = "홍길동";
	static void call08(int str) {} //int str = 25;
	static void call08(Person p) {} //Person p = new Person();
	static void call08(String[] arr) {} 
	// String [] args = {"데이터"};
	// String [] arr = args;
	
	public static void main(String[] args) {
		call08("홍길동");
		call08(25);
		call08(new Person());
		call08(args);
		try {
			call07(args);
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
		// TODO Auto-generated method stub
		/*
		# 예외 위임(throws)처리
		1. 각 기능메서드별로 예외를 처리할 때, 예외 처리를 해당 메서드를
			호출하는 곳에서 공통/한꺼번에 처리하고자 할 때, 활용한다.
		2. 기능 메서드별로 예외를 반복적인 코드에 의해 처리하는 것보다,
			해당 메서드를 호출해서 사용하는 곳에서 공통적인 예외를 한꺼번에
			처리할 때, 사용된다.
		3. 기본 형식
			1) 메서드 선언
				메서드선언() throws 위임할예외1, 위임한 예외2{}
			2) 메서드 호출하는 곳
				try{
					메서드명();
				}catch(예외클래스1){
				
				}catch(예외클래스2){}	
		*/
		
		// 위임을 했기에 호출하는 곳에 다시 예외를 처리해야 한다.
		try {
			call01(); 
		} catch (ClassNotFoundException e) {
			//위임된 예외를 처리
			System.out.println("예외 내용(클래스없음):"+e.getMessage());
		}
		
		/*
		ex) call02() 메서드를 선언하고,
			System.in.read(); 
			코드를 포함하여 예외 위임을 처리하세요..
		 * */
//		try {
//			call02();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
		// 한번에 여러가지 기능 메서드에 대한 예외를 처리
		System.out.println("예외 위임 처리 시작");
		try {
			// 위임된 예외를 처리함..
			call01();
			call03();
			call04();
		} catch (ClassNotFoundException e) {
			System.out.println("# 예외 발생 #");
			System.out.println("해당 클래스가 없음:"+e.getMessage());
		}finally {
			System.out.println("예외 상관없이 처리");
		}
		System.out.println("예외 위임 처리 종료");
		// ex) call02()를 복사해서 call05(), call06()까지 기능 메서드를
		//     선언하고, 예외 위임을 아래해서 한꺼번에 처리하세요.
		System.out.println("# io예외 시작 #");
		try {
			call02();
			call05();
			call06();
		} catch (IOException e) {
			System.out.println("IO예외 발생:"+e.getMessage());
		}finally {
			System.out.println("예외 상관없이 수행");
		}
		System.out.println("# io예외 종료 #");
		// 다중 예외 처리로, ClassNotFoundException과
		// IOException을 한번에 처리할 수도 있다.
		try {
			call01();
			call02();
		} catch (ClassNotFoundException e) {
			// 클래스에 관련된 예외 처리(구체적 상세 내용 처리)
			e.printStackTrace();
		} catch (IOException e) {
			// IO에 관련된 예외
			e.printStackTrace();
		} catch (Exception e) { // 기타예외 처리
			System.out.println("기타예외:"+e.getMessage());
		}
	}
}