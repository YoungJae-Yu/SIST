package springweb.a05_mvcexp.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvcexp.a03_dao.A06_JobDao;
import springweb.a05_mvcexp.z01_vo.Job;

@Service
public class A06_JobService {
	@Autowired 
	private A06_JobDao dao;
	public List<Job> getJobList(Job sch){
		if(sch.getJob_id()==null) sch.setJob_id("");
		if(sch.getJob_title()==null) sch.setJob_title("");
		return dao.getJobList(sch);
	}
	public String insertJob(Job ins) {
		return dao.insertJob(ins)>0?"등록성공":"등록되지 않음" ;
		
	}	
	public String checkId(String job_id) {
		return dao.checkId(job_id)>0?"등록불가":"등록가능";
	}
	public String checktitle(String job_title) {
		return dao.checktitle(job_title)>0?"등록불가":"등록가능";
	}
	public Job getJob(String job_id){
		return dao.getJob(job_id);
	}
	public String updateJob(Job upt){
		return dao.updateJob(upt)>0?"수정성공":"수정되지않음";
	}
	public String deleteJob(String job_id){
		return dao.deleteJob(job_id)>0?"삭제성공":"수정되지않음";
	}
}
