package backWeb.saram;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backWeb.a01_dao.DB;
import backWeb.saram_vo.Match;
import backWeb.saram_vo.Member;

public class SaramMemDao{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
    // Member 회원 정보를 추가하는 메서드
    public void insertMember(Member ins){
        String sql = "INSERT INTO MEMBER01 VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DB.con();  // 데이터베이스 연결을 위한 getConnection() 메서드 호출      
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ins.getMemberid());
            pstmt.setString(2, ins.getMemName());
            pstmt.setInt(3, ins.getMemBirth());
            pstmt.setString(4, ins.getMemSex());
            pstmt.setInt(5, ins.getMemPhone());
            pstmt.setString(6, ins.getMemEmail());
            pstmt.setString(7, ins.getMemAddr());
            pstmt.setString(8, ins.getEmpNoticeld());
            
            int isInsert = pstmt.executeUpdate();
            if(isInsert==1) {
            con.commit(); // 입력시 확정
            System.out.println("회원 등록 성공!!");
            }
            pstmt.close();
			con.close();
      } catch (SQLException e) {
         System.out.println("SQL예외:"+e.getMessage());
        try {
			con.rollback();// 원복처리
		}catch (SQLException e1) {
			System.out.println("롤백예외:"+e1.getMessage());
		}
      } catch(Exception e) {
         System.out.println("일반:"+e.getMessage());
      }finally {
         DB.close(rs, pstmt, con);
      }
   }
    
    // Member 회원 정보를 조회하는 메서드
    public Member selectMember(int memberid) {
        Member member = null;
        String sql = "SELECT * FROM MEMBER01 WHERE MEMBERID = ?";
        try {
            con = DB.con();  // 데이터베이스 연결을 위한 getConnection() 메서드 호출
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, memberid);
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                member = new Member(
                    rs.getInt("memberld"),
                    rs.getString("memName"),
                    rs.getInt("memBirth"),
                    rs.getString("memSex"),
                    rs.getInt("memPhone"),
                    rs.getString("memEmail"),
                    rs.getString("memAddr"),
                    rs.getString("empNoticeld")
                );
            }
            
        } catch (SQLException e) {
            System.out.println("SQL예외:"+e.getMessage());
	           try {
	   			con.rollback();// 원복처리
	   		}catch (SQLException e1) {
	   			System.out.println("롤백예외:"+e1.getMessage());
	   		}
         } catch(Exception e) {
            System.out.println("일반:"+e.getMessage());
         }finally {
            DB.close(rs, pstmt, con);
         }
        return member;
      }
    
    
    public List<Member> getMemInfo(Map<String,String> sch){
        List<Member> memlist = new ArrayList<Member>();
        List<Member> m = new ArrayList<>();
        String sql = "SELECT * FROM MEMBER01 WHERE MEMBERID = ?";
        try {
            con = DB.con();  // 데이터베이스 연결을 위한 getConnection() 메서드 호출
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sch.get("memberid"));
            rs = pstmt.executeQuery();
	        while(rs.next()) {
	           memlist.add(new Member(rs.getInt("memberid"),
	                 rs.getString("memName"),
	                 rs.getInt("memBirth"),
	                 rs.getString("memSex"),
	                 rs.getInt("memPhone"),
	                 rs.getString("memEmail"),
	                 rs.getString("memAddr"),
	                 rs.getString("empNoticeld")    
	                 ));
	        }
			rs.close();
			pstmt.close();
			con.close();
        } catch (SQLException e) {
            System.out.println("SQL예외:"+e.getMessage());
	           try {
	   			con.rollback();// 원복처리
	   		}catch (SQLException e1) {
	   			System.out.println("롤백예외:"+e1.getMessage());
	   		}
         } catch(Exception e) {
            System.out.println("일반:"+e.getMessage());
         }finally {
            DB.close(rs, pstmt, con);
         }
        return memlist;
      }
    // 이력서테이블, 채용공고테이블 join 메서드
	public List<Match> getMatch(Map<String,String> sch){
		List<Match> mlist = new ArrayList<Match>();
		String sql = "SELECT j.placeOfWork,\r\n"
				+ "       j.comName ,\r\n"
				+ "       r.memCareer,\r\n"
				+ "       r.hopeWorktype,\r\n"
				+ "       j.fieldName,\r\n"
				+ "       j.salary,\r\n"
				+ "       j.receptionMethod\r\n"
				+ "FROM resume r\r\n"
				+ "INNER JOIN jobPosting01 j ON r.resumeld = j.postId\r\n"
				+ "WHERE j.placeOfWork = ? ";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.get("placeOfWork"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mlist.add(new Match(
						rs.getString("placeOfWork"),
						rs.getString("comName"),
						rs.getString("memCareer"),
						rs.getString("hopeWorktype"),
						rs.getString("fieldName"),
						rs.getInt("salary"),
						rs.getString("receptionMethod")
						));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL예외:"+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return mlist;
	}
    // 이력서테이블, 채용공고테이블 join 메서드
//	public List<Match> getMatch(String placeOfWork){
//		List<Match> mlist = new ArrayList<Match>();
//		String sql = "SELECT j.placeOfWork AS \"지역\",\r\n"
//				+ "       j.comName AS \"회사명\",\r\n"
//				+ "       r.memCareer AS \"경력\",\r\n"
//				+ "       r.hopeWorktype AS \"계약형태\",\r\n"
//				+ "       j.fieldName AS \"모집분야\",\r\n"
//				+ "       j.salary AS \"연봉\",\r\n"
//				+ "       j.receptionMethod AS \"접수방법\"\r\n"
//				+ "FROM resume r\r\n"
//				+ "INNER JOIN jobPosting01 j ON r.resumeld = j.postId\r\n"
//				+ "WHERE j.placeOfWork = ? ";
//		try {
//			con = DB.con();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, placeOfWork);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				mlist.add(new Match(
//						rs.getString("placeOfWork"),
//						rs.getString("comName"),
//						rs.getString("memCareer"),
//						rs.getString("hopeWorktype"),
//						rs.getString("fieldName"),
//						rs.getInt("salary"),
//						rs.getString("receptionMethod")
//						));
//			}
//			rs.close();
//			pstmt.close();
//			con.close();
//		} catch (SQLException e) {
//			System.out.println("SQL예외:"+e.getMessage());
//		} catch (Exception e) {
//			System.out.println("일반예외:"+e.getMessage());
//		} finally {
//			DB.close(rs, pstmt, con);
//		}
//		return mlist;
//	}
    public static void main(String[] args) { 
//    	List<Match> mlist = new ArrayList<Match>();
//    	for(Match m:dao.getMatch("인천")) {
//    		System.out.print(m.getPlaceOfWork()+"\t");
//    		System.out.print(m.getComName()+"\t");
//    		System.out.print(m.getMemCareer()+"\t");
//    		System.out.print(m.getHopeWorktype()+"\t");
//    		System.out.print(m.getFieldName()+"\t");
//    		System.out.print(m.getSalary()+"\t");
//    		System.out.print(m.getReceptionMethod()+"\n");
//    	}
//    	List<Match> mlist = dao.getMatch(sch);
    	SaramMemDao dao = new SaramMemDao();
    	Map<String, String> sch = new HashMap<String, String>();
    	sch.put("placeOfWork", "서울");
    	for(Match m:dao.getMatch(sch)) {
    		System.out.print(m.getPlaceOfWork()+"\t");
    		System.out.print(m.getComName()+"\t");
    		System.out.print(m.getMemCareer()+"\t");
    		System.out.print(m.getHopeWorktype()+"\t");
    		System.out.print(m.getFieldName()+"\t");
    		System.out.print(m.getSalary()+"\t");
    		System.out.print(m.getReceptionMethod()+"\n");
    	}
//    	Member ins = new Member(1,"홍길동",19950101,"남",01000010002,"xxyy2@naver.com","강남로 17길","1112");
//    	Member ins = new Member(2,"김길동",19950101,"남",01000010002,"xxyy2@naver.com","강남로 17길","1112");
//    	Member ins = new Member(3,"박길동",19960101,"남",01000010003,"xxyy3@naver.com","강남로 18길","1113");
//    	Member ins = new Member(4,"최길동",19970101,"남",01000010004,"xxyy4@naver.com","강남로 19길","1114");
//    	Member ins = new Member(5,"임길동",19980101,"남",01000010005,"xxyy5@naver.com","강남로 20길","1115");
//        b.insertMember(ins);
//    	for(Employee e:dao.getEmpList(sch)) {
//			System.out.print(e.getEmployee_id()+"\t");
//			System.out.print(e.getFirst_name()+"\t");
//			System.out.print(e.getLast_name()+"\t");
//			System.out.print(e.getEmail()+"\t");
//			System.out.print(e.getPhone_number()+"\t");
//			System.out.print(e.getHire_date()+"\t");
//			System.out.print(e.getSalary()+"\t");
//			System.out.print(e.getManager_id()+"\n");
//		}
//    	Scanner sc = new Scanner(System.in);
//		System.out.print("검색할 회원번호를 입력:");
//		int enum1 = sc.nextInt();
//		b.selectMember(enum1);
//		System.out.println("사원정보");
//		System.out.println(ins.getMemberid());
//		System.out.println(ins.getMemName());
//       dao.selectMember(1);
//       SaramMemDao dao = new SaramMemDao();
//       List<SaramMem> a = new ArrayList<SaramMem>();
//       dao.getMemInfo(1);
//       for(SaramMem sm:a){
//          System.out.println(sm.getMemberld());
//       }
//
//       for (Member member : members) {
//         System.out.print("\t"+member.getMemberld());
//         System.out.print("\t"+member.getMemName());
//         System.out.print("\t"+member.getMemBirth());
//         System.out.print("\t"+member.getMemSex());
//         System.out.print("\t"+member.getMemPhone());
//         System.out.print("\t"+member.getMemEmail());
//         System.out.print("\t"+member.getMemAddr());
//         System.out.print("\n"+member.getEmpNoticeld());
//       }
//       int memberld, String memName, int memBirth, String memSex, int memPhone,
//        String memEmail, String memAddr, String empNoticeld
       
    }
}

