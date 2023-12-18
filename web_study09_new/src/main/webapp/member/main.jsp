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
<script type="text/javascript" src="./script/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	
<div class="container">
  <h2>회원전용 페이지</h2> </br>
  <form action="logout.do" method="get">
	<h4>안녕하세요 ${loginUser.name}(${loginUser.userId})님</h4>  </br></br>
    <button type="submit" class="btn btn-primary">로그아웃</button> &nbsp;
	<button type="button" class="btn btn-success" 
		onclick="location.href='update.do?userId=${loginUser.userId}'">회원정보 변경</button> </br>
  </form>
</div>

</body>
</html>