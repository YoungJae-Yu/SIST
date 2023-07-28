package springweb.a05_mvcexp.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import springweb.a05_mvcexp.z01_vo.Job;
import springweb.a05_mvcexp.z01_vo.Region;

public interface A07_RegDao {
	@Select("SELECT * \r\n"
			+ "FROM regions01\r\n"
			+ "WHERE REGION_NAME LIKE '%'||#{region_name}||'%'")
	public List<Region> regionList(@Param("region_name")
		String region_name);
	@Insert("INSERT INTO regions01 values(\r\n"
			+ "			#{region_id},#{region_name})")
	public int insertRegion(Region insert);	
	
	@Select("select * from regions01 where region_name =#{region_name}")
	public Region getRegion(@Param("region_name") String region_name);
	@Update("update regions01 set region_name=#{region_name} where region_id=#{region_id}")
	public int updateRegion(Region upt);
	@Delete("delete from regions01 where region_id=#{region_id}")
	public int deleteRegion(@Param("region_id") int region_id);
	
}
