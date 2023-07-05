package backWeb.a01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A09_AjaxController
 */
@WebServlet(name = "buyProduct.do", urlPatterns = { "/buyProduct.do" })
public class A09_AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A09_AjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ex) A09_AjaxController.java
		//  요청값 : 물건명을 넘기고, 화면 구매한 물건 : @@@
		// 요청값 없으면"없네여"출력
        // 1. 요청값
        String prod = request.getParameter("pname");
        if(prod==null)prod="";
        // 2. 모델데이터
        
        // 3. 화면호출(jsp/json출력)
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		if(!prod.equals("")) {
			response.getWriter().print("구매한 물건 : "+prod);
		}else {
			response.getWriter().print("구매한 물건 : 없네요");
		}
		// A10_AjaxController.java
		// mname=행복한노래&singer=홍길동&pubuyear=2001
		// Music에 넘겨서
		// Json데이터로 위 내용을 json 객체로 출력하게 처리.
	}

}
