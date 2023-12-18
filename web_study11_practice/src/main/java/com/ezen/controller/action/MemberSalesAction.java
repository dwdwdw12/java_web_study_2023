package com.ezen.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberSalesVO;
import com.ezen.vo.MemberVO;

public class MemberSalesAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		String url = "/member/memberSales.jsp";
		
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberSalesVO> memberSalesList = dao.memberSales();
		
		request.setAttribute("memberSalesList", memberSalesList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
