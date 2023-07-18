package springweb.a05_mvcexp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backendWeb.z01_vo.Job;

@Controller
public class A01_JobController {
	@Autowired
	private A02_JobService service;
	@RequestMapping("jobList01.do")
	public String jobList(@RequestParam(value = "job_id", 
	defaultValue = "") String job_id, Model d) {
		d.addAttribute("jobList01", service.getJobs(job_id));
		return "WEB-INF\\views\\a05_job\\a01_jobList.jsp";
	}
}
