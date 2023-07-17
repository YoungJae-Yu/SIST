package a01_diexp.z05_mvc;

import java.util.List;

import org.springframework.stereotype.Controller;

import backendWeb.z01_vo.Dept;
// Web_Controller
@Controller
public class Web_Controller {
	private Web_Service service;
	public Web_Controller() {
		service = new Web_Service();
	}
	public List<Dept> getDeptList(Dept sch) {
		System.out.println("컨트롤러 호출");
		return service.deptLsit(sch);
	}
}
