package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// springweb.a01_start.A04_ModelView
import org.springframework.web.bind.annotation.RequestMapping;

import backendWeb.z01_vo.Dept;
import backendWeb.z01_vo.Product;
@Controller
public class A04_ModelView {
	
	@RequestMapping("modelExp01.do")
	public String modelExp01(Model d) {
		// 모델데이터에 객체 선언..
		d.addAttribute("prod", new Product("사과",3000,2));
		// jsp
		// ${prod.name}  Product  getName()
		// ${prod.price} Product  getPrice()
		// ${prod.cnt}   Product  getCnt()
		
		return "WEB-INF\\views\\a01_start\\a01_model01.jsp";
	}
	// modelExp02.do
	// Dept객체를 이용해서 부서번호 부서명 부서위치를 모델 객체로 
	// 	저장후, view단에서 출력하세요
	// a01_start\\a01_model02.jsp
	@RequestMapping("modelExp02.do")
	public String modelExp02(Model d) {
		d.addAttribute("dept", new Dept(10,"인사","부산"));
		return "WEB-INF\\views\\a01_start\\a01_model02.jsp";
	}
	
	
}
