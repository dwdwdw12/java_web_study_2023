package unit04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String gender = request.getParameter("gender");
		String chk_mail = request.getParameter("chk_mail");
		String content = request.getParameter("content");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("당신이 입력한 정보입니다.<hr>");	//가로줄 삽입. </hr> 사용불가.
		out.println("셩별 : <b>");
		out.println(gender);
		out.println("</b></br> 메일 정보 수신 여부 : <b>");
		out.println(chk_mail);
		out.println("</b><br> 가입인사 : <b><pre>");	// 미리 정의된 형식(preformatted)의 텍스트를 정의
		out.println(content+"</br>");
		
		out.println("<a href='javascript:history.go(-1)'>다시</a>");	
		out.println("</body></html>");
		out.close();
		
	}

}
