<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h2>리스트</h2>
		<a href="movieWrite.do" class="btn btn-info float-right" >정보등록</a>
		
		<table class="table table-hover">
			<thead>
				<tr>
					<th>제목</th>
					<th>감독</th>
					<th>배우</th>
					<th>가격</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach var="movie" items="${movieList}">
					<tr>
						<td>${movie.title}</td>
						<td>${movie.director}</td>
						<td>${movie.actor}</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${movie.price}" />원</td>
						<%-- <td><fmt:formatNumber value="${product.price}" type="currency" />원</td> --%>
						<td><a href="movieUpdate.do?code=${movie.code}">정보 수정</a></td>
						<td><a href="movieDelete.do?code=${movie.code}">정보 삭제</a></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>

</body>
</html>