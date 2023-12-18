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

@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		EmployeesDAO dao = EmployeesDAO.getInstance();
		EmployeesVO vo = dao.getMember(id);
		
		request.setAttribute("empVo", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/mypage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		EmployeesVO vo = new EmployeesVO();
		
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setPass(request.getParameter("pass"));
		vo.setPhone(request.getParameter("phone"));
		vo.setGender(request.getParameter("gender"));
		vo.setId(request.getParameter("id"));
		
		EmployeesDAO dao = EmployeesDAO.getInstance();
		int result = dao.updateMember(vo);
		
		//System.out.println(result);
		
		request.setAttribute("newVo", vo);
		
		if(result==1) {
			request.setAttribute("message", "회원정보 수정에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원정보 수정에 실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberInfo.jsp");
		dispatcher.forward(request, response);
	}

}
