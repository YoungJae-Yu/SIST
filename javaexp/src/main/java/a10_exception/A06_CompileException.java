package javaexp.a10_exception;

import java.io.IOException;
import java.io.InputStream;

public class A06_CompileException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 컴파일 예외 처리 : 반드시 처리해야 컴파일됨(기계어로된 파일 생성)
		try {
			System.out.println("컴파일시 예외 발생!!");
			Class.forName("aa.bb");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("예외 내용:"+e.getMessage());
			System.out.println("예외가 처리되는 경로 trace");
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
//		ex) 아래 코드를 이용해서, 컴파일 예외를 처리하세요..
		InputStream is = System.in;
		// 컴파일 예외는
		// 1. throws를 통해서 예외를 메서드 옆에서 위임하여 처리하거나
		// 2. try{}catch 구문으로 예외를 바로 처리하는 코드가 자동으로 생성된다.
		try {
			is.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("데이터 입력");
			System.out.println(is.read());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}
	}
}
