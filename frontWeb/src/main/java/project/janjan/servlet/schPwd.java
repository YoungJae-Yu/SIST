package project.janjan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project.janjan.DAO.MemberDao;
import project.janjan.VO.Member;

import java.io.IOException;

/**
 * Servlet implementation class schPwd
 */
public class schPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public schPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		if(id==null)id="";
		String contact = request.getParameter("contact");
		if(contact==null)contact="";
		String prn = "";
		Member ins = new Member(id,contact);
		MemberDao dao = new MemberDao();
		prn = dao.schPwd(id,contact);
		                             response.getWriter().print(prn);
	}
}
