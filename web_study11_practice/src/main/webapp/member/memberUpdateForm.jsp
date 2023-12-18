<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>

	<div id="wrap" align="center">
		<h1>게시글 수정</h1>
		<form action="MemberServlet" name="frm" method="post">
			<input type="hidden" name="command" value="member_update">
			<input type="hidden" name="custno" value="${member.custno}">	
			
			<table>
				<tr>
					<th>회원번호</th>
					<td><input type="text" name="custno" value="${member.custno}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" value="${member.custname}"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" value="${member.phone}"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" value="${member.address}"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate" value="${member.joindate}" readonly="readonly"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP, B:일반, C:직원]</th>
					<td><input type="text" name="grade" value="${member.grade}"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" value="${member.city}"></td>
				</tr>			
			</table>
			<br><br>
			<input type="submit" value="등록" onclick="return boardCheck()">
			<input type="button" value="목록" onclick="location.href='http://localhost:8181/web_study11_practice/MemberServlet?command=member_list'">
		</form>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>