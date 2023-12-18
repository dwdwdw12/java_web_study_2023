package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("=====init=====");			//접속 시 서블릿 객체 생성. 서버 동작 시 필요한 행동을 지정 가능
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");	//한글 깨짐 방지. 문서의 타입과 인코딩 지정.
		
		PrintWriter out = response.getWriter();
		
		out.println("Hello, Servlet");
		out.println("안녕, Servlet");	//한글은 깨져서 나옴
		
		System.out.println("=====doGet=====");		//요청이 올 때마다(새로고침) 동작
	}
	
	@Override
	public void destroy() {
		System.out.println("=====destroy=====");	//서버 종료시 동작. 필요한 행동(ex 저장) 지정 가능.
	}
	
}
