package springweb.a02_emp;

import org.springframework.stereotype.Controller;
// springweb.a02_emp.A01_StartController
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class A01_StartController {
	@RequestMapping("call888.do")
	public String call888() {
		return "";
	}
}
