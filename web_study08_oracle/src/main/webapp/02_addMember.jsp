<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->

<%!
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	
	String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String userid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String admin = request.getParameter("admin");
	
	try{
		//1단계 jdbc 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2단계 데이터베이스 연결 객체인 Connection 생성
		conn = DriverManager.getConnection(url, uid, pass);
		//3단계 preparedStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		//4단계 바인딩 변수를 채운다 insert into member values(?, ?, ?, ?, ?, ?)에 매핑
		pstmt.setString(1, name);
		pstmt.setString(2, userid);
		pstmt.setString(3, pwd);
		pstmt.setString(4, email);
		pstmt.setString(5, phone);
		pstmt.setInt(6, Integer.parseInt(admin)); //정수형으로 바꾸어주기
		//5단계 SQL문을 실행하여 결과 처리
		pstmt.executeUpdate();	//정수를 반환, 실행된 행의 숫자(0~n)
	} catch(Exception e) {
		e.printStackTrace();
	} finally{
		//6단계 사용한 리소스 해제
		try{
			if(pstmt !=null) pstmt.close();
			if(conn !=null) conn.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
%>

<h3>회원가입 성공</h3>
<a href="01_allMember.jsp">전체 회원 목록 보기</a>

</body>
</html>