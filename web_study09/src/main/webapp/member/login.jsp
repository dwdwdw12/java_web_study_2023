<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript" src="../script/member.js"></script>
									<!-- 경로 설정 주의하기 -->
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>	<!-- class="form"  get/post-->
	<form action="login.do" method="post" name="frm">
		<label for="userId">아이디:</label> 
		<input type="text"	class="form-control" id="userId" placeholder="Enter userId" name="userId"> </br> 
		<label for="pwd">암호:</label> 
		<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd"> </br>
		${message} </br></br>
		<button type="submit" class="btn btn-primary" onclick="return logInCheck()">로그인</button> &nbsp;
		<button type="reset" class="btn btn-danger">취소</button> &nbsp; 
		<button type="submit" class="btn btn-info" onclick="location.href='join.do'">회원가입</button> &nbsp; </br>
		
	</form>

</body>
</html>