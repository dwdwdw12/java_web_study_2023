package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String lev = request.getParameter("lev");
		String url = "member/login.jsp";

		EmployeesDAO dao = EmployeesDAO.getInstance();
		
		int result = dao.userCheck(id, pass, lev);
		if(result==1) {
			request.setAttribute("message", "성공");
			EmployeesVO vo = dao.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);	
			url = "member/main.jsp";
		} else if(result==0) {
			request.setAttribute("message", "정보가 일치하지 않습니다.");
		} else if(result==-1) {
			request.setAttribute("message", "정보가 일치하지 않습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
