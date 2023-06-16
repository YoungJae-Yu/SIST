package backWeb.a01_dao;

import java.sql.*;



public class A02_EmpDao {
	//1. 필드선언(핵심 내장 객체)
	// 	1) 연결 - 서버연결
	private Connection con;
	//  2) 대화 - 명령/입력  
	private Statement stmt;
	//  3) 결과 - 데이터를 가져오는 것
	private ResultSet rs;
	
	//2. 기능 메서드 선언..
	//	1) 사원 전체 정보 출력..
	public void empListAll() {
			// # 전체적으로 예외 처리.
			// 연결
			try {
				con = DB.con();
				// 대화할 내용
				String sql = "SELECT * FROM emp02";
				// 대화할 수 있는 객체는 연결(con)에 의해 생성
				stmt = con.createStatement();
				// 결과(ResultSet)
				rs = stmt.executeQuery(sql);
				int row=1;
				while(rs.next()) { // 행단위로 이동 다음 행이 없을 떄까지
					System.out.print("행번호:"+row++);
					System.out.print("\t"+rs.getInt("empno"));
					System.out.print("\t"+rs.getString("ename"));
					System.out.print("\t"+rs.getInt("mgr"));
					System.out.println("\t"+rs.getDouble("sal"));
					// ex) 사원명과 관리자번호, 급여  출력해보세요.
					
				}
				/*
				rs.next() : 반복을 통해서 행단위로 커서를 위치시키는
					다음 행이 데이터가 없으면 false 있으면 true
				while(rs.next()){ // 다음 행이 없을 때까지 반복
					System.out.println(cnt++)
				}			
				rs.get데이터유형("컬럼명")
				 * 
				 * */
				// 자원해제				
			} catch (SQLException e) {
				System.out.println("DB 처리 예외:"+e.getMessage());
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A02_EmpDao dao = new A02_EmpDao();
		dao.empListAll();
	}

}
