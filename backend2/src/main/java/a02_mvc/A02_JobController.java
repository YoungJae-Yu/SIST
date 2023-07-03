package a02_mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backWeb.a01_dao.A04_PreParedDao;
import java.util.*;
/**
 * Servlet implementation class A02_JobController
 */
@WebServlet(name = "joblist.do", urlPatterns = { "/joblist.do" })
public class A02_JobController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A02_JobController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청값 한글 encoding 처리
		request.setCharacterEncoding("utf-8");
		// 1. 요청값 처리
		String title = request.getParameter("title");
		if(title==null)title="";
		String min_sal1 = request.getParameter("min_sal1");
		if(min_sal1==null)min_sal1="0";
		String min_sal2 = request.getParameter("min_sal2");
		if(min_sal2==null)min_sal2="999999";
		Map<String, String> sch = new HashMap<String, String>();
		sch.put("title",title);
		sch.put("min_sal1", min_sal1);
		sch.put("min_sal2",min_sal2);
		
		// 2. 모델 데이터
		A04_PreParedDao dao = new A04_PreParedDao();
		request.setAttribute("jobList", dao.getJob(sch));
		
		// 3.view단(jsp) 호출
		String page = "a11_jobListSch.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
