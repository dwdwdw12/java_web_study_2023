<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 서블릿 파일의 @WebServlet("/Method")와 같은 주소를 취하기 -->
	<!-- 클릭 시 해당 주소를 찾아감. -->
	<form action="Method" method="get">
		name<input type="text" name="id"> </br>
		age <input type="text" name=age>  </br>
		<input type="submit" value="get 방식으로 호출하기">
	</form>
	<!-- input의 name 속성에는 따옴표가 필요없음 -->
	
	<form action="Method" method="post">
		<input type="submit" value="post 방식으로 호출하기">
	</form>
	
</body>
</html>