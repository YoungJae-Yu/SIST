package project.janjan.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.janjan.DAO.AdminDao;
import project.janjan.VO.Admin;

/**
 * Servlet implementation class SnackServlet
 */
@WebServlet("/SnackServletDel")
public class SnackServletDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnackServletDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String prdnoS = request.getParameter("prdno");
		int prdno = 0; 
		if(prdnoS!=null) prdno=Integer.parseInt(prdnoS);
		String prn = "N";
		if(prdno!=0) {
			AdminDao dao = new AdminDao();
			dao.deleteAS(prdno);
			prn = "Y";
		}
		response.getWriter().print(prn);
	}

}
