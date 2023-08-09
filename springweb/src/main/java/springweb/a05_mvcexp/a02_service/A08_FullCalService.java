package springweb.a05_mvcexp.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvcexp.a03_dao.A08_FullCalDao;
import springweb.a05_mvcexp.z01_vo.Calendar;

@Service
public class A08_FullCalService {
	@Autowired
	private A08_FullCalDao dao;
	
	public String insertCalendar(Calendar ins) {
		return dao.insertCalendar(ins)>0?"등록성공":"등록실패";
	}
	public List<Calendar> calList(){
		return dao.calList();
	}
	public String uptCalendar(Calendar upt) {
		return dao.uptCalendar(upt)>0?"수정성공":"수정실패";
	}
	public String delCalendar(int id) {
		return dao.delCalendar(id)>0?"삭제성공":"삭제실패";
	}
}
