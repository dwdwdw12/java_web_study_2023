<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	String age = request.getParameter("age");
	String name1 = (String)request.getAttribute("name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	
	forward 방식으로 이동된 페이지 </br>

	나이 : <%=age %>	</br>
	이름1 : <%=name1 %> </br>
	이름2 : <%=request.getAttribute("name") %> </br>
	이름3 : ${name}	<!-- attribute로 지정해주어야 EL 표기법으로 출력 가능 -->
	
</body>
</html>