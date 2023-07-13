package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// springweb.a01_start.A03_CallMVC
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class A03_CallMVC {
	@RequestMapping("mvc99.do")
	public String mvc99(Model d) {
		d.addAttribute("show", "스프링 화면 호출");
		return "WEB-INF\\views\\a03_callmvc.jsp";
	}
}
