package a01_diexp.z07_mvcAuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class A01_EmpController {
	@Autowired
	private A02_EmpService service;
	// 객체 생성이 명시적으로 없음. new XXX()
	// container 안에 객체가 있으면 할당.
	public void callEmpService() {
		System.out.println("# controller에서 서비스 호출 #");
		service.callService();
	}
}
