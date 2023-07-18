package springweb.a05_mvcexp.a03_dao;

import java.util.List;

import springweb.a05_mvcexp.z01_vo.Member;
// springweb.a05_mvcexp.a03_dao.A01_MemberDao
public interface A01_MemberDao {
	public List<Member> memberList(Member sch);
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