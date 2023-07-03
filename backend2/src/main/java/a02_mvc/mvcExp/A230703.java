package a02_mvc.mvcExp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backWeb.a01_dao.*;

/**
 * Servlet implementation class A230703
 */
@WebServlet("/A230703")
public class A230703 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A230703() {
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
		// 없음.
		
		// 2. 모델 데이터
		A05_MemberDao dao = new A05_MemberDao();
		request.setAttribute("memList", dao.mlist());
		
		// 3.view단(jsp) 호출
		String page = "230703.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
