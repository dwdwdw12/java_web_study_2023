<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로드북 페이지로 이동</h1>
	
	<%= request.getParameter("name") %><br>		<!-- 페이지 상의 정보를 바로 받아올 수 있음 -->
	<%= request.getParameter("age") %><br>		<!-- http://localhost:8181/web_study04/03_redirect.jsp?name=park&age=20 -->
	
	<%
		//response.sendRedirect("http://www.roadbook.com");
	%>
	
	
</body>
</html>