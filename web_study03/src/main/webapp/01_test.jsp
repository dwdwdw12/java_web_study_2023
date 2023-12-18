<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int num1 = 20;
	int num2 = 10;
	int add = num1 + num2;
	
	List<Integer> numlist = new ArrayList<>();
	
	out.println(num1 + "+" + num2 + "=" + add);	//out : 내장객체, 객체를 선언하지 않아도 사용 가능
	
	Calendar date = Calendar.getInstance();		//싱글톤
	
	SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");	//대소문자 구분 주의
	out.println(date);	//raw data 출력
	out.println(today.format(date.getTime()));
%>
</body>
</html>