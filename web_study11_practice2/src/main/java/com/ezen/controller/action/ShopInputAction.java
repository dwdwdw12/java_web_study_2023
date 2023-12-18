package com.ezen.controller.action;

import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopDAO;
import com.ezen.dto.MemberVO;

public class ShopInputAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		MemberVO vo = new MemberVO();
		
		vo.setCustName(request.getParameter("custname"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
//		vo.setJoinDate(Date.valueOf(request.getParameter("joindate")));
		vo.setJoinDate(request.getParameter("joindate"));
		vo.setGrade(request.getParameter("grade"));
		vo.setCity(request.getParameter("city"));
		
//		System.out.println(vo);
		
		ShopDAO dao = ShopDAO.getInstance();
		int result = dao.insertShop(vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

}
