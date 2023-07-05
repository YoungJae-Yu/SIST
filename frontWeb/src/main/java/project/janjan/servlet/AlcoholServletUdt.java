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
public class AlcoholServletUdt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlcoholServletUdt() {
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
		String title = request.getParameter("title");
		String refno = request.getParameter("refno");
		String ordno = request.getParameter("ordno");
		String val = request.getParameter("val");
		String prdno = request.getParameter("prdno");
		String prn = "N";
		if(title!=null) {
			Admin adm = new Admin(
					Integer.parseInt(prdno),
						title,
						val,
						Integer.parseInt(refno),
						Integer.parseInt(ordno)
			);
			AdminDao dao = new AdminDao();
			dao.updateAS(adm);
			prn = "Y";
		}
		response.getWriter().print(prn);
	}

}
