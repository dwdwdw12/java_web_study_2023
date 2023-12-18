<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<h1>회원조회 및 수정</h1>
		<table class="list">
			<tr>
				<td colspan="3" style="boarder:white; text-align:left">
					<a href="MemberServlet?command=member_sales">매출 조회</a>
				</td>
				<td colspan="4" style="boarder:white; text-align:right">
					<a href="MemberServlet?command=member_write-form">회원 등록</a>
				</td>
			</tr>
			<tr>
				<th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th> 
			</tr>
			<c:forEach items="${memberSalesList}" var="member">
				<tr class="record">
					<td><a href="MemberServlet?command=member_update_form&custno=${member.custno}" style="color:blue">${member.custno}</a></td>
					<td>${member.custname}</td>
					
					<c:if test="${member.grade=='A'}">
						<td>VIP</td>
					</c:if>
					<c:if test="${member.grade=='B'}">
						<td>일반</td>
					</c:if>
					<c:if test="${member.grade=='C'}">
						<td>직원</td>
					</c:if>
						
					
					<td>${member.sum}</td>
				</tr>
			</c:forEach>
			
		</table>

	</div>

<%@ include file="footer.jsp" %>
</body>
</html>