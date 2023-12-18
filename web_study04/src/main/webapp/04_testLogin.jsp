<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
String id = "test";
String pwd = "1234";
String name = "조조";

request.setCharacterEncoding("utf-8");

if(id.equals(request.getParameter("id"))){
	if(pwd.equals(request.getParameter("pwd"))){
		response.sendRedirect("04_main.jsp?name="+URLEncoder.encode(name,"utf-8"));	//name만 넘겨주면 한글 처리를 못함. error가 발생하며 빈 화면이 출력됨.
																					//영문은 상관없음. redirect 방식으로 처리할 때. 
	}
} else {
	response.sendRedirect("04_loginForm.jsp");
}
%>
