<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*"%>
<%@ page import="javax.sql.DataSource"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>DB 연동</h3>
	
<%
	Context initContext = new InitialContext();
	Context envContext  = (Context)initContext.lookup("java:/comp/env");
	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	Connection conn = ds.getConnection();
	
	System.out.println("conn : " + conn);
	out.println("DBCP 연동 성공");
%>
	
</body>
</html>