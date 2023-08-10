package springweb.a05_mvcexp.a01_controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class A10_MultiLanController {
	@Autowired
	// http://localhost:8080/springweb/multi.do
	private LocaleResolver localeResolver;
	@RequestMapping("multi.do")
	public String multi(@RequestParam(value="lang", defaultValue="ko") 
								String lang,
								HttpServletRequest request,
								HttpServletResponse response) {
		System.out.println("선택한 언어:"+lang);
		localeResolver.setLocale(request, response, new Locale(lang));
		return "WEB-INF\\views\\a05_mvcexp\\a13_multilanguage.jsp";
	}
}
