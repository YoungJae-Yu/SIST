package backWeb.a01_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class A04_Servlet_html
 */
public class A04_Servlet_html extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A04_Servlet_html() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		// 2. html코드를 처리하기 위한 설정
		response.setContentType("text/html;charset=utf-8");
		// 3. Stream으로 출력 처리하는 객체..
		PrintWriter out = response.getWriter();
		out.print("<style>td{text-align:center;width: 33%;}</style>");
		out.print("<script>function call(ob){ob.style.background='pink';}</script>");
		out.print("<h2>3X3 테이블</h2>");	
		out.print("<table width='300pt' height='300pt' border>");
		for(int cnt=1;cnt<=9;cnt++) {
			if(cnt%3==1) out.print("<tr>");
			out.print("<td onclick='call(this)'>"+cnt+"</td>");
			if(cnt%3==0) out.print("</tr>");
		}
		out.print("</table>");
		// 5. servlet에서 반복문으로 7가지 무지개 색 h2를 만드세요
		String color[] = {"red","orange","yellow","green","blue","navy","Purple"};
		for(int cnt=0;cnt<=6;cnt++) {
			out.print("<h2 style='color:"+color[cnt]+"'>"+color[cnt]+"</h2>");
		}
		// 6. servlet에서 4X4테이블로 클릭시 @@번호 안녕하세요가 alert으로 로딩되게 하세요.
		out.print("<style>td{text-align:center;width: 25%;}</style>");
		out.print("<h2>4X4 테이블</h2>");	
		out.print("<table width='300pt' height='300pt' border>");
		int cnt = 0;
		for(cnt=1;cnt<=16;cnt++) {
			if(cnt%4==1) out.print("<tr>");
			out.print("<td onclick='call("+cnt+")'>"+cnt+"</td>");
			if(cnt%4==0) out.print("</tr>");
			
		}
		out.print("<script>function call(td){alert(td);}</script>");
		out.print("</table>");
		
		
		out.close();
	}

}
