<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->

<%!
	Connection conn = null;
	PreparedStatement ps = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	
	String sql = "insert into item values(?, ?, ?)";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>입력완료된 정보</h3>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String price = request.getParameter("price");
	String description = request.getParameter("description");
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, uid, pass);
		ps = conn.prepareStatement(sql);

		ps.setString(1, name);
		ps.setString(2, price);
		ps.setString(3, description);

		ps.executeUpdate();	
	} catch(Exception e) {
		e.printStackTrace();
	} finally{
		try{
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	out.println("이름 : " + name + "</br>");
	out.println("가격 : " + price+ "</br>");
	out.println("설명 : " + description+ "</br>");
%>

</body>
</html>