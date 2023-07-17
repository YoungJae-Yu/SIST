package a01_diexp.z06_callMvc;

import java.util.List;

import org.springframework.stereotype.Service;

import backendWeb.z01_vo.Emp;

@Service
public class A02_Service {
	private A03_Repository dao;
	public A02_Service() {
		dao = new A03_Repository();
	}
	public List<Emp> empLsit(Emp sch){
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		return dao.empList(sch);
	}
}
