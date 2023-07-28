package springweb.a05_mvcexp.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvcexp.a02_service.A06_JobService;
import springweb.a05_mvcexp.z01_vo.Job;

@Controller("jobCtrl")
public class A07_JobFormList {
	@Autowired
	private A06_JobService service;
	
	
	@RequestMapping("jobFormList.do")
	public String jobList(@ModelAttribute("sch") Job sch, Model d) {
		d.addAttribute("jobList", service.getJobList(sch));
		return "WEB-INF\\views\\a05_mvcexp\\a08_jobFormList.jsp";
	}
	@RequestMapping("jobInsert.do")
	public String jobInsert(Job ins, Model d) {
		if(ins.getJob_id()!=null) {
			d.addAttribute("msg", service.insertJob(ins));
		}
			
		return "WEB-INF\\views\\a05_mvcexp\\a10_jobInsertForm.jsp";
	}
	//  President
	// checkJob_id.do?job_id=PU_MAN
	@RequestMapping("checkJob_id.do")
	public ResponseEntity<String> checkJob_Id(
			@RequestParam("job_id") String job_id){
		return ResponseEntity.ok(service.checkId(job_id));
	}
	// checkjob_title.do?job_title=President
	@RequestMapping("checkJob_title.do")
	public ResponseEntity<String> checkJob_Title(
			@RequestParam("job_title") String job_title){
		return ResponseEntity.ok(service.checktitle(job_title));
	}	
}
