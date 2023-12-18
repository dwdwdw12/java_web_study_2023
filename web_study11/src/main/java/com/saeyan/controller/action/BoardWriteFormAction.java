package com.saeyan.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/boardwrite.jsp");
		dispatcher.forward(request, response);
		
	}

}
