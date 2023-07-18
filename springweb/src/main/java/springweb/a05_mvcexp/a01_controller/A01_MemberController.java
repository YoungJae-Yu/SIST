package springweb.a05_mvcexp.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a05_mvcexp.a02_service.A01_MemberService;
import springweb.a05_mvcexp.z01_vo.Member;

@Controller
public class A01_MemberController {
	@Autowired
	private A01_MemberService service;
	
	//http://localhost:7080/springweb/memberList.do
	@RequestMapping("memberList.do")
	public String memberList(Member sch, Model d) {
		System.out.println("#데이터 크기#");
		System.out.println(service.memberList(sch).size());
		
		return "";
	}
}
