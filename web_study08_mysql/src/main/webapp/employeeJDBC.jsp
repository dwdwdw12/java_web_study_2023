<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->

<%!
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "scott";
	String pass = "tiger";
	
	String sql = "select * from employee";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="800" border="1">
		<%
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,uid,pass);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){	//t,f
				out.println("<tr>");
				out.println("<td>" + rs.getString("name")+"</td>");
				out.println("<td>" + rs.getString("address")+"</td>");
				out.println("<td>" + rs.getString("ssn")+"</td>");
				out.println("</tr>");
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				ps.close();
				conn.close();
			} catch(Exception e){
				e.printStackTrace();
			} 
		}
		
		%>
	</table>

</body>
</html>