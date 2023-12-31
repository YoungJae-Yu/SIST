package springweb.a05_mvcexp.a02_service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvcexp.a03_dao.A01_MemberDao;
import springweb.a05_mvcexp.a03_dao.A04_FileUploadDao;
import springweb.a05_mvcexp.z01_vo.Dept;
import springweb.a05_mvcexp.z01_vo.Emp;
import springweb.a05_mvcexp.z01_vo.EmpDept;
import springweb.a05_mvcexp.z01_vo.Employee;
import springweb.a05_mvcexp.z01_vo.EmployeesJobs;
import springweb.a05_mvcexp.z01_vo.FileVo;
import springweb.a05_mvcexp.z01_vo.Job;
import springweb.a05_mvcexp.z01_vo.Locations;
import springweb.a05_mvcexp.z01_vo.Member;
import springweb.a05_mvcexp.z01_vo.Restore;
import springweb.a05_mvcexp.z01_vo.Student;

@Service
public class A01_MemberService {
	@Autowired
	private A01_MemberDao dao; // 인터페이스 = new 실제객체()
	
	public List<Member> memberList(Member sch){
		if(sch.getId()==null) sch.setId("");
		if(sch.getName()==null) sch.setName("");
		return dao.memberList(sch);
	}
	public void daoexp() {
//		System.out.println("#dao 연습#");
//		System.out.println("첫번째 연습"+dao.exp01());
//		System.out.println("두번째 연습"+dao.exp02());
//		System.out.println("세번째 연습"+dao.exp03());
//		System.out.println("네번째 연습"+dao.exp04("KING"));
//		System.out.println("다섯번째 연습"+dao.exp05(7844));
//		System.out.println("여섯번째 연습"+dao.exp06("CLARK"));
//		System.out.println("일곱번째 연습"+dao.exp07(7844));
//		System.out.println("연습08 입력:");
//		//dao.exp08Ins(new Dept(12,"재무","대전"));
//		System.out.println("연습 11 emp조회");
//		for(Emp emp:dao.emp11EmpList(new Emp("",1000.0,3000.0))) {
//			System.out.print(emp.getEname()+"\t");
//			System.out.print(emp.getJob()+"\t");
//			System.out.print(emp.getSal()+"\n");
//		}
//		System.out.println("연습 12 emp조회");
//		Map<String,String> sch = new HashMap<String,String>();
//		sch.put("ename_sch","A");
//		sch.put("job_sch","ER");
//		for(Emp e:dao.exp12EmpList(sch)){
//			System.out.print(e.getEname()+"\t");
//			System.out.print(e.getJob()+"\n");
//		}
//		System.out.println("연습 13 emp조회");
//		Map<String,String> sch1 = new HashMap<String,String>();
//		sch1.put("job01","CLERK");
//		sch1.put("job02","MANAGER");
//		for(Emp e:dao.exp13EmpList(sch1)){
//			System.out.print(e.getEname()+"\t");
//			System.out.print(e.getJob()+"\n");
//		}
//		//dao.exp14DeptInsert(22, "교육","부산");
//		System.out.print("연습 15");
//		for(Emp emp:dao.exp15EmpList("1981-01-01","1981-12-31")){
//			System.out.print(emp.getEname()+"\t");
//			System.out.print(emp.getHiredate()+"\n");
//		}
//		System.out.print("연습 16");
//		for(Student emp:dao.exp16("홍길동",20,100)){
//			System.out.print(emp.getSno()+"\t");
//			System.out.print(emp.getName()+"\t");
//			System.out.print(emp.getKor()+"\t");
//			System.out.print(emp.getEng()+"\t");
//			System.out.print(emp.getMath()+"\n");
//		}
//		System.out.print("연습 17");
//		Employee emp = dao.exp17getEmpLoyee(100);
//		System.out.print(emp.getEmployee_id()+"\t");
//		System.out.print(emp.getFirst_name()+"\t");
//		System.out.print(emp.getLast_name()+"\n");
//		
//		System.out.print("연습 18");
//		Jobs job = dao.exp18getJobs("AD_PRES");
//		System.out.print(job.getJob_id()+"\t");
//		System.out.print(job.getJob_title()+"\t");
//		System.out.print(job.getMin_salary()+"\t");
//		System.out.print(job.getMax_salary()+"\n");
//		System.out.print("연습 19");
//		for(String name:dao.exp19getEnames(1000,3000)){
//			System.out.println(name);
//		}
//		System.out.print("연습 20");
//		for(String city:dao.exp20getCity("US")){
//			System.out.println(city);
//		}
//		System.out.println("연습 21 resultMap 연 습");
//		for(Emp emp1:dao.getEmpResultExp()){
//			System.out.print(emp1.getEmpno()+"\t");
//			System.out.print(emp1.getEname()+"\t");
//			System.out.print(emp1.getSal()+"\n");
//		}
//		System.out.println("연습 22 resultMap 연습");
//		for(Dept d:dao.getDeptResultExp()){
//			System.out.print(d.getDeptno()+"\t");
//			System.out.print(d.getDname()+"\t");
//			System.out.print(d.getLoc()+"\n");
//		}
//		System.out.println("연습 23 resultMap association 연습");
//		for(EmpDept ed:dao.getEmpDeptList("A","SAL")){
//			System.out.print(ed.getEmp().getEmpno()+"\t");
//			System.out.print(ed.getEmp().getEname()+"\t");
//			System.out.print(ed.getEmp().getSal()+"\t");
//			System.out.print(ed.getDept().getDeptno()+"\t");
//			System.out.print(ed.getDept().getDname()+"\n");
//		}
//		System.out.println("연습 24 resultMap association 연습");
//		for(EmployeesJobs ed:dao.getEmployeesJobsList("e","o")){
//			System.out.print(ed.getEmployee().getFirst_name()+"\t");
//			System.out.print(ed.getEmployee().getLast_name()+"\t");
//			System.out.print(ed.getJobs().getJob_id()+"\t");
//			System.out.print(ed.getJobs().getJob_title()+"\t");
//			System.out.print(ed.getJobs().getMin_salary()+"\t");
//			System.out.print(ed.getJobs().getMax_salary()+"\n");
//		}
//		System.out.println("연습 25 부서의 사원수:");
//		System.out.println(dao.getDeptnoCnt(30)+"명");
//		System.out.println("연습 26 급여별 사원수:");
//		System.out.println(dao.getSalCnt(1000,4000)+"명");
////		System.out.println("연습 27 ins:");
////		dao.getInsDept(10,"홍길동","서울");
////		System.out.println("입력완료");
////		System.out.println("연습 28 udt:");
////		dao.getUdtStudent(100);
////		System.out.println("업데이트완료");
////		System.out.println("연습 29 del:");
////		dao.getDelEmp(100);
////		System.out.println("삭제완료");
////		System.out.println("연습 30  동적 query 처리");
//		System.out.println("1) ename이 null일 때");
//		for(Emp e:dao.getDynamicSQL(null)) {
//			System.out.println(e.getEname());
//		}
//		System.out.println("2) ename이 null이 아닐 때(A)");
//		for(Emp e:dao.getDynamicSQL("A")) {
//			System.out.println(e.getEname());
//		}
//	 	List<Integer> empnos = new ArrayList<Integer>();
//	 	empnos.add(7369);
//	 	empnos.add(7499);
//	 	empnos.add(7521);
//	 	for(Emp emp1:dao.getEmpByEmpnos(empnos)) {
//	 		System.out.print(emp1.getEmpno()+"\t");
//	 		System.out.print(emp1.getEname()+"\t");
//	 		System.out.print(emp1.getJob()+"\n");
//	 	}
	 	System.out.println("연습 30 파일업로드 등록");
	 	dao2.insFileInfo(new Restore(2, "파일내용", "파일명"));
		
		
		
		
	}
	
	public void daoexp02() {
		System.out.println("연습09 입력:");
		dao.exp09Ins(new Student(3,"김길동",90,80,70));
	}
	public void locIns() {
		System.out.println("loc입력:");
		dao.locIns(new Locations(2000,"테헤란로21길","2434","서울","대한민국","KR"));
	}
		@Autowired
		private A04_FileUploadDao dao2;

	
}
