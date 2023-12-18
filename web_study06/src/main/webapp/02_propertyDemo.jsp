<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean><hr>
	
	<h2> 자바 빈 객체 생성 후 저장된 정보 출력하기 </h2>
	이름: <jsp:getProperty property="name" name="member"/> <br>
	아이디: <jsp:getProperty property="userId" name="member"/> <br>
	
	<h2> 정보 변경 후 변경된 정보 출력하기 </h2>
	<jsp:setProperty property="name" name="member" value="testName"/>
	<jsp:setProperty property="userId" name="member" value="testId"/>
	이름: <jsp:getProperty property="name" name="member"/> <br>
	아이디: <jsp:getProperty property="userId" name="member"/> <br>
	
</body>
</html>