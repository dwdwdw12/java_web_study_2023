package com.ezen.controller.action;

import java.util.List; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;


public class MemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/member/memberList.jsp";
		
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberVO> memberList = dao.selectAllMembers();
		
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
