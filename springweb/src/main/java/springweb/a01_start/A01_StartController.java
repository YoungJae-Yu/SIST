package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backWeb.z01_vo.Person;
import backWeb.z01_vo.Product;
import backWeb.z01_vo.Team;

// springweb.a01_start.A01_StartController
@Controller
public class A01_StartController {
	// http://localhost:5080/springweb/start.do?name
	@RequestMapping("/start.do")
	public String start(@RequestParam("name") String name,
			Model d) {
		// view단에 넘겨줄 핵심 데이터 :  모델데이터
		// jsp ==> ${msg}
		d.addAttribute("msg", "안녕하세요 스프링모뎅 데이터");
		return "WEB-INF\\views\\a01_start.jsp";
	}
	@RequestMapping("/start2.do")
	public String start2() {
		return "WEB-INF\\views\\a02_start.jsp";
	}
	// ex) A02_CallController.java
	// 주의) container(xml) 등록, @Controller 클래스 상단 
	// 기능 메서드 추가하고
	// http://localhost:5080/springweb/callCtrl1.do
	// 모델데이터 greet : "hello spring"
	// a02_callView.jsp 를 호출해서 모델 데이터 출력
	
	// 단일 요청키
	//  req01.do?name=홍길동&age=25
	@RequestMapping("req01.do")
	public String req01(@RequestParam("name") String name,
							@RequestParam("age") int age) {
		System.out.println("받은 요청값:"+name);
		System.out.println("받은 요청값:"+age);
		return "WEB-INF\\\\views\\\\a01_start.jsp";
	}
	// req02.do?pname=사과&price=3000&cnt=5
	// 로그로 물건명:@@ 가격:@@ 갯수:@@ 출력
	@RequestMapping("req02.do")
	public String req02(@RequestParam("pname") String pname,
			@RequestParam("price") int price,
			@RequestParam("cnt") int cnt
			) {
		System.out.println("물건명:"+pname);
		System.out.println("가격:"+price);
		System.out.println("갯수:"+cnt);
		System.out.println("총합:"+(price*cnt));
		return "";
	}
	// req03.do?names=홍길동&names=김길동&names=신길동
	@RequestMapping("req03.do")
	public String req02(
			@RequestParam("names")
		String[] names) {
		System.out.println("이름1:"+names[0]);
		System.out.println("이름2:"+names[1]);
		System.out.println("이름3:"+names[2]);
		return "";
	}
	// req04.do?name=홍길동&age=25&loc=서울
	// 1. 위 내용을 받을 수 있는 기능 메서드 property가 있는 클래스
	//		생성 또는 확인...
	// 2. setName(String), setAge(int), setLoc(String)
	@RequestMapping("req04.do")
	public String req04(Person p01) {
		System.out.println("요청값 내용(Person)");
		System.out.println("이름:"+p01.getName());
		System.out.println("나이:"+p01.getAge());
		System.out.println("사는곳:"+p01.getLoc());
		 return "";
	}
	// ex1) req05.do?name=사과&price=3000&cnt=5
	@RequestMapping("req05.do")
	public String req05(Product p01) {
		System.out.println("요청값 내용(예제1)");
		System.out.println("물건명:"+p01.getName());
		System.out.println("가격:"+p01.getPrice());
		System.out.println("갯수:"+p01.getCnt());
		return "";
	}
	
	// ex2) req06.do?tname=LG&win=5&def=2
	@RequestMapping("req06.do")
	public String req06(Team t01) {
		System.out.println("요청값 내용(예제2)");
		System.out.println("팀이름:"+t01.getTname());
		System.out.println("승리:"+t01.getWin());
		System.out.println("패배:"+t01.getDef());
		return "";
	}
	
}


























