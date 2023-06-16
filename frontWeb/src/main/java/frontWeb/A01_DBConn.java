package frontWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A01_DBConn {
	private static Connection con;
	public static void setConn() throws SQLException {
		// 1. jdbc 드라이버를 메모리 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스 에러 발생");
			System.out.println(e.getMessage());
			
		}
		// 2. 메모리 로딩된 내용을 연결객체로 연결처리..
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(info,"scott","tiger");
		System.out.println("접속성공");
		
	}	
	
	// DB.java라는 클래스로 연동처리하게 설정하세요..
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			setConn();
		}catch(SQLException e) {
			System.out.println("SQL예외 발생.."
			+e.getMessage());
		}
	}

}
