package springweb.a05_mvcexp.a01_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A09_ChattingController {
	// http://localhost:8080/springweb/chatting.do
	@GetMapping("chatting.do")
	public String chatting() {
		return "WEB-INF\\views\\a05_mvcexp\\a12_chatting.jsp";
	}
}
