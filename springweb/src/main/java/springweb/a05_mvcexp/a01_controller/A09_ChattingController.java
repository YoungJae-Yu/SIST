package springweb.a05_mvcexp.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a06_util.ChatHandler;

@Controller
public class A09_ChattingController {
	// http://localhost:8080/springweb/chatting.do
	@GetMapping("chatting.do")
	public String chatting() {
		return "WEB-INF\\views\\a05_mvcexp\\a12_chatting.jsp";
	}
	@Autowired
	private ChatHandler chatHandler;
	// ajax로 현재 접속한 인원 확인
	@GetMapping("getChatMem.do")
	public ResponseEntity<List<String>> getChatMem() {
		return ResponseEntity.ok(chatHandler.getIds());
	}
	// choMems.do
	@GetMapping("/choMems.do")
	public ResponseEntity<String> choMems(
			@RequestParam("members") List<String> mems) {
		System.out.println("서버에 있는 데이터 크기 :"+mems.size());
		return ResponseEntity.ok(chatHandler.setMembers(mems));
	}
}
