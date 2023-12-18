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
  <h2>로그인</h2>
  <form action="login.do" method="post" name="frm">
    <div class="form-group">
      <label for="userId">아이디:</label>
      <input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId">
    </div>
    <div class="form-group">
      <label for="pwd">암&nbsp;호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <button type="submit" class="btn btn-primary" onclick="return loginCheck()">로그인</button> &nbsp;
    <button type="reset" class="btn btn-secondary">취소</button> &nbsp;
	<h5 style="color:red">${message}</h5>
  </form>
</div>

</body>
</html>