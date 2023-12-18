<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> 세션 값 얻어오기</h3>
	<%
		String id = (String)session.getAttribute("id");	//object 타입으로 반환됨
		String pwd = (String)session.getAttribute("pwd");	
		Integer age = (Integer)session.getAttribute("age");	
		//Integer age2 = Integer.parseInt((String)session.getAttribute("age2"));	
	%>
	
	id : <%=id %> <br>
	pwd : <%=pwd %> <br>
	age : <%=age %> <br>
	<%-- age2 : <%=age2 %> --%>

</body>
</html>