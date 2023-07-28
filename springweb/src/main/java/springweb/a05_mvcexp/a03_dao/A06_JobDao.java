package springweb.a05_mvcexp.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import springweb.a05_mvcexp.z01_vo.Job;



public interface A06_JobDao {
	@Select("SELECT * \r\n"
			+ "FROM jobs01\r\n"
			+ "WHERE job_id LIKE '%'||#{job_id}||'%'\r\n"
			+ "AND job_title LIKE '%'||#{job_title}||'%'\r\n "
			+ "ORDER BY job_id" )
	public List<Job> getJobList(Job sch);
	@Insert("INSERT INTO jobs01 values(#{job_id},#{job_title},\r\n"
			+ "			#{min_salary},#{max_salary})")
	public int insertJob(Job ins);
	@Select("	SELECT count(*)\r\n"
			+ "	FROM jobs01\r\n"
			+ "	WHERE LOWER(job_id)=lower(#{job_id})")
	public int checkId(@Param("job_id") String job_id);
	
	@Select("	SELECT count(*)\r\n"
			+ "	FROM jobs01\r\n"
			+ "	WHERE LOWER(job_title)=lower(#{job_title}) ")
	public int checktitle(@Param("job_title") String job_title);

	
	@Select("select * from jobs01 where job_id=#{job_id}")
	public Job getJob(@Param("job_id") String job_id);
	@Update("update jobs01 set job_title=#{job_title},min_salary=#{min_salary},max_salary=#{max_salary} where job_id=#{job_id}")
	public int updateJob(Job upt);
	@Delete("delete from jobs01 where job_id=#{job_id}")
	public int deleteJob(@Param("job_id") String job_id);

}
