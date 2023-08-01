package springweb.a04_dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import backendWeb.z01_vo.Dept;
import backendWeb.z01_vo.Emp;

@Controller
public class A01_DeptController {
	@Autowired
	private A02_DeptService service;
	/*
	 * 요청메서드 선언
	 * 1. url 패턴 ex) @RequestMapping("deptList01.do")
	 * 	http://localhost:5080/springweb/deptList01.do
	 * 2. 요청값 ==> ename=@@&loc=@@ ==> Dept(setDname, setLoc)
	 * 3. 모델데이터 ==> view 단 넘길데이터
	 * 	model.addAttribute("모델명", service.XXX());
	 * 4. 뷰단 처리
	 *	return "" : jsp 경로 위치 복사.
	 */
	@RequestMapping("deptList01.do")
	public String deptList(Dept sch, Model d) {
		d.addAttribute("deptList", service.getDeptList(sch));
		return "WEB-INF\\views\\a04_dept\\a01_deptList.jsp";
	}
	@RequestMapping("deptListAjax.do")
	public ResponseEntity<List<Dept>> empList(Dept sch) {
		return ResponseEntity.ok(service.getDeptList(sch));
	}
	/*
	 * dao 직책 검색 직책아이디로
	 * 
	 */
}
