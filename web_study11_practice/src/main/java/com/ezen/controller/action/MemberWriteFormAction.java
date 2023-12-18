package com.ezen.controller.action;

import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;

public class MemberWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		MemberDAO dao = MemberDAO.getInstance();
		int newCustno = dao.GetNewCustno();
		Date newJoindate = dao.GetNewJoindate();
		System.out.println(newCustno);
		System.out.println(newJoindate);
		
		request.setAttribute("NewCustNo", newCustno);
		request.setAttribute("NewJoinDate", newJoindate);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberWriteForm.jsp");
		dispatcher.forward(request, response);
		
	}

}
