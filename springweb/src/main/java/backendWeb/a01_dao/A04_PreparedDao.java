package backendWeb.a01_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import backendWeb.z01_vo.Code;
import backendWeb.z01_vo.Department;
import backendWeb.z01_vo.Dept;
import backendWeb.z01_vo.Emp;
import backendWeb.z01_vo.Employee;
import backendWeb.z01_vo.Job;
import backendWeb.z01_vo.JobHistory;
import backendWeb.z01_vo.Location;
import backendWeb.z01_vo.Manager;


// ctrl+shift+o
// backendWeb.z01_vo.Emp
// backendWeb.a01_dao.A04_PreparedDao
public class A04_PreparedDao {
	
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public List<Employee> getEmpList(Map<String, String> sch) {
        List<Employee> elist = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES "
        		+ "WHERE UPPER(FIRST_NAME || last_name) LIKE UPPER(?) AND salary BETWEEN ? AND ?";
        System.out.println("# DB 접속 #");
        System.out.println(sch.get("name"));
        System.out.println(sch.get("minSal"));
        System.out.println(sch.get("maxSal"));
        
        try {
            con = DB.con();
            pstmt = con.prepareStatement(sql); 
            pstmt.setString(1, "%" + sch.get("name") + "%");
            pstmt.setDouble(2, Double.parseDouble(sch.get("minSal")));
            pstmt.setDouble(3, Double.parseDouble(sch.get("maxSal")));
            rs = pstmt.executeQuery();

            while (rs.next()) {
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
        } catch (SQLException e) {
            System.out.println("DB 관련 오류: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("일반 오류: " + e.getMessage());
        } finally {
            DB.close(rs, pstmt, con);
        }
        return elist;
    }

    public List<JobHistory> getHistory(Map<String, String> sch) {
        List<JobHistory> jobList = new ArrayList<>();
        String sql = "SELECT * FROM JOB_HISTORY WHERE job_id LIKE ? AND DEPARTMENT_ID BETWEEN ? AND ?";
        try {
            con = DB.con();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + sch.get("job_id") + "%");
            pstmt.setInt(2, Integer.parseInt(sch.get("mi_dId")));
            pstmt.setInt(3, Integer.parseInt(sch.get("mx_dId")));
            rs = pstmt.executeQuery();

            while (rs.next()) {
                jobList.add(new JobHistory(
                        rs.getInt("employee_id"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("job_id"),
                        rs.getInt("department_id")
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

    public List<Job> getJob(Map<String, String> sch) {
        List<Job> jobList = new ArrayList<>();
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
                jobList.add(new Job(
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

    // void, int나 다른 유형을 하느냐?
    // 외부이 이 메서드를 호출해서 등록/수정/삭제된 갯수를 알고자 할때.
    // return int
    // 등록/수정/삭제로 끝날 경우에는 void
    
    public void insertEmp(Emp ins) {
        String sql = "INSERT INTO emp02 values(?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?)";
        try {
            con = DB.con();
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

    public int insertDepartments(Department ins) {
        int isInsert = 0;
        String sql = "INSERT INTO DEPARTMENTS10 values(?,?,?,?)";
        try {
            con = DB.con();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ins.getDepartment_id());
            pstmt.setString(2, ins.getDepartment_name());
            pstmt.setInt(3, ins.getManager_id());
            pstmt.setInt(4, ins.getLocation_id());
            isInsert = pstmt.executeUpdate();
            if (isInsert == 1) {
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
        return isInsert;
    }

    public void updateEmp(Emp upt) {
        String sql = "UPDATE EMP02 "
        		+ "   SET ENAME = ?, job = ?, sal = ?, "
        		+ "       hiredate = to_date(?,'YYYY/MM/DD'),"
        		+ "       deptno = ? "
        		+ "   WHERE empno = ?";
        try {
            con = DB.con();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, upt.getEname());
            pstmt.setString(2, upt.getJob());
            pstmt.setDouble(3, upt.getSal());
            pstmt.setString(4, upt.getHiredateS());
            pstmt.setInt(5, upt.getDeptno());
            pstmt.setInt(6, upt.getEmpno());
            int result = pstmt.executeUpdate();
            if (result == 1) {
                con.commit();
                System.out.println("수정 성공");
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

    public int updateLocation(Location upt) {
        int isUpdate = 0;
        String sql = "UPDATE locations10 SET street_address = ?, postal_code = ?, city=?, state_province=?, country_id=? WHERE location_id=?";
        try {
            con = DB.con();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, upt.getStreet_address());
            pstmt.setString(2, upt.getPostal_code());
            pstmt.setString(3, upt.getCity());
            pstmt.setString(4, upt.getState_province());
            pstmt.setString(5, upt.getCountry_id());
            pstmt.setInt(6, upt.getLocation_id());
            isUpdate = pstmt.executeUpdate();
            if (isUpdate == 1) {
                con.commit();
                System.out.println("수정 성공");
            }
        } catch (SQLException e) {
            System.out.println("DB 오류: " + e.getMessage());
            DB.rollback(con);
        } catch (Exception e) {
            System.out.println("일반 오류: " + e.getMessage());
        } finally {
            DB.close(rs, pstmt, con);
        }
        return isUpdate;
    }

    public int deleteLocation(int location_id) {
        int isDelete = 0;
        String sql = "DELETE FROM locations10 WHERE location_id=?";
        try {
            con = DB.con();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, location_id);
            isDelete = pstmt.executeUpdate();
            if (isDelete == 1) {
                con.commit();
                System.out.println("삭제 성공");
            }
        } catch (SQLException e) {
            System.out.println("DB 오류: " + e.getMessage());
            DB.rollback(con);
        } catch (Exception e) {
            System.out.println("일반 오류: " + e.getMessage());
        } finally {
            DB.close(rs, pstmt, con);
        }
        return isDelete;
    }

    public Employee getEmpList(String id) {
    	Employee emp=null;
	    String sql = "SELECT * FROM EMPLOYEES "
	    		+ "WHERE employee_id = ?";
	    System.out.println("# DB 접속 #");
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        pstmt.setString(1, id);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	emp= new Employee(
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
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return emp;
	}

	public List<Manager> getManager() {
	    List<Manager> elist = new ArrayList<Manager>();
	    String sql = "SELECT empno, ename, dname\r\n"
	    		+ "	FROM emp e, dept d\r\n"
	    		+ "	WHERE e.deptno = d.deptno\r\n"
	    		+ "	AND empno in (\r\n"
	    		+ "	   SELECT DISTINCT mgr FROM emp\r\n"
	    		+ "	) order by ename ";
	    System.out.println("# DB 접속 #");
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	// empno, ename, dname
	            elist.add(new Manager(
	                    rs.getInt("empno"),
	                    rs.getString("ename"),
	                    rs.getString("dname")
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

	public List<Job> getJobs() {
	    List<Job> elist = new ArrayList<Job>();
	    String sql = "	SELECT * \r\n"
	    		+ "	FROM jobs\r\n"
	    		+ "	ORDER BY job_title ";
	    System.out.println("# DB 접속 #");
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
	        rs = pstmt.executeQuery();
	        //job_id, job_title, min_salary, max_salary
	        while (rs.next()) {
	        	elist.add(new Job(
	        			rs.getString("job_id"),
	        			rs.getString("job_title"),
	        			rs.getInt("min_salary"),
	        			rs.getInt("max_salary")
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

	public List<Emp> getEmpList() {
	    List<Emp> elist = new ArrayList<>();
	    String sql = "SELECT * FROM emp02 order by empno";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql); 
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
	    String sql = "SELECT *\r\n"
	    		+ "FROM code\r\n"
	    		+ "WHERE title LIKE ?\r\n"
	    		+ "START WITH refno = ?\r\n"
	    		+ "CONNECT BY PRIOR NO =refno ";
	    	
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
	    		+ "ORDER BY ordno ";
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

	// void, int나 다른 유형을 하느냐?
	// 외부이 이 메서드를 호출해서 등록/수정/삭제된 갯수를 알고자 할때.
	// return int
	// 등록/수정/삭제로 끝날 경우에는 void
	
	/*
	INSERT INTO code VALUES (code_seq.nextval, '아이티사업',1006,4,40);
			INSERT INTO code VALUES (code_seq.nextval, ?,?,?,?)
	 * */
	
	public void insertCode(Code ins) {
	    String sql = "INSERT INTO code VALUES"
	    		+ " (code_seq.nextval, ?,?,?,?)";
	    try {
	        con = DB.con();
	        con.setAutoCommit(false);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, ins.getTitle());
	        pstmt.setInt(2, ins.getRefno());
	        pstmt.setInt(3, ins.getOrdno());
	        pstmt.setString(4, ins.getVal());
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
/*
SELECT * 
FROM code
WHERE NO = ?
UPDATE code
    SET title = ?,
        refno = ?,
        ordno = ?,
        val = ?
   WHERE NO = ?
delete
FROM code
WHERE NO = ?
 * */
	public Code getCode(int no) {
	    Code c = null;
	    String sql = " SELECT * \r\n"
	    		+ "FROM code\r\n"
	    		+ "WHERE NO = ?";
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, no);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            c = new Code(
	                    rs.getInt("no"),
	                    rs.getString("title"),
	                    rs.getString("val"),
	                    rs.getInt("refno"),
	                    rs.getInt("ordno")
	            );
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 관련 오류: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return c;
	}

	public void updateCode(Code upt) {
	    String sql = "UPDATE code\r\n"
	    		+ "    SET title = ?,\r\n"
	    		+ "        refno = ?,\r\n"
	    		+ "        ordno = ?,\r\n"
	    		+ "        val = ?\r\n"
	    		+ "   WHERE NO = ?";
	    // title title refno ordno val NO
	    try {
	        con = DB.con();
	        con.setAutoCommit(false);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, upt.getTitle());
	        pstmt.setInt(2, upt.getRefno());
	        pstmt.setInt(3, upt.getOrdno());
	        pstmt.setString(4, upt.getVal());
	        pstmt.setInt(5, upt.getNo());
	        int result = pstmt.executeUpdate();
	        if (result == 1) {
	            con.commit();
	            System.out.println("수정 성공");
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
	public int deleteCode(int no) {
		int ret = 0;
	    String sql = "delete\r\n"
	    		+ "FROM code\r\n"
	    		+ "WHERE NO = ?";
	    try {
	        con = DB.con();
	        con.setAutoCommit(false);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, no);
	        ret = pstmt.executeUpdate();
	        if (ret >= 1) {
	            con.commit();
	            System.out.println("삭제 성공");
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 오류: " + e.getMessage());
	        DB.rollback(con);
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return ret;
	}

	/*
	SELECT * 
	FROM code
	WHERE NO = ?
	UPDATE code
	    SET title = ?,
	        refno = ?,
	        ordno = ?,
	        val = ?
	   WHERE NO = ?
	delete
	FROM code
	WHERE NO = ?
	 * */
		public Dept getDept(int no) {
		    Dept c = new Dept(0,"","");
		    String sql = " SELECT * \r\n"
		    		+ "FROM dept\r\n"
		    		+ "WHERE deptno = ?";
		    try {
		        con = DB.con();
		        pstmt = con.prepareStatement(sql);
		        pstmt.setInt(1, no);
		        rs = pstmt.executeQuery();
		        if (rs.next()) {
		            c = new Dept(
		                    rs.getInt("deptno"),
		                    rs.getString("dname"),
		                    rs.getString("loc")
		            );
		        }
		    } catch (SQLException e) {
		        System.out.println("DB 관련 오류: " + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("일반 오류: " + e.getMessage());
		    } finally {
		        DB.close(rs, pstmt, con);
		    }
		    return c;
		}

	public List<Job> getJobs(String job_id) {

			List<Job> jlist = new ArrayList<Job>(); 
		    String sql = "	SELECT * \r\n"
		    		+ "FROM jobs\r\n"
		    		+ "WHERE JOB_ID like ? ";
		    System.out.println("# DB 접속 #");
		    try {
		        con = DB.con();
		        pstmt = con.prepareStatement(sql); 
		        pstmt.setString(1, '%'+job_id+'%');; 
		        rs = pstmt.executeQuery();
		        //job_id, job_title, min_salary, max_salary
		        while (rs.next()) {
		        	jlist.add(new Job(
		        			rs.getString("job_id"),
		        			rs.getString("job_title"),
		        			rs.getInt("min_salary"),
		        			rs.getInt("max_salary")
		        			)
		        	);
		        }
		    } catch (SQLException e) {
		        System.out.println("DB 관련 오류: " + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("일반 오류: " + e.getMessage());
		    } finally {
		        DB.close(rs, pstmt, con);
		    }
		    return jlist;
		}

	public List<Emp> getEmpList(Emp sch) {
	    List<Emp> elist = new ArrayList<>();
	    String sql = "SELECT * FROM emp02 where ename like ? and job like ? order by empno ";
	    
	    try {
	        con = DB.con();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, '%'+sch.getEname()+"%");
	        pstmt.setString(2, '%'+sch.getJob()+"%");
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

	/*
	SELECT * 
	FROM code
	WHERE NO = ?
	UPDATE code
	    SET title = ?,
	        refno = ?,
	        ordno = ?,
	        val = ?
	   WHERE NO = ?
	delete
	FROM code
	WHERE NO = ?
	 * */
		public List<Dept> getDeptList(Dept sch) {
			List<Dept> dlist = new ArrayList<Dept>();
		    String sql = " SELECT * \r\n"
		    		+ "FROM dept\r\n"
		    		+ "WHERE dname like ?\r\n "
		    		+ "AND loc like ?";
		    try {
		        con = DB.con();
		        pstmt = con.prepareStatement(sql);
		        pstmt.setString(1, "%"+sch.getDname()+"%");
		        pstmt.setString(2, "%"+sch.getLoc()+"%");
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		        	dlist.add(new Dept(
		                    rs.getInt("deptno"),
		                    rs.getString("dname"),
		                    rs.getString("loc"))
		            );
		        }
		    } catch (SQLException e) {
		        System.out.println("DB 관련 오류: " + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("일반 오류: " + e.getMessage());
		    } finally {
		        DB.close(rs, pstmt, con);
		    }
		    return dlist;
		}

	public Emp getEmp(int empno) {
		    Emp emp = null;
		    String sql = "SELECT * FROM emp02 "
		    		+ "where empno=? ";
		    try {
		        con = DB.con();
		        pstmt = con.prepareStatement(sql);
		        pstmt.setInt(1, empno);
		        rs = pstmt.executeQuery();
		        if(rs.next()) {
		        	emp=new Emp(
		                    rs.getInt("empno"),
		                    rs.getString("ename"),
		                    rs.getString("job"),
		                    rs.getInt("mgr"),
		                    rs.getDate("hiredate"),
		                    rs.getDouble("sal"),
		                    rs.getDouble("comm"),
		                    rs.getInt("deptno")
		            );
		        }
		    } catch (SQLException e) {
		        System.out.println("DB 관련 오류: " + e.getMessage());
		    } catch (Exception e) {
		        System.out.println("일반 오류: " + e.getMessage());
		    } finally {
		        DB.close(rs, pstmt, con);
		    }
		    return emp;
		}

	public int deleteEmp(int empno) {
	    int isDelete = 0;
	    String sql = "DELETE FROM emp02 WHERE empno=?";
	    try {
	        con = DB.con();
	        con.setAutoCommit(false);
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, empno);
	        isDelete = pstmt.executeUpdate();
	        if (isDelete == 1) {
	            con.commit();
	            System.out.println("삭제 성공");
	        }
	    } catch (SQLException e) {
	        System.out.println("DB 오류: " + e.getMessage());
	        DB.rollback(con);
	    } catch (Exception e) {
	        System.out.println("일반 오류: " + e.getMessage());
	    } finally {
	        DB.close(rs, pstmt, con);
	    }
	    return isDelete;
	}

	public static void main(String[] args) {
        A04_PreparedDao dao = new A04_PreparedDao();
        dao.deleteLocation(1000);
        dao.deleteLocation(1100);
        dao.deleteLocation(1200);

//        dao.updateLocation(new Location(1100, "삼성로", "401123", "서울", "서울", "SE"));
//        dao.updateEmp(new Emp(7499, "오길동(upt)", "대리", "2023/06/01", 5000.0));
//        dao.insertDepartments(new Department(350, "재무", 300, 1800));
//        Emp ins = new Emp(1005, "오길동", "과장", 7902, "2023-05-01", 4500.0, 1000.0, 20);
//        dao.insertEmp(ins);

//        Map<String, String> sch = new HashMap<>();
//        sch.put("title", "S");
//        sch.put("min_sal1", "1000");
//        sch.put("min_sal2", "10000");
//        for (Job job : dao.getJob(sch)) {
//            System.out.print(job.getJob_id() + "\t");
//            System.out.print(job.getJob_title() + "\t");
//            System.out.print(job.getMax_salary() + "\t");
//            System.out.print(job.getMin_salary() + "\n");
//        }

//        for (JobHistory jh : dao.getHistory(sch)) {
//            System.out.print(jh.getEmployee_id() + "\t");
//            System.out.print(jh.getDepartment_id() + "\t");
//            System.out.print(jh.getJob_id() + "\t");
//            System.out.print(jh.getStart_date() + "\t");
//            System.out.print(jh.getEnd_date() + "\n");
//        }

//        sch.put("name", "A");
//        sch.put("minSal", "0");
//        sch.put("maxSal", "12000");
//        for (Employee e : dao.getEmpList(sch)) {
//            System.out.print(e.getEmployee_id() + "\t");
//            System.out.print(e.getLast_name() + "\t");
//            System.out.print(e.getFirst_name() + "\t");
//            System.out.print(e.getEmail() + "\t");
//            System.out.print(e.getSalary() + "\t");
//            System.out.print(e.getDepartment_id() + "\n");
        
//        }
        Gson g;
    }
}
