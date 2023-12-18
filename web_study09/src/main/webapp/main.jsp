<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>메인 페이지</h1>
	<h3>안녕하세요 ${loginUser.name}(${loginUser.userId})님</h3>
	<button type="submit" class="btn btn-primary">로그아웃</button> &nbsp;
	<button type="button" class="btn btn-danger" 
			onclick="location.href='memberUpdate.do?userId=${loginUser.userId}'">회원정보변경</button> &nbsp; 

</body>
</html>