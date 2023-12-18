package com.dongwoo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dongwoo.dao.MovieDAO;
import com.dongwoo.vo.MovieVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/movieWrite.do")
public class MovieWirteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/movieWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		int sizeLimit = 20*1024*1024;
		String enctype = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(
				request, 			
				path,				
				sizeLimit,			
				enctype,			
				new DefaultFileRenamePolicy());		

		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String director = multi.getParameter("director");
		String actor = multi.getParameter("actor");
		String synopsis = multi.getParameter("synopsis");	
		String poster = multi.getFilesystemName("poster");	
		
		MovieVO vo = new MovieVO();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setDirector(director);
		vo.setActor(actor);
		vo.setSynopsis(synopsis);
		vo.setPoster(poster);
		
		System.out.println(path);
		
		MovieDAO dao = MovieDAO.getInstance();
		int result = dao.insertMovie(vo);
		
		if(result==1) {
			response.sendRedirect("movieList.do");			
		} else {			
			response.sendRedirect("movieWrite.do");			
		}
	}

}
