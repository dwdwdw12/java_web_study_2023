<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>
<jsp:setProperty name="member" property="*"/>
							<!--파라미터를 한번에 저장하기. 필드명이 일치하는지 잘 확인 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 입력 완료된 회원 정보 </h2>
	이름: <jsp:getProperty property="name" name="member"/><br>
	아이디: <jsp:getProperty property="userId" name="member"/><br>
	별명: <jsp:getProperty property="nickname" name="member"/><br>
	비밀번호: <jsp:getProperty property="pwd" name="member"/><br>
	이메일: <jsp:getProperty property="email" name="member"/><br>
	전화번호: <jsp:getProperty property="phone" name="member"/><br>
	<hr>
	이름 : <%=member.getName() %>
	아이디 : <%=member.getUserId() %>
	
	
</body>
</html>