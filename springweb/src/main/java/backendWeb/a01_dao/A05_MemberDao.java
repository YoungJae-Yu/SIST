package backendWeb.a01_dao;
// backendWeb.a01_dao.A05_MemberDao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backendWeb.z01_vo.Member;

// 
public class A05_MemberDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// // Product 테이블(물건명,가격,갯수) ==> 
	// 로그인 처리 메서드 정의
	public Member login(String id, String pass) {
		Member mem = null;
		String sql = "SELECT * FROM member02\r\n"
				+ "WHERE id=? AND pass = ?";
		//1. 연결(기본예외/자원해제)
		try {
			con = DB.con();
			// 2. 대화(sql 전달 후, 매개변수로 전달)
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			// 3. 결과
			rs = pstmt.executeQuery();
			// 4. (ResultSet ==> VO) ? 단일/여러개 if/while
			// Member(String id, String pass, String name, int point, String auth, Date regdate)
			if(rs.next()) {
				mem = new Member(
					rs.getString("id"),
					rs.getString("pass"),
					rs.getString("name"),
					rs.getInt("point"),
					rs.getString("auth"),
					rs.getDate("regdate")
				);
			}
			// 
		} catch (SQLException e) {
			System.out.println("DB:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return mem;
	}
	public void insertMember(Member ins) {
		int isInsert = 0;
		String sql = "INSERT INTO member02 "
				+ "values(?,?,?,?,?,sysdate)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			//insert into member20 values('higirl','8888',
			//	    '홍리나',1000,'관리자',sysdate);			
			pstmt.setString(1, ins.getId());
			pstmt.setString(2, ins.getPass());
			pstmt.setString(3, ins.getName());
			pstmt.setInt(4, ins.getPoint());
			pstmt.setString(5, ins.getAuth());
			isInsert=pstmt.executeUpdate();
			if(isInsert==1) {
				con.commit();
				System.out.println("회원 등록 성공!!");
			}
		} catch (SQLException e) {
			System.out.println("DB:"+e.getMessage());
			DB.rollback(con);
			
		} catch(Exception e) {
			System.out.println("일반:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	public void updateMember(Member ins) {
		int isInsert = 0;
		String sql = "INSERT INTO member02 "
				+ "values(?,?,?,?,?,sysdate)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			//insert into member20 values('higirl','8888',
			//	    '홍리나',1000,'관리자',sysdate);			
			pstmt.setString(1, ins.getId());
			pstmt.setString(2, ins.getPass());
			pstmt.setString(3, ins.getName());
			pstmt.setInt(4, ins.getPoint());
			pstmt.setString(5, ins.getAuth());
			isInsert=pstmt.executeUpdate();
			if(isInsert==1) {
				con.commit();
				System.out.println("회원 등록 성공!!");
			}
		} catch (SQLException e) {
			System.out.println("DB:"+e.getMessage());
			DB.rollback(con);
			
		} catch(Exception e) {
			System.out.println("일반:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		
		
	}
	
	public void deleteMember(Member ins) {
		int isInsert = 0;
		String sql = "INSERT INTO member02 "
				+ "values(?,?,?,?,?,sysdate)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			//insert into member20 values('higirl','8888',
			//	    '홍리나',1000,'관리자',sysdate);			
			pstmt.setString(1, ins.getId());
			pstmt.setString(2, ins.getPass());
			pstmt.setString(3, ins.getName());
			pstmt.setInt(4, ins.getPoint());
			pstmt.setString(5, ins.getAuth());
			isInsert=pstmt.executeUpdate();
			if(isInsert==1) {
				con.commit();
				System.out.println("회원 등록 성공!!");
			}
		} catch (SQLException e) {
			System.out.println("DB:"+e.getMessage());
			DB.rollback(con);
			
		} catch(Exception e) {
			System.out.println("일반:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		
		
	}
	// // Product 테이블(물건명,가격,갯수) ==> 
	// 로그인 처리 메서드 정의
	public List<Member> mlist() {
		List<Member> memlist = new ArrayList<Member>();
		String sql = "SELECT * FROM member02\r\n"
				+ "order by regdate desc";
		//1. 연결(기본예외/자원해제)
		try {
			con = DB.con();
			// 2. 대화(sql 전달 후, 매개변수로 전달)
			pstmt = con.prepareStatement(sql);
			// 3. 결과
			rs = pstmt.executeQuery();
			// 4. (ResultSet ==> VO) ? 단일/여러개 if/while
			// Member(String id, String pass, String name, int point, String auth, Date regdate)
			while(rs.next()) {
				memlist.add(new Member(
					rs.getString("id"),
					rs.getString("pass"),
					rs.getString("name"),
					rs.getInt("point"),
					rs.getString("auth"),
					rs.getDate("regdate")
				));
			}
			// 
		} catch (SQLException e) {
			System.out.println("DB:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return memlist;
	}
	// // Product 테이블(물건명,가격,갯수) ==> 
	// 로그인 처리 메서드 정의
	public Member checkMem(String id) {
		Member mem = null;
		String sql = "SELECT * FROM member02\r\n"
				+ "WHERE id=?";
		//1. 연결(기본예외/자원해제)
		try {
			con = DB.con();
			// 2. 대화(sql 전달 후, 매개변수로 전달)
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			// 3. 결과
			rs = pstmt.executeQuery();
			// 4. (ResultSet ==> VO) ? 단일/여러개 if/while
			// Member(String id, String pass, String name, int point, String auth, Date regdate)
			if(rs.next()) {
				mem = new Member(
					rs.getString("id"),
					rs.getString("pass"),
					rs.getString("name"),
					rs.getInt("point"),
					rs.getString("auth"),
					rs.getDate("regdate")
				);
			}
			// 
		} catch (SQLException e) {
			System.out.println("DB:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return mem;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// higirl,8888,'홍리나',2000,'관리자',
		// 등록할 객체 생성
		Member ins = new Member("higirl","8888","홍리나",2000,"관리자");
		// Member(String id, String pass, String name, int point, String auth)
		A05_MemberDao dao = new A05_MemberDao();
		dao.insertMember(ins);
		
	}

}
