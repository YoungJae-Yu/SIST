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
	
	//http://localhost:5080/springweb/memberList.do
	@RequestMapping("memberList.do")
	public String memberList(Member sch, Model d) {
		System.out.println("#데이터 크기#");
		System.out.println(service.memberList(sch).size());
		d.addAttribute("memberList", service.memberList(sch));
		return "WEB-INF\\views\\a05_mvcexp\\a02_memberList.jsp";
	}
	//http://localhost:5080/springweb/daoexp.do
	@RequestMapping("daoexp.do")
	public String daoexp() {
		service.daoexp();
		return "";
	}
	//http://localhost:5080/springweb/daoexp02.do
	@RequestMapping("daoexp02.do")
	public String daoexp02() {
		service.daoexp02();
		return "";
	}
	//http://localhost:5080/springweb/locIns.do
	@RequestMapping("locIns.do")
	public String locIns() {
		service.locIns();
		return "";
	}
}
