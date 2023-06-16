package javaexp.a13_io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class A06_WriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		# 파일 내용 입력 처리
		1. 여러가지 데이터들을 File 내용으로 저장할 수 있다.
		2. 프로그램에서 입력되는 내용을 File에 쓰는 작업을 처리해보자.
		3. 사용할 객체
			1) 상위 객체 : Writer
			2) 하위 파일쓰기객체 : FileWriter("경로명")
			3) 쓰기 처리 메서드
				writer("문자열");
				flush() : 임시 메모리 해제
				close() : Stream객체 해제
				 
		 * */
		String path = "C:\\Users\\user\\git\\-\\javaexp\\src\\javaexp\\a13_io\\z02_data\\";
		/*
		# 파일내 쓰기 기능 처리
		1. 기존 내용을 삭제하고 데이터 사용하기
			new FileWriter("경로명\\파일명");
			.write("저장할 문자열")
			.append("위 write처리 이후에 더 추가할 내용 처리")
		2. 기존 내용을 그대로 두고 데이터 입력하기
			new FileWriter("경로명\\파일명",true);
			.append("추가할 문자열");
			
			
			
			
		*/
		Writer fout=null;
		try {
			fout = new FileWriter(path+"z02_data.txt");
			Scanner sc = new Scanner(System.in);
			System.out.println("파일에 쓸 내용을 입력하세요!!");
			String data = sc.nextLine();
			fout.write(data);
			fout.append("\n"+data); // 누적 저장(기존 + 추가 내용)
			fout.flush();// 버퍼에 있는 임시 메모리를 비워주기
			System.out.println("입력완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fout.close();// 자원해제
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
