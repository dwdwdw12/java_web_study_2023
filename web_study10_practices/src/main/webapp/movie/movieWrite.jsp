<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
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
		<h2>영화 정보 등록</h2>
		<form action="movieWrite.do" method="post" enctype="multipart/form-data" name="frm">
			<div class="form-group">
				<label for="title">제목</label> 
				<input type="text" class="form-control" id="title" name="title">
			</div>
			
			<div class="form-group">
				<label for="price">가격</label> 
				<input type="text" class="form-control" id="price" name="price">
			</div>

			<div class="form-group">
				<label for="director">감독</label> 
				<input type="text" class="form-control" id="director" name="director">
			</div>

			<div class="form-group">
				<label for="actor">배우</label> 
				<input type="text" class="form-control" id="actor" name="actor">
			</div>
			
			<div class="form-group">
				<label for="synopsis">설명</label><br> 
				<textarea rows="10" cols="80" name="synopsis" ></textarea>
			</div>
			
			<div class="form-group">
				사진: <input type="file" id="poster" name="poster"><br>
			</div>
		
			<button type="submit" class="btn btn-primary">확인</button> &nbsp;
			<button type="reset" class="btn btn-info">취소</button> &nbsp;
			<button type="button" class="btn btn-success" onclick="location.href='movieList.do'">목록</button> &nbsp;
		</form>
	</div>

</body>
</html>