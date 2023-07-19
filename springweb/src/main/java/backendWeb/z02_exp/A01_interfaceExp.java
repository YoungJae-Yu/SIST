package backendWeb.z02_exp;

import java.util.ArrayList;
import java.util.List;

import backendWeb.z01_vo.Member;

public class A01_interfaceExp {
	public static void main(String[] args) {
		// 다형성의 형태, 추상 ==> 실제
		Flyway f01 = new CountryFly();
		// 추상인터페이스의 메서드가 실제를 상속해주었기 때문에
		// 상속받은 실제 객체의 내용을 처리해준다.
		f01.flying();
		// service단에서.
		// Autowired 처리
		MemberDao dao;
		dao = new MemberDaoImpl();
		dao.memberList();
	}
}
interface MemberDao{
	public List<Member> memberList();
}
// mybatis ==> XXXmapper.xml에 의해서 sql
// 인터페이스명, 메서드명, 리턴값, 매개변수 ==> XXXMapper.xml 
//  ==> 상속받은 실제 객체							앞에 정보  + sql                          
// MemberDao dao = new MemberDaoImpl();
// 인터페이스로 데이터를 리턴하는 객체의 메서드를 사용할 수 있다.
/*
# Service
@AutoWierd
private MemberDao dao;
dao.getMemberList(); ==> 리스트형 결과 객체

 */
class MemberDaoImpl implements MemberDao{
	@Override
	public List<Member> memberList() {
		// TODO Auto-generated method stub
		// sql의 데이터 처리에 의해 최종적으로 결과 ArrayList
		// 가 있는 객체를 생성해준다.
		ArrayList<Member> mlist = new ArrayList<Member>();
		mlist.add(new Member());
		mlist.add(new Member());
		mlist.add(new Member());
		return mlist;
	}
}
interface Flyway{
	void flying();
}
class CountryFly implements Flyway{
	@Override
	public void flying() {
		// TODO Auto-generated method stub
		System.out.println("우리 동네를 날다");
	}
}