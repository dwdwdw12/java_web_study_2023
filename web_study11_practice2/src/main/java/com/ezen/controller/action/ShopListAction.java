package com.ezen.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.ShopDAO;
import com.ezen.dto.MemberVO;

public class ShopListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		ShopDAO dao = ShopDAO.getInstance();
		
		List<MemberVO> lists = dao.shopList();
		
		request.setAttribute("list", lists);
		
//		for(MemberVO vo : lists) {
//			System.out.println(vo);
//		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

}
