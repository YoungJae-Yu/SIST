package springweb.a05_mvcexp.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
