package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class A03_CallMVC {
	// http://localhost:5080/springweb/mvc99.do
	@RequestMapping("/mvc99.do")
	public String mvc99(Model d) {
		d.addAttribute("show", "스프링 화면 호출");
		return "WEB-INF\\views\\a03_callmvc.jsp";
	}
}
