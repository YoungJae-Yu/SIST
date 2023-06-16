package frontWeb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import frontWeb.vo.Emp;
import frontWeb.vo.Locations;

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
					System.out.print(" "+rs.getInt("empno"));
					// ex) 사원명과 관리자번호, 급여출력
					System.out.print(" "+rs.getString("ename"));
					System.out.print(" "+rs.getString("job"));
					System.out.print(" "+rs.getInt("mgr"));
					System.out.print(" "+rs.getDate("hiredate"));
					System.out.print(" "+rs.getDouble("sal"));
					System.out.print(" "+rs.getDouble("comm"));
					System.out.println(" "+rs.getInt("deptno"));
					
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
				// 자원해제 : 역순위
				rs.close();
				stmt.close();
				con.close();
				
			} catch (SQLException e) {
				System.out.println("DB 처리 예외:"+e.getMessage());
			} catch (Exception e) {
				System.out.println("공통 예외:"+e.getMessage());
			}finally {
				// 해제 전에 예외가 발생한 것을 처리.
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
	
	public void paramEmp(String ename) {
		System.out.println("메서드 호출");
		String sql = "SELECT * \r\n"
				+ "FROM EMP02 \r\n"
				+ "WHERE ename LIKE '%'||'"+ename+"'||'%'";
		System.out.println("매개변수:"+ename);
		System.out.println("sql:"+sql);
		try {
			// 1. 연결(예외처리)
			con = DB.con();
			// 2. 대화
			stmt = con.createStatement();
			// 3. 결과
			rs = stmt.executeQuery(sql);
			System.out.println("처리3");
			while(rs.next()) { // 행단위 이동 커서
				// 열단위 호출 rs.get유형("컬럼명")
				System.out.print(rs.getInt("empno")+"\t"); 
				System.out.print(rs.getString("ename")+"\t"); 
				System.out.print(rs.getDouble("sal")+"\n"); 
			}
			// 4. 자원해제
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		// A03_DeptDao.java
		// 부서명을 키워드 검색 처리.(메서드 추가)	
	}
	// 입력값을 부서 번호, 리턴할 값은 해당 부서의 사원수
	public int getDeptCount(int deptno) {
		int count = 0;
		String sql = "SELECT count(*) cnt \r\n"
				+ "FROM EMP02 e \r\n"
				+ "WHERE DEPTNO = "+deptno;
		try {
			// 1. 연결(예외처리)
			con = DB.con();
			// 2. 대화
			stmt = con.createStatement();
			// 3. 결과
			rs = stmt.executeQuery(sql);
			// 데이터가 한개만 나오는 경우(row단위)
			if(rs.next()) count = rs.getInt("cnt");
			// 4. 자원해제
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return count;
	}
	// 사원번호의 급여를 리턴하는 메서드 선언.
	public int getEmpnoSal(int empno) {
		int sal = 0;
		String sql = "SELECT sal\r\n"
				+ "FROM EMP02 e \r\n"
				+ "WHERE EMPNO = "+empno;
		try {
			// 1. 연결(예외처리)
			con = DB.con();
			// 2. 대화
			stmt = con.createStatement();
			// 3. 결과
			rs = stmt.executeQuery(sql);
			// 데이터가 한개만 나오는 경우(row단위)
			if(rs.next()) sal = rs.getInt("sal");
			// 4. 자원해제
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return sal;
	}
	public Emp getEmp(int empno) {
		Emp emp = null;
		String sql = "SELECT *\r\n"
				+ "FROM EMP02 e \r\n"
				+ "WHERE EMPNO = "+empno;
		try {
			// 1. 연결(예외처리)
			con = DB.con();
			// 2. 대화
			stmt = con.createStatement();
			// 3. 결과
			rs = stmt.executeQuery(sql);
			// 데이터가 한개만 나오는 경우(row단위)
			if(rs.next()) {// 한번만 호출
				// empno 키이기에..
				// select * 의 순서대로 컬럼, 순서를 사용
				emp = new Emp(
				rs.getInt("empno"),
				rs.getString(2),
				rs.getString(3),
				rs.getInt("mgr"),
				rs.getDate(5),
				rs.getDouble("sal"),
				rs.getDouble("comm"),
				rs.getInt(8)
				);
			}
			// 4. 자원해제
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return emp;
	}
	public List<Emp> getEmpList(Emp sch){
		List<Emp> elist = new ArrayList<Emp>();
		String sql = "select *\r\n"
				+ "from emp02\r\n"
				+ "WHERE ename like '%'||'"+sch.getEname()+"'||'%' \r\n"
				+ "AND job like '%'||'"+sch.getJob()+"'||'%'";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				elist.add(new Emp(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getDate(5),
					rs.getDouble(6),
					rs.getDouble(7),
					rs.getInt(8)
				));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return elist;
	}
	public List<Locations> getLocationsList(Locations locations) {
		List<Locations> elist = new ArrayList<Locations>();
		String sql = "SELECT *\r\n"
				+ "FROM LOCATIONS\r\n"
				+ "WHERE STREET_ADDRESS like '%'||'"+locations.getStreet_address()+"'||'%'\r\n"
				+ "AND CITY like '%'||'"+locations.getCity()+"'||'%'";
		try {
			con = DB.con();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				elist.add(new Locations(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6)
				));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("sql예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		return elist;
	}
	
	// ex) A03_DeptDao.java  
    // select * from dept01 where deptno=10
	// 부서번호별로 부서정보 가져오기 처리
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A02_EmpDao dao = new A02_EmpDao();
		dao.empListAll();
//		System.out.println("20번 부서의 사원건수:"+dao.getDeptCount(10));
		Scanner sc = new Scanner(System.in);
//		System.out.print("검색할 사원명을 입력하세요:");
//		String scEname = sc.nextLine();
//		dao.paramEmp(scEname);
//		System.out.print("확인할 부서번호 입력:");
//		int deptno=sc.nextInt();
//		System.out.println("20번 부서의 사원건수:"+dao.getDeptCount(deptno));
//		System.out.print("급여를 확인할 사원번호 입력:");
//		int deptno=sc.nextInt();
//		System.out.println("사원의 급여:"+dao.getEmpnoSal(deptno));
//		Emp e = dao.getEmp(7499);
//		System.out.println("7499사원정보");
//		System.out.println(e.getEname());
//		System.out.println(e.getJob());
//		System.out.println(e.getDeptno());
		for(Emp e:dao.getEmpList(new Emp("A","A"))) {
			System.out.print(e.getEmpno()+"\t");
			System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob()+"\t");
			System.out.print(e.getSal()+"\n");
		}
		for(Locations e:dao.getLocationsList(new Locations("u","o"))) {
			System.out.print(e.getLocation_id()+"\t");
			System.out.print(e.getStreet_address()+"\t");
			System.out.print(e.getPostal_code()+"\t");
			System.out.print(e.getCity()+"\t");
			System.out.print(e.getState_province()+"\t");
			System.out.print(e.getCountry_id()+"\n");
		}
		
	}

}
