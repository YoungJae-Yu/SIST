package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// springweb.a01_start.A02_CallController
@Controller
public class A02_CallController {
	// http://localhost:7080/springweb/callCtrl1.do
	@RequestMapping("callCtrl1.do")
	public String callCtrl1(Model d) {
		d.addAttribute("greet", "hello spring");
		// ${greet}
		return "WEB-INF\\views\\a02_callView.jsp";
	}
}
/*
 * 
 * */






