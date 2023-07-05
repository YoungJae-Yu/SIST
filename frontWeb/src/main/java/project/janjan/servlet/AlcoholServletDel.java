package project.janjan.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.janjan.DAO.AdminDao;
import project.janjan.VO.Admin;

/**
 * Servlet implementation class AlcoholServlet
 */
public class AlcoholServletDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlcoholServletDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ?title=매실원주&refno=6&ordno=1&val=매실원주
		request.setCharacterEncoding("utf-8");
		String prdno = request.getParameter("prdno");
		String prn = "N";
		if(prdno!=null) {
			AdminDao dao = new AdminDao();
			dao.deleteAS(Integer.parseInt(prdno));
			prn = "Y";
		}
		response.getWriter().print(prn);
	}

}
