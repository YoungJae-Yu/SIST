package springweb.a05_mvcexp.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a05_mvcexp.a03_dao.A07_RegDao;
import springweb.a05_mvcexp.z01_vo.Region;

@Service
public class A07_RegService {
	@Autowired
	private A07_RegDao dao;
	public List<Region> regionList(String region_name){
		if(region_name==null) region_name="";
		return dao.regionList(region_name);
	}
	public String insertRegion(Region insert) {
		return dao.insertRegion(insert)>0?
				"등록성공":"등록되지 않음";
	}		
	
}
