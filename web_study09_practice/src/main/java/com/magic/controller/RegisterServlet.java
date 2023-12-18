package com.magic.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/registration.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		EmployeesVO vo = new EmployeesVO();
		
		vo.setName(request.getParameter("name"));
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setPhone(request.getParameter("phone"));
		vo.setGender(request.getParameter("gender"));
		vo.setLev((request.getParameter("lev")));
		
		EmployeesDAO mDao = EmployeesDAO.getInstance();
		int result = mDao.insertMember(vo);
		
		request.setAttribute("newVo", vo);
		
		if(result==1) {
			request.setAttribute("message", "회원가입에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberInfo.jsp");
		dispatcher.forward(request, response);
		
	}

}
