<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/member.js"></script>
<title>Insert title here</title>
</head>
<body>

	<h3>아이디 중복체크</h3>
	
	<form action="idCheck.do" method="get" name="frm">
		아이디<input type="text" name="userId" value="${userId}">
		<input type="submit" value="중복체크">
		<br>
		
		<c:if test="${result==1}">
			<script type="text/javascript">
				opener.document.frm.userId.value="";
			</script>
			${userId}는 이미 사용중인 아이디입니다.
		</c:if>
		
		<c:if test="${result==-1}">
			${userId}는 사용 가능한 아이디입니다.
			<input type="button" value="사용" class="cancel" onclick="idOk()">
		</c:if>
		
	</form>

</body>
</html>