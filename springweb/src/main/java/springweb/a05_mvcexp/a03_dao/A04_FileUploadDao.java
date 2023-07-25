package springweb.a05_mvcexp.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import springweb.a05_mvcexp.z01_vo.Restore;

public interface A04_FileUploadDao {
	@Select("select file_seq.nextval from dual")
	public int getNo();
	@Insert("insert into restore values(#{no},#{content},"
			+ "#{filename},sysdate,sysdate)")
	public void insFileInfo(Restore ins);	
	@Select("select * from restore order by regdte desc")
	public List<Restore> restoreList();
}
