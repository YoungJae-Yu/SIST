package backWeb.a01_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import backWeb.a01_dao.A04_PreParedDao;
import backWeb.z01_vo.Salgrade;

/**
 * Servlet implementation class A08_AjaxController1
 */
@WebServlet(name = "prodCalcu.do", urlPatterns = { "/prodCalcu.do" })
public class A08_AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A08_AjaxController() {
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
        String price = request.getParameter("price");
        if(price==null || price.equals(""))price="0";
        String cnt = request.getParameter("cnt");
        if(cnt==null || cnt.equals(""))cnt="0";
        int tot = Integer.parseInt(price)*Integer.parseInt(cnt);
        
        
        
//        // 1. 요청값
//        String discount = request.getParameter("discount");
//        if(discount==null || discount.equals(""))discount="0";
//        int discountPrice = Integer.parseInt(price)*Integer.parseInt(discount)/100;
       
        // 1. 요청값
        String grade = request.getParameter("grade");
        if(grade==null || grade.equals(""))grade="0";
        // 2. 모델데이터
        A04_PreParedDao dao = new A04_PreParedDao();
        Salgrade s = dao.getSalgrade(grade);
        // 3. 화면호출(jsp/json출력)
		Gson g = new Gson();
		response.getWriter().print(g.toJson(s));
        
        
        // 3. 화면호출(jsp/json출력)
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;utf-8");
		if(!price.equals("")) {
			response.getWriter().print("가격 : "+price+", 갯수 : "+cnt+", 합산 : "+ tot);
		}else {
			response.getWriter().print("가격과 갯수를 입력하세요.");
			
			
			
			
//			// 3. 화면호출(jsp/json출력)
//			if(!price.equals("")) {
//				response.getWriter().print("가격 : "+price+", 할인율(%) : "+discount+", 합산 : "+ discountPrice);
//			}else {
//				response.getWriter().print("가격과 할인율을 입력하세요.");
//		}
	}

	}
}
