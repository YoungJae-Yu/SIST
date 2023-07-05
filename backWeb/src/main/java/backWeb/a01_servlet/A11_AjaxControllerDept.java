package backWeb.a01_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import backWeb.a01_dao.A04_PreParedDao;
import backWeb.z01_vo.Dept;

/**
 * Servlet implementation class A11_AjaxControllerDept
 */
@WebServlet(name = "dept.do", urlPatterns = { "/dept.do" })
public class A11_AjaxControllerDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A11_AjaxControllerDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 요청
		String deptnoS=request.getParameter("deptno");
		int deptno = 0;
		if(deptnoS!=null&&!deptnoS.equals(""))
			deptno = Integer.parseInt(deptnoS);
		
		// 2. 모델 Dept
		A04_PreParedDao dao = new A04_PreParedDao();
		Dept d = dao.getDept(deptno);
		
		// 3. json 뷰호출
		Gson g = new Gson();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		response.getWriter().print(g.toJson(d));
	}
}
