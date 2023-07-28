package springweb.a05_mvcexp.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvcexp.a02_service.A07_RegService;
import springweb.a05_mvcexp.z01_vo.Region;

@Controller
public class A07_RegCtrl {
	@Autowired
	private A07_RegService service;
	//regList.do
	@GetMapping("regList.do")
	public String regList() {
		return "WEB-INF\\views\\a05_mvcexp\\a09_regList.jsp";
	}
	
	
	// regData.do
	@RequestMapping("regData.do")
	public ResponseEntity<List<Region>> jobList(
		@RequestParam(value = "region_name",
					  defaultValue = "") String region_name){
		return ResponseEntity.ok(
			service.regionList(region_name));
	}		
	// regInsert.do?region_id=5&region_name=부산
	@RequestMapping("regInsert.do")
	public ResponseEntity<String> regInsert(Region ins){
		return ResponseEntity.ok(service.insertRegion(ins));
	}	
	// getRegion.do?region_name=서울
	@RequestMapping("getRegion.do")
	public ResponseEntity<Region> getRegion(@RequestParam("region_name") String region_name){
		return   ResponseEntity.ok(service.getRegion(region_name));
	}
	// updateRegion.do?region_name=인천&region_id=5
	@RequestMapping("updateRegion.do")
	public ResponseEntity<String> updateRegion(Region upt){
		return   ResponseEntity.ok(service.updateRegion(upt));
	}
	// deleteRegion.do?region_id=5
	@RequestMapping("deleteRegion.do")
	public ResponseEntity<String> deleteRegion(@RequestParam("region_id") int region_id){
		return   ResponseEntity.ok(service.deleteRegion(region_id));
	}
}
