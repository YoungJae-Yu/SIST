package frontWeb;

import java.sql.SQLException;
import java.util.Scanner;

import frontWeb.vo.Emp;

public class A03_DeptDao {

	// 부서정보 처리 dao
	// 1. 공통 필드 선언
	private java.sql.Connection con;
	private java.sql.Statement stmt;
	private java.sql.ResultSet rs;
	
	public void showDeptList() {
		// 2. 연결(예외처리)
		try {
			con = DB2.con();
		// 3. 대화처리
			String sql = "select * from dept";
			stmt = con.createStatement();
		// 4. 실행결과
			rs = stmt.executeQuery(sql);
			int row = 1;
			while(rs.next()) {
				System.out.print("행번호:"+row++);
				System.out.print(" "+rs.getInt("DEPTNO"));
				System.out.print(" "+rs.getString("DNAME"));
				System.out.println(" "+rs.getString("LOC"));
			}
		// 5. 자원해제
			rs.close();
			stmt.close();
			con.close();
		}catch (SQLException e) {
			System.out.println("DB처리 예외:"+e.getMessage());
		}catch (Exception e) {
			System.out.println("공통 예외:"+e.getMessage());			
		}finally {
			try {
				if(rs!=null)
					rs.close();
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
		}
	}
	public void paramEmp(String job) {
		String sql = "SELECT * "
				+ "FROM EMP02 "
				+ "WHERE job LIKE '%'||'"+job+"'||'%'";
		try {
			con = DB.con();//연결(예외처리)
			stmt = con.createStatement();//대화객체
			rs = stmt.executeQuery(sql);//결과객체
			while(rs.next()) {
				System.out.print(rs.getInt("empno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\n");
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());	
		} catch (Exception e) {
			System.out.println("일반:"+e.getMessage());	
		} finally {
			DB.close(rs, stmt, con);
		}
	}
	// ex) A03_DeptDao.java  
    // select * from dept01 where deptno=10
	// 부서번호별로 부서정보 가져오기 처리
	public Dept deptNoInfo(int deptno) {
		Dept dept = null;
		String sql = "select * \r\n"
				+ "from dept01 \r\n"
				+ "where deptno="+deptno;
		try {
			con = DB.con();//연결(예외처리)
			stmt = con.createStatement();//대화객체
			rs = stmt.executeQuery(sql);//결과객체
			if(rs.next()) {
				dept = new Dept(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3)
				);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());	
		} catch (Exception e) {
			System.out.println("일반:"+e.getMessage());	
		} finally {
			DB.close(rs, stmt, con);
		}
		return dept;
	}
	public Jobs getJobs(String jobid) {
		Jobs jobs = null;
		String sql = "SELECT *\r\n"
				+ "FROM JOBS \r\n"
				+ "WHERE JOB_ID ="+jobid;
		try {
			con = DB.con();//연결(예외처리)
			stmt = con.createStatement();//대화객체
			rs = stmt.executeQuery(sql);//결과객체
			if(rs.next()) {
				jobs = new Jobs(
				rs.getString(1),
				rs.getString(2),
				rs.getInt(3),
				rs.getInt(4)
				);
			}
			rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());	
		} catch (Exception e) {
			System.out.println("일반:"+e.getMessage());	
		} finally {
			DB.close(rs, stmt, con);
		}
		return jobs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A03_DeptDao dao = new A03_DeptDao();
//		dao.showDeptList();
//		Scanner sc = new Scanner(System.in);
//		System.out.print("직업을 입력:");
//		String job = sc.nextLine();
//		dao.paramEmp(job);
//		Dept e = dao.deptNoInfo(10);
//		System.out.println("부서번호 10 정보");
//		System.out.println(e.getDeptno());
//		System.out.println(e.getDname());
//		System.out.println(e.getLoc());
		Jobs e = dao.getJobs("'AD_PRES'");
		System.out.println("JOB_ID:AD_PRES의 정보");
		System.out.println(e.getJob_id());
		System.out.println(e.getJob_title());
		System.out.println(e.getMin_salary());
		System.out.printf("%,d\n",e.getMax_salary());
	}

}








