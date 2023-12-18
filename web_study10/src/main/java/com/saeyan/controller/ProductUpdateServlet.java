package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = dao.selectProductByCode(code);
		
		request.setAttribute("product", vo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		int sizeLimit = 20*1024*1024;
		String enctype = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(
				request, 			//요청
				path,				//저장경로
				sizeLimit,			//업로드 크기
				enctype,			//인코딩 방법
				new DefaultFileRenamePolicy());		//중복되면 파일명 뒤에 숫자를 붙임
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String pictureurl = multi.getFilesystemName("pictureurl");	//파일명
		
		if(pictureurl==null) {
			pictureurl = multi.getParameter("nonmakeImg");	//hidden으로 설정해 둔 값
		}
		
		ProductVO pVo = new ProductVO();
		pVo.setCode(Integer.parseInt(code));
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setDescription(description);
		pVo.setPictureurl(pictureurl);
		
		//System.out.println(pVo);
		
		ProductDAO dao = ProductDAO.getInstance();
		int result = dao.updateProduct(pVo);
		
		if(result==1) {
			response.sendRedirect("productList.do");			
		} else {			
			response.sendRedirect("productwrite.do");			
		}
	}

}
