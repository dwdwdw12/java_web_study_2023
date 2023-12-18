<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="04_testLogin.jsp">
		<label for="userId"> 아이디 : </label>
		<input type="text" name="id" id="userId">
		
		<label for="userPwd"> 비밀번호 : </label>
		<input type="password" name="pwd" id="userPwd">
		
		<input type="submit" value="로그인">
	</form>
	

</body>
</html>