<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>
	
	<h3> 자바 빈 객체 행성 후 저장된 정보 출력하기 </h3>
	
	이름 : <%=member.getName() %> </br>
	아이디 : <%=member.getUserId() %>
	
	<h3> 정보 변경 후 변경된 정보 출력하기 </h3>
	
	<%
		member.setName("홍길동");
		member.setUserId("test");
	%>
	
	이름 : <%=member.getName() %> </br>
	아이디 : <%=member.getUserId() %>
	
</body>
</html>