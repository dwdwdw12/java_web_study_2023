package unit03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Param")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		PrintWriter out = response.getWriter();	//가능하면 out을 변수명으로.
		
		out.println("<h1>회원정보</h1>");
		out.println("id : " + id + "</br>");
		out.println("age : " + age + "</br>");
		out.println("</br>");
		
		out.println("<a href='javascript:history.go(-1)'>뒤로가기</a>");	//뒤로 가기
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //post방식. get 방식은 자동으로 입력되어있음.
											   //요청시에 한글이 있다면 변환.
		doGet(request, response);	//한글 처리만 한 뒤, doGet()으로 처리.
									//forward 방식
		
//		response.setContentType("text/html; charset=utf-8");	//응답시에 꼭 입력
//		
//		String id = request.getParameter("id");
//		int age = Integer.parseInt(request.getParameter("age"));
//		
//		PrintWriter out = response.getWriter();	//가능하면 out을 변수명으로.
//		
//		out.println("<h1>회원정보</h1>");
//		out.println("id : " + id + "</br>");
//		out.println("age : " + age + "</br>");
//		out.println("</br>");
//		
//		out.println("<a href='javascript:history.go(-1)'>뒤로가기</a>");	//뒤로 가기
//		out.close();
	}

}
