package springweb.a02_emp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import backendWeb.a01_dao.A04_PreparedDao;
import backendWeb.z01_vo.Emp;
// springweb.a02_emp.A01_EmpController
@Controller
public class A01_EmpController {
	private A04_PreparedDao dao;
	public A01_EmpController(){
		dao = new A04_PreparedDao();
	}
	//검색 form ==> empList.do?ename=홍길동&job=사원  
	@RequestMapping("empList.do")
	public String empList(Emp sch, Model d) {
		if(sch.getEname()==null) sch.setEname("");
		if(sch.getJob()==null) sch.setJob("");
		d.addAttribute("empList", dao.getEmpList(sch));
		return "WEB-INF\\views\\a02_emp\\a01_empList.jsp";
	}
	// view
	// ename=홍길동&job=사원  ==> form
	// <c:forEach var="emp" items="${empList}"/>
	//     <tr ondblick="goPage(${emp.empno})">
	//     function goPage(empno)
	//         location.href="${path}/empDetail.do?empno="+empno
	
	@RequestMapping("empDetail.do")
	public String empDetail(@RequestParam("empno") int empno,
							Model d) {
		d.addAttribute("emp", dao.getEmp(empno));
		return "WEB-INF\\views\\a02_emp\\a02_emp_datail.jsp";
	}
	/* view(jsp)
	 *  name="empno" value="${emp.empno}"
	 *  name="ename" value="${emp.ename}"
	 *  name="job" value="${emp.job}"
	 * */
	
	
	// name="empno" value="111"
	// name="ename" value="김영희"
	// empno=111&ename=김영희&job=@@&mgr=@@....
	// setEmpno(int empno)   setEname(String ename)....
	@RequestMapping("empInsert.do")
	public String empInsert(Emp ins, Model d) {
		// 요청값이 있을 type 맞고, property
		if(ins.getEmpno()!=0) {
			dao.insertEmp(ins);
			d.addAttribute("proc", "ins");//등록 처리 process 
		}
		return "WEB-INF\\views\\a02_emp\\a03_emp_insForm.jsp";
	}	
	// var proc = "${proc}"
	// if(proc=="ins")
	//    if(confirm("등록성공\n조회화면이동하시겠습니까?"))
	//         location.href="${path}/empList.do"
	
	// submit로 form name="empno" value="수정|기존"
	// submit로 form name="ename" value="수정|기존"
	//  ..
	// ?empno=101&ename=이영자&job=대리
	// setEmpno(int empno)...
	@RequestMapping("empUpdate.do")
	public String empUpdate(Emp upt, Model d) {
		dao.updateEmp(upt);
		// 수정 이후에 DB 다시 가져온다.
		d.addAttribute("emp", dao.getEmp(upt.getEmpno()));
		d.addAttribute("proc", "upt"); // 수정 처리 process
		return "WEB-INF\\views\\a02_emp\\a02_emp_datail.jsp";
	}
	@RequestMapping("empDelete.do")
	public String empDelete(@RequestParam("empno") int empno, 
							Model d) {
		dao.deleteEmp(empno);
		d.addAttribute("proc", "del"); // 삭제 처리 process
		return "WEB-INF\\views\\a02_emp\\a02_emp_datail.jsp";
	}	
	
}
