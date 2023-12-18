package com.ezen.controller.action;

import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;


public class MemberUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/member/memberUpdateForm.jsp";
		String custno = request.getParameter("custno");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.selectOneByCustno(Integer.parseInt(custno));
		System.out.println(vo);
		
		request.setAttribute("member", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
