<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int age = Integer.parseInt(request.getParameter("age"));
	
	if(age<19){
%>
	<h2>미성년자</h2>
	<script> 
		alert("19세 미만이므로 입장이 불가능합니다.");
		history.go(-1);
	</script> <!-- 끊은 다음 javascript 코드를 삽입해야 함 -->
<%		
	} else {
		request.setAttribute("name", "홍길동");	//getAttribute로 꺼내기
		RequestDispatcher dispatcher = request.getRequestDispatcher("05_forwardResult.jsp");
		dispatcher.forward(request, response);
	}
	application.setAttribute("aaa", "aaaaa");	//프로젝트 내 모든 jsp 페이지에서 공통적으로 사용 가능
%>