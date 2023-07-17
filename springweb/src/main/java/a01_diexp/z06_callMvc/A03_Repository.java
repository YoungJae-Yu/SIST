package a01_diexp.z06_callMvc;

import java.util.List;

import org.springframework.stereotype.Repository;

import backendWeb.a01_dao.A04_PreparedDao;
import backendWeb.z01_vo.Emp;

@Repository
public class A03_Repository {
	private A04_PreparedDao dao;
	public A03_Repository() {
		dao = new A04_PreparedDao();
	}
	public List<Emp> empList(Emp sch){
		return dao.getEmpList(sch);
	}
}
