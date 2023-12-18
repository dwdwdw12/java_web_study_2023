<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
 td{
 	border: 1px solid black;
 	width: 200px;
 	text-align: center;
 }
 table.mainmenu td.login:HOVER{
    background-color: pink;
 }
 
</style>
</head>
<body>
	<h1 style="background-color: blue; color:white" align="center">쇼핑몰 회원관리 ver1.0</h1>

	<!-- Grey with black text -->
	<nav class="navbar navbar-expand-sm bg-primary navbar-dark" >
	<ul class="navbar-nav" >
		<li class="nav-item active"><a class="nav-link" href="http://localhost:8181/web_study11_practice/MemberServlet?command=member_write-form">회원등록</a></li>
		<li class="nav-item active"><a class="nav-link" href="http://localhost:8181/web_study11_practice/MemberServlet?command=member_list">회원목록조회/수정</a></li>
		<li class="nav-item active"><a class="nav-link" href="http://localhost:8181/web_study11_practice/MemberServlet?command=member_sales">회원매출조회</a></li>
		<li class="nav-item active"><a class="nav-link" href="#">홈으로</a></li>
		</li>
	</ul>
	</nav>

</body>
</html>