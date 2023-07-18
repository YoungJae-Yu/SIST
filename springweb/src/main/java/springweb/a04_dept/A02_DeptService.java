package springweb.a04_dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backendWeb.a01_dao.A04_PreparedDao;
import backendWeb.z01_vo.Dept;

@Service
public class A02_DeptService {
	@Autowired
	private A04_PreparedDao dao;
	public List<Dept> getDeptList(Dept sch) {
		if(sch.getDname()==null) sch.setDname("");
		if(sch.getLoc()==null) sch.setLoc("");
		return dao.getDeptList(sch);
	}
}
