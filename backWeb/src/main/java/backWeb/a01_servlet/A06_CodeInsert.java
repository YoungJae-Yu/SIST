package backWeb.a01_servlet;

import java.io.IOException;

import backWeb.a01_dao.A04_PreParedDao;
import backWeb.z01_vo.Code;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A06_CodeInsert
 */
public class A06_CodeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A06_CodeInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 한글 encoding
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String refno = request.getParameter("refno");
		String ordno = request.getParameter("ordno");
		String val = request.getParameter("val");
		String prn="N";
		//'기획',1006,5,50
		// ?title=기획&refno=1006&ordno=5&val=50
		System.out.println(title);
		System.out.println(refno);
		System.out.println(ordno);
		System.out.println(val);
		if(title!=null) {
			Code ins = new Code(
				0,
				title,
				val,
				Integer.parseInt(refno),
				Integer.parseInt(ordno));
			A04_PreParedDao dao = new A04_PreParedDao();
			
			dao.insertCode(ins);
			prn="Y";
		}
		response.getWriter().print(prn);
	}
}
