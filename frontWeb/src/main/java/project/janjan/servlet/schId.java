package project.janjan.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project.janjan.DAO.MemberDao;
import project.janjan.VO.Member;

/**
 * Servlet implementation class schId
 */
@WebServlet("/schId")
public class schId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public schId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		if(name==null)name="";
		String contact = request.getParameter("contact");
		if(contact==null)contact="";
		String prn = "";
		Member ins = new Member(contact);
		MemberDao dao = new MemberDao();
		prn = dao.schId(name,contact);
		response.getWriter().print(prn);
	}
}
