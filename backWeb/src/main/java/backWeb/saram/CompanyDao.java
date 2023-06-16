package backWeb.saram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import backWeb.saram_vo.Company;

public class CompanyDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<Company> getCompany(){
		List<Company> clist = new ArrayList<Company>();
		String sql = "SELECT comname, comtype\r\n"
				+ "FROM company";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				clist.add(new Company(
						rs.getString("comName"),
						rs.getString("comType")
						));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return clist;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
