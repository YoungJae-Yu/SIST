package javaexp.a13_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class A08_Reader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path ="C:\\Users\\user\\git\\-\\javaexp\\src\\javaexp\\a13_io\\z04_data\\";
		Reader reader = null;
		try {
			reader = new FileReader(path);
			while(true) {
				int code = reader.read(); // 한자씩 코드값을 가져온다.
				if(code==-1) {// 더이상 데이터가 없을 때 -1리턴, 반복문 종료
					break;
				}
				System.out.print((char)code);
				
			}
			
			System.out.println();
			reader.close();
			System.out.println("읽기종료");
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 읽을 수 없네요!");
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO예외!");
			System.out.println(e.getMessage());
		}
		/*ex) z04_data.txt 좋아하는 음악 가사
		 * A08_Reader.java를 통해서 해당 가사를 출력하세요*/
	}

}
