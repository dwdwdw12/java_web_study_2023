<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2> 고전적인 방식 </h2>
	아이디 : <%= request.getParameter("id") %> </br>
	비밀번호 : <%= request.getParameter("pwd") %> </br></br>
	
	<h2> EL 방식 </h2>
	아이디 : ${param.id }	</br>
	비밀번호 : ${param["pwd"] } </br>
	비밀번호 : ${param.pwd } </br>
	param : ${param } </br>	<!-- 배열 형식으로 출력. -->
	
</body>
</html>