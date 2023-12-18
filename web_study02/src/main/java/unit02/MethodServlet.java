package unit02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Method")
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("id");
//		String age = request.getParameter("age");		
		int age =  Integer.parseInt(request.getParameter("age"));		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>get방식으로 처리</h1>");
		out.println("이름 : " + name + "</br>");
		out.println("나이 : " + age);
		
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");	//큰 따옴표 안에는 작은 따옴표를 사용하기.
																		//뒤로 가기
		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>post방식으로 처리</h1>");
		
		out.close();
	}

}
