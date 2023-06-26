package project.janjan;

import java.sql.*;

public class DB {
	public static Connection con() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "scott";
            String password = "tiger";
            conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 예외 : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 접속 예외 : "+e.getMessage());
			throw e;
		}
		return conn;
	}
	
	public static void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                System.out.println("rollback 예외: " + e.getMessage());
            }
        }
    }
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("ResultSet 닫기 실패: " + e.getMessage());
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Statement 닫기 실패: " + e.getMessage());
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Connection 닫기 실패: " + e.getMessage());
            }
        }
    }
	
}
