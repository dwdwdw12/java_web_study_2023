<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 설정</h3>
<%
	Cookie cookie = new Cookie("id", "gildong");

	cookie.setMaxAge(365*24*60*60);
	
	response.addCookie(cookie); 
	
	response.addCookie(new Cookie("pwd", "test1234"));	//직접 저장
	response.addCookie(new Cookie("age", "20"));
%>
</body>
</html>