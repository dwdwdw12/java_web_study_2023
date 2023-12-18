<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="param.js"></script>
</head>
<body>
	<!-- <form action="Param" method="post" name="frm">
		아이디 : <input type="text" name="id"></br>
		나&nbsp;&nbsp;이 : <input type="text" name="age"></br>
		비밀번호 : <input type="password" name="pwd"></br>
		<input type="submit" value="전송" onclick="return check()">
	</form>	 -->							  <!-- javascript 함수 호출 -->
	
	<form action="Param" method="post" name="frm">
		<label for=id> 아이디 :</label>
		<input type="text" name="id" id="id"></br>
		
		<label for=age> 나이 :</label>
		<input type="text" name="age" id="age"></br>
		
		비밀번호 : <input type="password" name="pwd"></br>
		
		내용 </br> <textarea rows="3" cols="20"></textarea></br>
		
		<input type="submit" value="전송" onclick="return check()"></br></br>
	</form>
	
	<h5>--------------------------------------------------------</h5>
	
	<form action="RadioServlet" method="get">
		<label for="gender"> 성별 : </label>
		<input type="radio" id="gender" name="gender" value="남자" checked> 남자
		<input type="radio" id="gender" name="gender" value="여자"> 여자 </br>
		
		<label for="chk_mail"> 메일 정보 수신 여부 : </label>
		<input type="radio" id="chk_mail" name="chk_mail" value="yes" checked> 수신
		<input type="radio" id="chk_mail" name="chk_mail" value="no"> 거부 </br> </br>
		
		<label for="content"> 간단한 가입 인사를 적어주세요</label></br>
		<textarea id="content" name="content" rows="3" cols="35"></textarea> </br>
		<input type="submit" value="전송">
	</form>
</body>
</html>