package backWeb.a01_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A03_Servlet_hrml
 */
public class A03_Servlet_hrml extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A03_Servlet_hrml() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 0. response : clientd에 전달하는 객체
		// 1. 한글 코드에 넣기 위해 설정
		// 	전달할 때, 한글 encoding방식 중에 utf-8방식으로 처리
		response.setCharacterEncoding("utf-8");
		// 2. html코드를 처리하기 위한 설정
		response.setContentType("text/html;charset=utf-8");
		// 3. Stream으로 출력 처리하는 객체..
		PrintWriter out = response.getWriter();
		for(int cnt=1;cnt<=10;cnt++) {
			out.print("<h2>"+cnt+"번째 안녕하세요</h2>");
		}
		// 4. 생성 후 , Stream 객체 해제
		out.close();
		//ex) A04_Servlet_html.java 를 만들고,
		// 3X3 테이블에 번호가 들어간 화면을 출력
	}

}
