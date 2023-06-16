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
import backWeb.saram_vo.JobPosting;
import backWeb.saram_vo.Match;
import backWeb.saram_vo.SaramSelect;

public class SaramInDao {
   private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;




   public List<SaramSelect> getSaramSelect() {
       List<SaramSelect> ilist = new ArrayList<SaramSelect>();
       String sql = "SELECT * FROM info01";
       System.out.println("# DB접속 #");
       try {
           con = DB.con();
           pstmt = con.prepareStatement(sql); 
           rs = pstmt.executeQuery();
           while (rs.next()) {
              ilist.add(new SaramSelect(
                       rs.getString("iloc"),
                       rs.getString("ijob")
               ));
           }
       } catch (SQLException e) {
           System.out.println("DB 관련 오류: " + e.getMessage());
       } catch (Exception e) {
           System.out.println("일반 오류: " + e.getMessage());
       } finally {
           DB.close(rs, pstmt, con);
       }
       return ilist;
   }
   
   public List<JobPosting> getPostList(Map<String, String> sch) {
        List<JobPosting> plist = new ArrayList<>();
        String sql = "SELECT * FROM jobPosting01 \r\n"
        		+ "WHERE placeOfWork = ? \r\n"
        		+ "AND fieldName = ? ";
        try {
            con = DB.con();
            pstmt = con.prepareStatement(sql); 
            pstmt.setString(1,sch.get("placeOfWork"));
            pstmt.setString(2,sch.get("fieldName"));
            rs = pstmt.executeQuery();
            while (rs.next()) {
               plist.add(new JobPosting(
                        rs.getString("comName"),
                        rs.getString("phoneNum"),
                        rs.getString("placeOfWork"),
                        rs.getString("fieldName"),
                        rs.getString("taskInCharge"),
                        rs.getString("education"),
                        rs.getInt("salary"),
                        rs.getDate("recruitmentDate"),
                        rs.getString("receptionMethod")
                ));
            }
        } catch (SQLException e) {
            System.out.println("DB 관련 오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("일반 오류: " + e.getMessage());
        } finally {
            DB.close(rs, pstmt, con);
        }
        return plist;
    }
   // 이력서테이블, 채용공고테이블 join 메서드
	public List<Match> getMatch(Map<String,String> sch1){
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
			pstmt.setString(1, sch1.get("placeOfWork"));
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

	public static void main(String[] args) {
	
    	SaramInDao dao = new SaramInDao();
    	Map<String, String> sch = new HashMap<String, String>();
    	sch.put("placeOfWork", "경기");
    	for(Match m:dao.getMatch(sch)) {
    		System.out.print(m.getPlaceOfWork()+"\t");
    		System.out.print(m.getComName()+"\t");
    		System.out.print(m.getMemCareer()+"\t");
    		System.out.print(m.getHopeWorktype()+"\t");
    		System.out.print(m.getFieldName()+"\t");
    		System.out.print(m.getSalary()+"\t");
    		System.out.print(m.getReceptionMethod()+"\n");
    	}
	}
}