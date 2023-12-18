package unit011;

import java.io.IOException;
import java.io.PrintWriter;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
@javax.servlet.annotation.WebServlet("/addition")
public class AdditionServlet001 {
	private static final long servletVersionUID = 1L;
	
	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response ) throws javax.servlet.ServletException, IOException {
		int num1 = 20;
		int num2 = 30;
		
		int add = num1 + num2;
		
		PrintWriter out = response.getWriter();	//출력
		out.println("<html><head><title>Addition</title></head>");
		out.println("<body>");
		out.println(num1 + "+" + num2 + "=" + add);
		out.println("</body>");
		out.println("</html>");
	}
//	
//	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
//		//doGet(request, response);
//	}
//	
}
