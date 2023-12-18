<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"타이타닉", "시네마 천국", "혹성탈출", "킹콩"};
	request.setAttribute("movieList", movieList);
%>
	<c:forEach items="${movieList }" var="movie">
		${movie } </br>
	</c:forEach>
	
	<hr>
	index count  movie <br>
									<!-- value값   index, count를 보고 싶을 때-->
	<c:forEach items="${movieList }" var="movie" varStatus="status">
		${status.index } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		${status.count } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		${movie } </br>		
	</c:forEach>
	
	<hr>
	<c:forEach items="${movieList }" var="movie" varStatus="status">
		${status.first }<br>
		${status.last }<br>
	</c:forEach>	<!-- 첫번째 데이터인지, 마지막 데이터인지 판단(t/f)  -->
	
	<hr>
	<c:forEach items="${movieList }" var="movie" varStatus="status">
		<c:if test="${status.first }">
			${movie } </br>	
		</c:if>
		<c:if test="${status.last }">
			${movie } </br>	
		</c:if>
	</c:forEach>	<!-- 조건문에 응용 -->
	
</body>
</html>