package backWeb.a01_dao;
// backWeb.a01_dao.A05_MemberDao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backWeb.z01_vo.Member;


public class A05_MemberDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 로그인 처리 메서드 정의
	public Member login(String id, String pass) {
		Member mem = null;
		String sql = "SELECT * FROM member02\r\n"
				+ "WHERE id=? AND pass = ?";
		// 1.연결
		try {
			con = DB.con();
			//2.대화
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			//3.결과
			rs = pstmt.executeQuery();
			//4.(ResultSet ==> VO) ? 단일/여러개 if/while
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
			
			
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		
		return mem;
	}
	public void insertMember(Member ins) {
		String sql="insert into member02 values(?,?,?,?,?,sysdate)";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ins.getId());
			pstmt.setString(2, ins.getPass());
			pstmt.setString(3, ins.getName());
			pstmt.setInt(4, ins.getPoint());
			pstmt.setString(5, ins.getAuth());
			int isInsert = pstmt.executeUpdate();
			if(isInsert == 1) {
				con.commit();//입력시 확정
				System.out.println("등록성공");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
			try {
				con.rollback();// 원복처리
			} catch (SQLException e1) {
				System.out.println("롤백예외:"+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
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

	public static void main(String[] args) {
		A05_MemberDao dao = new A05_MemberDao();
		dao.insertMember(new Member("higirl","8888","홍리나",1000,"관리자"));
//		Scanner sc = new Scanner(System.in);
//		System.out.println("#로그인#");
//		while(true) {
//			System.out.print("아아디:");
//			String id = sc.nextLine();
//			System.out.print("패스워드:");
//			String pass = sc.nextLine();
//			Member mem = dao.login(id, pass);
//			if(mem!=null) {
//				System.out.println("로그인 성공!");
//				System.out.println(mem.getName()+"님 환영합니다.");
//				break;
//			}else {
//				System.out.println("로그인 실패");
//				System.out.println(id+"는 인증계정이 아닙니다.");
//				System.out.println("계속 하시겠습니까?(Y/N)");
//				String isYN = sc.nextLine();
//				if(!isYN.equals("Y")) {
//					break;
//				}
//			}
//		}
//		System.out.println("로그인 프로그램 종료!");
	}
	
}









	