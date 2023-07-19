package springweb.a05_mvcexp.a03_dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import springweb.a05_mvcexp.z01_vo.Dept;
import springweb.a05_mvcexp.z01_vo.Emp;
import springweb.a05_mvcexp.z01_vo.Locations;
import springweb.a05_mvcexp.z01_vo.Member;
import springweb.a05_mvcexp.z01_vo.Student;
// springweb.a05_mvcexp.a03_dao.A01_MemberDao
@Repository
public interface A01_MemberDao {
	public List<Member> memberList(Member sch);
	public String exp01();
	public String exp02();
	public String exp03();
	public String exp04(String ename);
	public double exp05(int ename);
	public int exp06(String ename);
	public Date exp07(int ename);
	public void exp08Ins(Dept ins);
	public void exp09Ins(Student ins);
	public void locIns(Locations ins);
	public List<Emp> emp11EmpList(Emp sch);
	public List<Emp> exp12EmpList(Map sch);
	public List<Emp> exp13EmpList(Map sch);
	public void exp14DeptInsert(
			@Param("no") int deptno,
			@Param("dpartnm") String dname,
			@Param("location") String loc);
}
/*
==> Dao 를 만들려면?
  sql
  매개변수
  리턴데이터
  ==> Mapper.xml ==> A01_MemberDao상속받은 실제객체가 만들어진다.
  연동 규칙을 설정
    mapper.xml     interface
  1. namespce      springweb.a05_mvcexp.a03_dao.A01_MemberDao
  2. id            메서드명 memberList
  3. parameterType Member:공통mybatis에서 지정이름
  4. resutType     List<Member>
  5. sql
  	  getXXX호출.   ==> 실제 객체 메서드가 만들어져서 사용가능하다.
  	  
  
  
 */