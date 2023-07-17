package a01_diexp.z06_callMvc;

import java.util.List;

import org.springframework.stereotype.Controller;

import backendWeb.z01_vo.Emp;

@Controller
public class A01_Controller {
	private A02_Service service;
	public A01_Controller() {
		service = new A02_Service();
	}
	public List<Emp> getEmpList(Emp sch) {
		System.out.println("사원리스트 출력");
		return service.empLsit(sch);
	}
}
