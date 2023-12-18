<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="upload.do" method="post" enctype="multipart/form-data">
		글쓴이 : <input type="text" name="name"><br>
		제목 : <input type="text" name="title"><br>
		파일 저장 : <input type="file" name="uploadFile"><br>
		<input type="submit" value="전송">
	</form>

</body>
</html>