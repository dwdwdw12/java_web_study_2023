package com.dongwoo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongwoo.dao.MovieDAO;
import com.dongwoo.vo.MovieVO;

@WebServlet("/movieDelete.do")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MovieDAO dao = MovieDAO.getInstance();
		MovieVO vo = dao.getMovie(code);
		
		request.setAttribute("movie", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieDelete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		MovieDAO dao = MovieDAO.getInstance();
		MovieVO vo = dao.getMovie(code);
		
		int result = dao.deleteMovie(code);
		
		if(result==1) {
			response.sendRedirect("movieList.do");			
		} else {			
			response.sendRedirect("movieDelete.do");			
		}
		
	}

}
