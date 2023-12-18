<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
					<td></td>
					<td></td>
					<td>로그인</td>			
					<td>사원등록<br>(관리자도 로그인 후 사용가능)</td>			
					<td>마이페이지<br>(로그인 후 사용가능)</td>			
				</tr>
			</tbody>
		</table>
	</div>


	<div class="container">

		<form action="login.do" method="post" name="frm">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><h1>로그인</h1></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<div class="form-group">
								 <input type="text"	class="form-control" id="id" name="id">
							</div>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>
							<div class="form-group">
								 <input type="password"	class="form-control" id="pass" name="pass">
							</div>
						</td>
					</tr>
					<tr>
						<td>레벨</td>
						<td>
							<select id="lev" name="lev">
								<option value="A">운영자</option>
								<option value="B">일반회원</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="로그인" onclick="return loginCheck()" >
							<input type="reset" value="취소">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	${message}

</body>
</html>