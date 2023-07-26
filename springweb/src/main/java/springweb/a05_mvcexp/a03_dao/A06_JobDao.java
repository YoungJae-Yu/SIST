package springweb.a05_mvcexp.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import springweb.a05_mvcexp.z01_vo.Job;



public interface A06_JobDao {
	@Select("SELECT *\r\n"
			+ "FROM jobs01\r\n"
			+ "WHERE JOB_ID LIKE '%'||#{job_id}||'%'\r\n"
			+ "and JOB_TITLE  LIKE '%'||#{job_title}||'%'")
	public List<Job> getJobList(Job sch);
	@Insert("INSERT INTO JOBS01 j VALUES(#{job_id},#{job_title},"
			+ "#{min_salary},#{max_salary})")
	public int insertJob(Job ins);
}
