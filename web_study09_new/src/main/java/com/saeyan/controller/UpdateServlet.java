package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO vo = mDao.getMember(userId);
		
		request.setAttribute("mVo", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/update.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		//join.jsp에 입력한 회원정보를 vo 클래스에 저장
		MemberVO vo = new MemberVO();
		
		vo.setName(request.getParameter("name"));
		vo.setUserId(request.getParameter("userId"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("email"));
		vo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		//DB 연결(회원정보 전달)
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.updateMember(vo);
		
		if(result==1) {
			request.setAttribute("message", "회원정보 수정에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원정보 수정에 실패했습니다.");
		}
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
//		dispatcher.forward(request, response);
		response.sendRedirect("login.do");
	}

}
