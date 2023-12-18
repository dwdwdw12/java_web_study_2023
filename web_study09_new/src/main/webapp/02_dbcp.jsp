<%@page import="com.saeyan.dao.MemberDAO"%>
<%@page import="java.sql.Connection"%>
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

<%
			//DB와 연동할 목적
	MemberDAO mDao = MemberDAO.getInstance();
	Connection conn = mDao.getConnection();
	
	out.println("conn : " + conn);
	
%>

</body>
</html>