package backendWeb.a01_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    public static Connection con() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "scott";
            String password = "tiger";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("DB 접속 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("클래스 예외: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("DB 접속 실패: " + e.getMessage());
            throw e; // 예외를 상위로 다시 던져서 호출자에게 예외를 알리도록 합니다.
        }
        return conn;
    }
    
    public static void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                System.out.println("롤백 예외: " + e.getMessage());
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
