package project.janjan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.janjan.DB;
import project.janjan.VO.Admin;
import project.janjan.VO.Alcohol;

public class AdminDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public List<Admin> getAdminList (String title, int refno){
		List<Admin> alist = new ArrayList<Admin>();
		String sql = "SELECT * \r\n"
				+ "FROM PRD_CODE\r\n"
				+ "WHERE TITLE LIKE ?\r\n"
				+ "START WITH REFNO = ?\r\n"
				+ "CONNECT BY PRIOR PRDNO=REFNO";
		
		try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1,'%'+title+"%");
	         pstmt.setInt(2, refno);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	 alist.add(new Admin(
	        			 rs.getInt(1),
	        			 rs.getString(2),
	        			 rs.getString(3),
	        			 rs.getInt(4),
	        			 rs.getInt(5)
	        	));
	         }
	         rs.close();
	         pstmt.close();
	         con.close();
	      } catch (SQLException e) {
	         System.out.println("DB예외 발생 : " + e.getMessage());
	         DB.rollback(con);
	      } catch (Exception e) {
	         System.out.println("일반 예외 처리 : " + e.getMessage());
	      } finally {
	         DB.close(rs, pstmt, con);
	      }		
		
		
		return alist;
	}
	
	public void insertSnack (Admin adm) {
		String sql = "INSERT INTO PRD_CODE VALUES (snack_seq.nextval,?,?,?,?)";
		
		try {
	        con = DB.con();
	        con.setAutoCommit(false);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, adm.getTitle());
	        pstmt.setString(2, adm.getVal());
	        pstmt.setInt(3, adm.getRefno());
	        pstmt.setInt(4, adm.getOrdno());
	        int result = pstmt.executeUpdate();
	        if (result == 1) {
	            con.commit();
	            System.out.println("등록 성공");
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 오류: " + e.getMessage());
	        DB.rollback(con);
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }	
	}

	public void insertAlcohol (Admin adm) {
		String sql = "INSERT INTO PRD_CODE VALUES (alcohol_seq.nextval,?,?,?,?)";
		
		try {
	        con = DB.con();
	        con.setAutoCommit(false);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, adm.getTitle());
	        pstmt.setString(2, adm.getVal());
	        pstmt.setInt(3, adm.getRefno());
	        pstmt.setInt(4, adm.getOrdno());
	        int result = pstmt.executeUpdate();
	        if (result == 1) {
	            con.commit();
	            System.out.println("등록 성공");
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 오류: " + e.getMessage());
	        DB.rollback(con);
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }	
	}
	public void updateAS(Admin upt) {
		String sql="UPDATE PRD_CODE \r\n"
				+ "	SET title = ?,\r\n"
				+ "		   val = ?,\r\n"
				+ "		   refno = ?,\r\n"
				+ "		   ordno = ?\r\n"
				+ "	WHERE PRDNO=?";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, upt.getTitle());
	        pstmt.setString(2, upt.getVal());
	        pstmt.setInt(3, upt.getRefno());
	        pstmt.setInt(4, upt.getOrdno());
	        pstmt.setInt(5, upt.getPrdno());
			int isInsert = pstmt.executeUpdate();
			if(isInsert == 1) {
				con.commit();//입력시 확정
				System.out.println("수정성공");
			}
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
	public void deleteAS(int no) {
		String sql="DELETE\r\n"
				+ "FROM PRD_CODE\r\n"
				+ "WHERE PRDNO = ?";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int isInsert = pstmt.executeUpdate();
			if(isInsert == 1) {
				con.commit();//입력시 확정
				System.out.println("삭제 성공");
			}
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
	
}
