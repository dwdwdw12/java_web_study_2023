<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="./script/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td>${loginUser.name} 님 반갑습니다</td>
					<td>레벨: ${loginUser.lev} </td>
					
					<c:choose>
						<c:when test="${not empty loginUser.id}">
							<td><a href="logout.do" style="color:black">로그아웃</a></td>
						</c:when>
						<c:otherwise>
							<td>로그인</td>			
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${loginUser.lev}=='A'">
							<td><a href="registration.do" style="color:black">로그아웃</a></td>
						</c:when>
						<c:otherwise>
							<td>사원등록<br>(관리자도 로그인 후 사용가능)</td>			
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${not empty loginUser.id}">
							<td><a href="mypage.do" style="color:black">마이페이지</a></td>
						</c:when>
						<c:otherwise>
							<td>마이페이지<br>(로그인 후 사용가능)</td>			
						</c:otherwise>
					</c:choose>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="container">
		<form action="mypage.do" method="post" name="frm">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td> <h1>마이페이지</h1> </td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" class="form-control" id="id" name="id" value=${empVo.id} readonly="readonly"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" class="form-control" id="pass" name="pass" ></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="form-control" id="name" name="name" value=${empVo.name}></td>
				</tr>
				<tr>
					<td>권한</td>
					<td>
					<select id="lev" name="lev">
						<option value="A">운영자</option>
						<option value="B">일반회원</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<select id="gender" name="gender">
							<option value="1">남자</option>
							<option value="2">여자</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" class="form-control" id="phone" name="phone" value=${empVo.phone}></td>
				</tr>
				<tr>					
					<td> <input type="submit" value="수정"> </td>
					<td> <input type="reset" value="취소"> </td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
	
</body>
</html>