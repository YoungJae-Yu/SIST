package backWeb.a01_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import backWeb.a01_dao.A04_PreParedDao;
import backWeb.z01_vo.Jobs;

/**
 * Servlet implementation class A12_AjaxControllerJob
 */
@WebServlet(name = "job.do", urlPatterns = { "/job.do" })
public class A12_AjaxControllerJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A12_AjaxControllerJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		// 1. 요청
		String job_id=request.getParameter("job_id");
		if(job_id==null)job_id="";
		
		// 2. 모델 Dept
		A04_PreParedDao dao = new A04_PreParedDao();
		List<Jobs> jlist = dao.getJobs(job_id);
		
		// 3. json 뷰호출
		Gson g = new Gson();
		response.getWriter().print(g.toJson(jlist));
	}

}
