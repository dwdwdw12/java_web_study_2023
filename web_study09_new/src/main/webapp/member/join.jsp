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
  <h2>회원가입</h2> </br>
  <form action="join.do" method="post" name="frm">
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
    </div>
    <div class="form-group">
      <label for="userId">아이디:</label> 
      <input type="button" value="중복체크"  class="btn btn-info btn-sm float-right" onclick="idCheck()">
      <input type="text" class="form-control" id="userId" placeholder="Enter userId" name="userId">
      <input type="hidden" name="reId">	<!-- 화면 상에는 보이지 않지만 전송은 됨 -->
      					   <!-- 중복체크 여부를 확인하기 위해서. idCheck->member.js의 idOK()를 통해 reId에 값이 입력됨. -->
      					   <!-- member.js의 joinCheck()를 통해 reId의 길이가 0인지 확인. 0이라면 확인 메세지 출력, 아니라면 true, 회원가입 진행가능 -->
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
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
      <label for="phone">전화번호:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
    </div>
    <div class="form-group">
    	<label for="admin">등급:</label>
    	<input type="radio" name="admin" value="0" checked="checked">일반회원
    	<input type="radio" name="admin" value="1">관리자
    </div>
    <button type="submit" class="btn btn-primary" onclick="return joinCheck()">확인</button> &nbsp; <!-- p500 유효성 체크 자바스크립트 함수 참고 -->
    <button type="reset" class="btn btn-secondary">취소</button> &nbsp;
  </form>
</div>

</body>
</html>