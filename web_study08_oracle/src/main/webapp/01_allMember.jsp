<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! //선언부는 첫 방문자에 의해 단 한번 수행됨
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	String sql = "select * from member";
%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="800" border="1">
		<tr>
			<th>이름</th><th>아이디</th><th>암호</th><th>이메일</th>
			<th>전화번호</th><th>권한(1:관리자, 0:일반회원)</th>
		</tr>
	<%
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);	//접속
			stmt = conn.createStatement();	//statement 객체 생성. 아래 메서드 사용 가능(sql 표준 쿼리문을 수행하기 위해).
			rs = stmt.executeQuery(sql);	//실행
			while(rs.next()){	//t,f
				out.println("<tr>");
				out.println("<td>" + rs.getString("name")+"</td>");
				out.println("<td>" + rs.getString("userid")+"</td>");
				out.println("<td>" + rs.getString("pwd")+"</td>");
				out.println("<td>" + rs.getString("email")+"</td>");
				out.println("<td>" + rs.getString("phone")+"</td>");				
				out.println("<td>" + rs.getInt("admin")+"</td>");
				out.println("</tr>");
			}
		} catch(Exception e) {
			e.getMessage();
		} finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();	//열어준 순서의 반대로 닫아야 함
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	%>		
	</table>

</body>
</html>