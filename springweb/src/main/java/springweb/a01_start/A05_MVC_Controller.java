package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// springweb.a01_start.A05_MVC_Controller
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backendWeb.a01_dao.A04_PreparedDao;
import backendWeb.z01_vo.Calculator;
import backendWeb.z01_vo.Dept;
import backendWeb.z01_vo.Emp;
@Controller
public class A05_MVC_Controller {
	// /mvc01.do
	// ?num01=30&cal= * &num02=5
	@RequestMapping("mvc01.do")
	public String mvc01(Calculator c) { //
		// Calculator : 매개변수로 선언하면, default로
		// 요청값을 처리할뿐이니라 모델객체로 선언된다. calculator
		if(c.getCal()!=null) {
			if(c.getCal().equals(" + ")) c.setTot(c.getNum01()+c.getNum02());
			if(c.getCal().equals(" - ")) c.setTot(c.getNum01()-c.getNum02());
			if(c.getCal().equals(" * ")) c.setTot(c.getNum01()*c.getNum02());
			if(c.getCal().equals(" / ")) c.setTot(c.getNum01()/c.getNum02());
		}
		
		return "WEB-INF\\views\\a01_start\\a02_mvc_view.jsp";
	}
	// /mvc02.do?name=
	@RequestMapping("mvc02.do")
	public String mvc02(@RequestParam("name") String name,
			Model d) {
		d.addAttribute("names", name+"@");
		return "WEB-INF\\views\\a01_start\\a03_mvc_view.jsp";
	}
	// /mvc03.do
	// 클릭시, +1 입력한 나이보다 증가하게 처리.
	// defaultValue : 요청값이 없을 시 default로 요청값을 설정
	@RequestMapping("mvc03.do")
	public String mvc03(@RequestParam(value="age", 
							defaultValue = "0") int age,
						 Model d) {
		d.addAttribute("ages", age+1);
		// 
		// <input name="age" value="${ages}"/>
		// 
		return "WEB-INF\\views\\a01_start\\a04_mvc_view.jsp";
	}
	// 2개의 매개변수값을 화면 출력 처리..
	@RequestMapping("mvc04.do")
	public String mvc04(@RequestParam(value="id", 
	                     defaultValue = "") String id,
						@RequestParam(value="pass", 
						 defaultValue = "") String pass,
						Model d) {
		/*
		${result}
		
		name="id"  value="" 입력값
		name="pass"   value="" 입력값
		
		 * */
		String result ="로그인하세요";
		if(!id.equals("")) {
			if(id.equals("himan")&&pass.equals("7777")) {
				result="로그인 성공";
			}else {
				result="로그인 실패";
			}
		}
		d.addAttribute("result", result);
		return "WEB-INF\\views\\a01_start\\a05_login.jsp";
	}
	// 사원명/직책명을 사원정보 조회 처리..
	@RequestMapping("empList88.do")
	public String empList88(Emp sch, Model d) {
		/* view
		name="ename"  value="${param.ename}"
		name="job"    value="${emp.job}"
		<c:for var="emp" items="${empList}"
			${emp.empno} ${emp.ename} ${emp.job}.. 
		 * */
		A04_PreparedDao dao = new A04_PreparedDao();
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		d.addAttribute("empList", dao.getEmpList(sch));
		return "WEB-INF\\views\\a01_start\\a06_empList.jsp";
	}
	
	// /deptList88.do
	// a07_deptList.jsp
	@RequestMapping("deptList88.do")
	public String deptList88(Dept sch, Model d) {
		if(sch.getDname()==null)sch.setDname("");
		if(sch.getLoc()==null)sch.setLoc("");
		
		A04_PreparedDao dao = new A04_PreparedDao();
		d.addAttribute("dlist", dao.getDeptList(sch));
		return "WEB-INF\\views\\a01_start\\a07_deptList.jsp";
	}
}
