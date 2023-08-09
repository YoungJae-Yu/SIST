package springweb.a05_mvcexp.a03_dao;

import java.util.List;

import springweb.a05_mvcexp.z01_vo.Calendar;

public interface A08_FullCalDao {
	public int insertCalendar(Calendar ins);
	public List<Calendar> calList();
	public int uptCalendar(Calendar upt);	
	public int delCalendar(int id);
}
