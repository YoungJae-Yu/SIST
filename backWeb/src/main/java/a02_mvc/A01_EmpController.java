package a02_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import backWeb.a01_dao.A04_PreParedDao;
/**
 * Servlet implementation class A01_
 */
@WebServlet(name = "empList.do", urlPatterns = { "/empList.do" })
public class A01_EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A01_EmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * ex) A02_JobController.java
	 * 
	 * a11_jobListSch.jsp
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청값 한글 encoding 처리
		request.setCharacterEncoding("utf-8");
		// 1. 요청값 처리
		String ename = request.getParameter("ename");
		if(ename==null)ename="";
		String job = request.getParameter("job");
		if(job==null)job="";
		
		// 2. 모델 데이터
		A04_PreParedDao dao = new A04_PreParedDao();
		request.setAttribute("empList", dao.getEmpList(ename,job));
		
		// 3.view단(jsp) 호출
		String page = "a10_empListSch.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
