package com.saeyan.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		String url = "board/boardView.jsp";
		String num = request.getParameter("num");	//forward 방식이므로 boardList.jsp에서 보낸 num값이 전달됨.
	
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO vo = bDao.selectOneByNum(Integer.parseInt(num));
		
		request.setAttribute("board", vo);
		
		bDao.updateReadcount(Integer.parseInt(num));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
