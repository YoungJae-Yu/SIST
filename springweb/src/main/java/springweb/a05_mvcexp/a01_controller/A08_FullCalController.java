package springweb.a05_mvcexp.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvcexp.a02_service.A08_FullCalService;
import springweb.a05_mvcexp.z01_vo.Calendar;

@Controller
public class A08_FullCalController {
	@Autowired
	private A08_FullCalService service;
	// http://localhost:8080/springweb/calendar.do
	@GetMapping("calendar.do")
	public String calendar() {
		return "WEB-INF\\views\\a05_mvcexp\\a11_fullcalendar.jsp";
	}
	
	// http://localhost:8080/springweb/calList.do
	@RequestMapping("calList.do")
	public ResponseEntity<List<Calendar>> calList() {
		return ResponseEntity.ok(service.calList());
	}
	// http://localhost:8080/springweb/insertCalendar.do
	@RequestMapping("insertCalendar.do")
	public ResponseEntity<String> insertCalendar(Calendar ins) {
		return ResponseEntity.ok(service.insertCalendar(ins));
	}
	
		// http://localhost:8080/springweb/calendarUpdate.do
		@RequestMapping("calendarUpdate.do")
	public ResponseEntity<String> calendarUpdate(Calendar upt) {
		return ResponseEntity.ok(service.uptCalendar(upt));
	}
	
		// http://localhost:8080/springweb/calendarDelete.do?id=3
		@RequestMapping("calendarDelete.do")
	public ResponseEntity<String> calendarDelete(@RequestParam("id") int id) {
		return ResponseEntity.ok(service.delCalendar(id));
	}
}
		