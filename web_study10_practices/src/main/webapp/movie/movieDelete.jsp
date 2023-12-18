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
		<h2>정보 삭제</h2>
		<form action="movieDelete.do" method="post" name="frm">
			<input type="hidden" name="code" value="${movie.code}">
			<input type="hidden" name="nonmakeImg" value="${movie.poster}">

			<c:choose>
				<c:when test="${empty movie.poster}">
					<img src="upload/noimage.gif" width="200" height="300">
				</c:when>
				<c:otherwise>
					<img src="upload/${movie.poster}" width="200" height="300">
				</c:otherwise>
			</c:choose>
			
			<div class="form-group">
				<label for="name">제목</label> 
				<input type="text" class="form-control" id="name" name="name" value="${movie.title}" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="price">가격</label> 
				<input type="text" class="form-control" id="price" name="price" value="${movie.price}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="director">감독</label> 
				<input type="text" class="form-control" id="director" name="director" value="${movie.director}" readonly="readonly">
			</div>

			<div class="form-group">
				<label for="actor">배우</label> 
				<input type="text" class="form-control" id="actor" name="actor" value="${movie.actor}" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="synopsis">설명</label><br> 
				<textarea rows="10" cols="80" name="synopsis" readonly="readonly">${movie.synopsis}</textarea>
			</div>
			
			<div class="form-group">
				<label for="poster">사진</label> 
				<input type="text" class="form-control" id="poster" name="poster" value="${movie.poster}" readonly="readonly"><br>
			</div>
		
			<button type="submit" class="btn btn-primary">삭제</button> &nbsp;
			<button type="button" class="btn btn-success" onclick="location.href='movieList.do'">목록</button> &nbsp;
		</form>
	</div>

</body>
</html>