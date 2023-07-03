package backWeb.a01_dao;
///frontWeb.A04_PreParedDao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import backWeb.saram_vo.Company;
//import backWeb.saram_vo.Match;
import backWeb.z01_vo.Code;
import backWeb.z01_vo.Departments;
import backWeb.z01_vo.Dept;
import backWeb.z01_vo.Emp;
import backWeb.z01_vo.Employee;
import backWeb.z01_vo.Jobs;
import backWeb.z01_vo.Locations;
import backWeb.z01_vo.Manager;

//backWeb.a01_dao.A04_PreParedDao
/*
#Dao(Database Access Object)
1. 프로그램은 기능별 모듈 분리화 정책을 하여야
	추후, 확장성이 뛰어나고, 다른 코드에 영향력이
	적어 유지보수에 효과적으로
2. 기능적을 다른 내용을 분리시켜서 사용하세요
	1) console 처리 : 객체를 생성해 매개변수 데이터를 받고
		리턴값으로 결과를 리턴처리
	2) 웹화면 처리 : 요청값을 데이터를 받아서 리턴할 VO 객체를
		받아서 화면에 출력한다.
 */
public class A04_PreParedDao {
	// 필드
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<Employee> getEmpList(Map<String,String> sch){
		List<Employee> elist = new ArrayList<Employee>();
		String sql = "SELECT *\r\n"
				+ "FROM EMPLOYEES e\r\n"
				+ "WHERE FIRST_NAME || LAST_NAME LIKE '%'||?||'%'\r\n"
				+ "AND SALARY BETWEEN ? AND ?";
		
		try {
			con = DB.con();
			// 초기에 sql을 넘기면서 pstmt 객체 생성
			pstmt = con.prepareStatement(sql);
			// pstmt.set데이터유형(순서-1부터, 입력할 데이터)
			pstmt.setString(1, sch.get("name"));
			pstmt.setDouble(2, Double.parseDouble(sch.get("minSal")));
			pstmt.setDouble(3, Double.parseDouble(sch.get("maxSal")));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				elist.add(new Employee(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("phone_number"),
						rs.getDate("hire_date"),
						rs.getString("job_id"),
						rs.getDouble("salary"),
						rs.getDouble("commission_pct"),
						rs.getInt("manager_id"),
						rs.getInt("department_id")
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
		return elist;
	}
    public List<Jobs> getJob(Map<String, String> sch) {
        List<Jobs> jobList = new ArrayList<>();
        String sql = "SELECT * FROM jobs "
        		+ "	WHERE UPPER(job_title) LIKE UPPER(?) AND MIN_SALARY BETWEEN ? AND ?";
        // where upper(컬럼) : 대상데이터를 대문자 변경
        // like LIKE UPPER(?) : 입력데이터로 대문자 변경
        // 대소문자 상관없이 검색이 가능하도록 처리.
        try {
            con = DB.con();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + sch.get("title") + "%");
            pstmt.setInt(2, Integer.parseInt(sch.get("min_sal1")));
            pstmt.setInt(3, Integer.parseInt(sch.get("min_sal2")));
            rs = pstmt.executeQuery();

            while (rs.next()) {
                jobList.add(new Jobs(
                        rs.getString("job_id"),
                        rs.getString("job_title"),
                        rs.getInt("min_salary"),
                        rs.getInt("max_salary")
                ));
            }
        } catch (SQLException e) {
            System.out.println("DB 예외: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("일반 예외: " + e.getMessage());
        } finally {
            DB.close(rs, pstmt, con);
        }
        return jobList;
    }
	
	public List<Jobs> getJobs(Map<String,String> sch){
		List<Jobs> elist = new ArrayList<Jobs>();
		String sql = "SELECT *\r\n"
				+ "FROM JOBS\r\n"
				+ "WHERE JOB_TITLE LIKE '%'||?||'%'\r\n"
				+ "AND MIN_SALARY BETWEEN ? AND ?";
		try {
			con = DB.con();
			// 초기에 sql을 넘기면서 pstmt 객체 생성
			pstmt = con.prepareStatement(sql);
			// pstmt.set데이터유형(순서-1부터, 입력할 데이터)
			pstmt.setString(1, sch.get("job"));
			pstmt.setDouble(2, Double.parseDouble(sch.get("min_salary")));
			pstmt.setDouble(3, Double.parseDouble(sch.get("max_salary")));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				elist.add(new Jobs(
						rs.getString("job_id"),
						rs.getString("job_title"),
						rs.getInt("min_salary"),
						rs.getInt("max_salary")
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
		return elist;
	}
	public void insertEmp(Emp ins) {
		String sql="INSERT INTO EMP02 e \r\n"
				+ "	VALUES(?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?)";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getEmpno());
			pstmt.setString(2, ins.getEname());
			pstmt.setString(3, ins.getJob());
			pstmt.setInt(4, ins.getMgr());
			pstmt.setString(5, ins.getHiredateS());
			pstmt.setDouble(6, ins.getSal());
			pstmt.setDouble(7, ins.getComm());
			pstmt.setInt(8, ins.getDeptno());
			System.out.println(pstmt.executeUpdate());
			con.commit();//입력시 확정
			pstmt.close();
			con.close();
			System.out.println("등록성공");
			
			
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
//	SELECT * FROM DEPARTMENTS10 d ;
//	-- DEPARTMENTS를 입력 처리하세요
	public int insertDepartments(Departments ins) {
		int isInsert = 0;
		String sql="INSERT INTO DEPARTMENTS10 \r\n"
				+ "	VALUES(?,?,?,?)";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getDepartment_id());
			pstmt.setString(2, ins.getDepartment_name());
			pstmt.setInt(3, ins.getManager_id());
			pstmt.setInt(4, ins.getLocation_id());
			isInsert = pstmt.executeUpdate();
			if(isInsert == 1) System.out.println("등록성공");
			con.commit();//입력시 확정
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
		return isInsert;
		
	}
	public void updateEmp(Emp upt) {
		String sql="UPDATE EMP02 \r\n"
				+ "	SET ENAME = ?,\r\n"
				+ "		JOB = ?,\r\n"
				+ "		sal = ?,\r\n"
				+ "		HIREDATE = to_date(?,'YYYY/MM/DD')\r\n"
				+ "	WHERE EMPNO = ?";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getEname());
			pstmt.setString(2, upt.getJob());
			pstmt.setDouble(3, upt.getSal());
			pstmt.setString(4, upt.getHiredateS());
			pstmt.setInt(5, upt.getEmpno());
			int isUpt = pstmt.executeUpdate();
			if(isUpt == 1) System.out.println("수정성공");
			con.commit();//입력시 확정
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
	public void updateLc(Locations upt) {
		String sql="UPDATE LOCATIONS10 "
				+ "SET street_address = ?,\r\n"
				+ "		   postal_code = ?,\r\n"
				+ "		   city = ?,\r\n"
				+ "		   state_province = ?,\r\n"
				+ "		   country_id = ?\r\n"
				+ "	   WHERE location_id = ?";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getStreet_address());
			pstmt.setString(2, upt.getPostal_code());
			pstmt.setString(3, upt.getCity());
			pstmt.setString(4, upt.getState_province());
			pstmt.setString(5, upt.getCountry_id());
			pstmt.setInt(6, upt.getLocation_id());
			int isUpt = pstmt.executeUpdate();
			if(isUpt == 1) System.out.println("수정성공");
			con.commit();//입력시 확정
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
	public void deleteLc(Locations del) {
		int inDel = 0;
		String sql="DELETE \r\n"
				+ "FROM LOCATIONS10\r\n"
				+ "WHERE location_id=?";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, del.getLocation_id());
			inDel = pstmt.executeUpdate();
			if(inDel == 1) System.out.println("삭제성공");
			con.commit();//입력시 확정
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
	public Employee getEmpList(String id){
		Employee emp = null;
		String sql = "SELECT * FROM EMPLOYEES "
				+ "WHERE employee_id = ?";
		System.out.println("# DB 접속 #");
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				emp = new Employee(
						rs.getInt("employee_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("phone_number"),
						rs.getDate("hire_date"),
						rs.getString("job_id"),
						rs.getDouble("salary"),
						rs.getDouble("commission_pct"),
						rs.getInt("manager_id"),
						rs.getInt("department_id")
						);
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
		return emp;
	}
	public List<Manager> getManager(){
		List<Manager> elist = new ArrayList<Manager>();
		String sql = "SELECT EMPNO , ename, dname\r\n"
				+ "	FROM emp e, dept d\r\n"
				+ "	WHERE e.DEPTNO = d.DEPTNO \r\n"
				+ "	AND empno IN(\r\n"
				+ "		SELECT DISTINCT mgr FROM EMP e\r\n"
				+ "	)";
		System.out.println("# DB접속 #");
		try {
			con = DB.con();
			// 초기에 sql을 넘기면서 pstmt 객체 생성
			pstmt = con.prepareStatement(sql);
			// pstmt.set데이터유형(순서-1부터, 입력할 데이터)
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// empno, ename, dname
				elist.add(new Manager(
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("dname")
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
		return elist;
	}
	public List<Jobs> getJobs(){
		List<Jobs> elist = new ArrayList<Jobs>();
		String sql = "SELECT JOB_ID , JOB_TITLE \r\n"
				+ "FROM JOBS j";
		System.out.println("# DB접속 #");
		try {
			con = DB.con();
			// 초기에 sql을 넘기면서 pstmt 객체 생성
			pstmt = con.prepareStatement(sql);
			// pstmt.set데이터유형(순서-1부터, 입력할 데이터)
			rs = pstmt.executeQuery();
			while(rs.next()) {
				elist.add(new Jobs(
						rs.getString("job_id"),
						rs.getString("job_title"),
						rs.getInt("min_salary"),
						rs.getInt("max_salary")
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
		return elist;
	}
//	public List<Company> getCompany(){
//		List<Company> clist = new ArrayList<Company>();
//		String sql = "SELECT comname, comtype\r\n"
//				+ "FROM company";
//		try {
//			con = DB.con();
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				clist.add(new Company(
//						rs.getString("comName"),
//						rs.getString("comType")
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
//		return clist;
//	}
//	public List<Match> getMatch(){
//		List<Match> mlist = new ArrayList<Match>();
//		String sql = "SELECT placeOfWork \"지역\",comName \"회사명\",memCareer \"경력\" ,hopeWorktype \"계약형태\",fieldName \"모집분야\",salary \"연봉\",receptionMethod \"접수방법\"\r\n"
//				+ "FROM resume r, jobPosting01 j\r\n"
//				+ "WHERE r.resumeld = j.postId\r\n"
//				+ "AND placeOfWork = ?";
//		try {
//			con = DB.con();
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				mlist.add(new Match(
//						rs.getString("placeOfWork")
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
	public List<Emp> elist() {
	      List<Emp> emplist = new ArrayList<Emp>();
	      String sql = "SELECT * FROM emp02";
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
	        	 emplist.add(new Emp(
	               rs.getInt("empno"),
	               rs.getString("ename"),
	               rs.getString("job"),
	               rs.getInt("mgr"),
	               rs.getString("hiredate"),
	               rs.getDouble("sal"),
	               rs.getDouble("comm"),
	               rs.getInt("deptno")
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
	      return emplist;
	   }
	public List<Emp> getEmpList(String ename, String job) {
	    List<Emp> elist = new ArrayList<>();
	    String sql = "SELECT * FROM emp02 where ename like ? and job like ? order by empno ";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, '%'+ename+"%");
	        pstmt.setString(2, '%'+job+"%");
	        rs = pstmt.executeQuery();
	        
	
	        while (rs.next()) {
	            elist.add(new Emp(
	                    rs.getInt("empno"),
	                    rs.getString("ename"),
	                    rs.getString("job"),
	                    rs.getInt("mgr"),
	                    rs.getDate("hiredate"),
	                    rs.getDouble("sal"),
	                    rs.getDouble("comm"),
	                    rs.getInt("deptno")
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return elist;
	}

	public List<Code> getCodeList(String title, int refno) {
	    List<Code> elist = new ArrayList<Code>();
	    String sql = "SELECT * \r\n"
	    		+ "FROM code\r\n"
	    		+ "WHERE title LIKE ?\r\n"
	    		+ "START WITH refno = ?\r\n"
	    		+ "CONNECT BY PRIOR NO = refno";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, '%'+title+"%");
	        pstmt.setInt(2, refno);
	        rs = pstmt.executeQuery();
	        
	
	        while (rs.next()) {
	            elist.add(new Code(
	                    rs.getInt("no"),
	                    rs.getString("title"),
	                    rs.getString("val"),
	                    rs.getInt("refno"),
	                    rs.getInt("ordno")
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return elist;
	}
	public List<Code> getCombo(int refno) {
	    List<Code> elist = new ArrayList<Code>();
	    String sql = "SELECT title, val\r\n"
	    		+ "FROM code\r\n"
	    		+ "WHERE refno = ?\r\n"
	    		+ "ORDER BY ordno";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, refno);
	        rs = pstmt.executeQuery();
	        
	
	        while (rs.next()) {
	            elist.add(new Code(
	                    rs.getString("title"),
	                    rs.getString("val")
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return elist;
	}
	public void insertCode(Code ins) {
		String sql="INSERT INTO code VALUES (code_seq.nextval,?,?,?,?)";
		try {
			con = DB.con();
			// 자동 commit방지
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ins.getTitle());
			pstmt.setInt(2, ins.getRefno());
			pstmt.setInt(3, ins.getOrdno());
			pstmt.setString(4, ins.getVal());
			int isInsert = pstmt.executeUpdate();
			if(isInsert == 1) {
				con.commit();//입력시 확정
				System.out.println("등록성공");
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
	public List<Dept> getDeptList(String dname, String loc) {
	    List<Dept> elist = new ArrayList<Dept>();
	    String sql = "SELECT *\r\n"
	    		+ "FROM DEPT d \r\n"
	    		+ "WHERE dname LIKE ?\r\n"
	    		+ "AND LOC LIKE ?";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, dname);
	        pstmt.setString(2, loc);
	        rs = pstmt.executeQuery();
	        
	
	        while (rs.next()) {
	            elist.add(new Dept(
	                    rs.getInt("deptno"),
	                    rs.getString("dname"),
	                    rs.getString("loc")
	            ));
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return elist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A04_PreParedDao dao = new A04_PreParedDao();
		Map<String, String> sch = new HashMap<String, String>();
//		dao.insertDepartments(new Departments(1,"IT",777,1777));
//		public Emp(int empno, String ename, 
//				String job, Date hiredate, Double sal) {
//			super();
//			this.empno = empno;
//			this.ename = ename;
//			this.job = job;
//			this.hiredate = hiredate;
//			this.sal = sal;
		dao.updateEmp(new Emp(7499,"오길동(upt)","대리","2023/06/01",5000.0));
		dao.updateLc(new Locations(1000,"종로1가","343122","서울","서울","SE"));
		dao.deleteLc(new Locations(1000));
		
//		Emp ins = new Emp(1005,"오길동","과장",7902,
//				"2016-03-25",5500.0,1200.0,10);
//		dao.insertEmp(ins);
		
//int empno, String ename, String job, int mgr, 
//Date hiredate, String hiredateS, Double sal, Double comm,
//int deptno
//		sch.put("name", "A");
//		sch.put("minSal", "0");
//		sch.put("maxSal", "12000");
//		for(Employee e:dao.getEmpList(sch)) {
//			System.out.print(e.getEmployee_id()+"\t");
//			System.out.print(e.getFirst_name()+"\t");
//			System.out.print(e.getLast_name()+"\t");
//			System.out.print(e.getEmail()+"\t");
//			System.out.print(e.getPhone_number()+"\t");
//			System.out.print(e.getHire_date()+"\t");
//			System.out.print(e.getSalary()+"\t");
//			System.out.print(e.getManager_id()+"\n");
//		}
//		sch.put("job", "S");
//		sch.put("minDepartment", "10");
//		sch.put("maxDepartment", "120");
//		for(Job_history e:dao.getJob(sch)) {
//			System.out.print(e.getEmployee_id()+"\t");
//			System.out.print(e.getStart_date()+"\t");
//			System.out.print(e.getEnd_date()+"\t");
//			System.out.print(e.getJob_id()+"\t");
//			System.out.print(e.getDepartment_id()+"\n");
//		}
//		sch.put("job", "S");
//		sch.put("min_salary", "1000");
//		sch.put("max_salary", "10000");
//		for(Jobs e:dao.getJobs(sch)) {
//			System.out.print(e.getJob_id()+"\t");
//			System.out.print(e.getJob_title()+"\t");
//			System.out.print(e.getMin_salary()+"\t");
//			System.out.print(e.getMax_salary()+"\n");
//		}
	}

}
