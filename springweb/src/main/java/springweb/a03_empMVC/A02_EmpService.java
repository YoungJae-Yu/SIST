package springweb.a03_empMVC;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backendWeb.a01_dao.A04_PreparedDao;
import backendWeb.z01_vo.Emp;

@Service
public class A02_EmpService {
	@Autowired
	private A04_PreparedDao dao;
	public List<Emp> getEmpList(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		return dao.getEmpList(sch);
	}
	public Emp getEmp(int empno) {
		
		return dao.getEmp(empno);
	}
	public void insertEmp(Emp ins) {
		dao.insertEmp(ins);
	}
	 public void updateEmp(Emp upt) {
		 dao.updateEmp(upt);
	 }
	public int deleteEmp(int empno) {
		return dao.deleteEmp(empno);
	}
	// controller dao ==> service로 변경..
	// 	controller 안에 A04_PreparedDao 객체 생성 부분 삭제 처리.
}
