<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
  <h2>회원정보 수정</h2> </br>
  <form action="update.do" method="post" name="frm">
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" value=${mVo.name}>
    </div>
    <div class="form-group">
      <label for="userId">아이디:</label> 
      <input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId" value=${mVo.userId} readonly="readonly">
    </div>
    <div class="form-group">
      <label for="pwd">암&nbsp;호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    <div class="form-group">
      <label for="pwd_check">암&nbsp;호 확인:</label> 
      <input type="password" class="form-control" id="pwd_check" placeholder="Enter password" name="pwd_check">
    </div>
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value=${mVo.email}>
    </div>
    <div class="form-group">
      <label for="phone">전화번호:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone" value=${mVo.phone}>
    </div>
    <c:if test="${mVo.admin==0 }">
    <div class="form-group">
    	<label for="admin">등급:</label>				<!-- 해당 radio에 체크 -->
    	<input type="radio" name="admin" value="0" checked="checked">일반회원
    	<input type="radio" name="admin" value="1">관리자
    </div>
    </c:if>			<!-- c choose->when test...=>사용가능 -->
    <c:if test="${mVo.admin==1 }">
    <div class="form-group">
    	<label for="admin">등급:</label>
    	<input type="radio" name="admin" value="0" >일반회원
    	<input type="radio" name="admin" value="1" checked="checked">관리자
    </div>
    </c:if>
    <button type="submit" class="btn btn-primary" onclick="return joinCheck()">확인</button> &nbsp; <!-- p500 유효성 체크 자바스크립트 함수 참고 -->
    <button type="reset" class="btn btn-secondary">취소</button> &nbsp;
  </form>
</div>

</body>
</html>