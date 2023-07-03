package backWeb.a01_dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB연동 공통 클래스..
public class DB {
// DB.con();
	public static Connection con() throws SQLException {
		Connection con =null;
		// 1. jdbc메모리 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 예외:"+e.getMessage());
		}
		// 2. 연결정보 처리
		String info = "jdbc:oracle:thin:@localhost:1521:xe";
		// DriverManager : jdbc드라이버의 클래스 중에서
		// 특정 한객체가 메모리에 로딩된 상황
		// 접속정보를 매개변수로 계정과 비번을 받아서
		// 특정 서버에 접속하고, 그 접속한 객체를 호출하는 곳에
		// 리턴 처리..
		con = DriverManager.getConnection(info,"scott","tiger");
		System.out.println("DB 접속 성공");
		return con;
	}
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		// rs.close(), stmt.close(), con.close()
		// api에 지원하는 안정적인 자원해제 방법.
		
		// rs.close()에 의하거나
		// 다른 예외로 예외가 나왔을 때는
		// 아래에 내용을 강제 자원해제를 한다.
		
		// 해제 전에 예외가 발생한 것을 처리.
		if(rs!=null) rs = null;// 강제로 null처리..
		if(stmt!=null) stmt = null;// 강제로 null처리..
		if(con!=null) con = null;// 강제로 null처리..
		/*
		try {
			if(rs!=null)
				rs = null;
			// 위 rs.close()가 없이
			// close()가 작동 문제로 예외가 발생했을 때는
			// rs의 자원은 영원히 예외 발생하지 않으면..
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			if(stmt!=null)
				stmt.close();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			if(con!=null)
				con.close();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		*/
	}
}
