package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");	//타입 설정
		PrintWriter out = response.getWriter();
		
		String savePath = "upload";
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		try {
			MultipartRequest multi = new MultipartRequest(request,
					uploadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			
			while (files.hasMoreElements()) {
				String file = (String) files.nextElement();
				System.out.println("file : " + file);
				String file_name = multi.getFilesystemName(file); //서버상 파일이름
		//		System.out.println("file name : " + file_name);
				String ori_file_name = multi.getOriginalFileName(file); //실제 파일명, 다운로드 시에는 원본이름으로 다운받게 해야함.
				
				out.println("<br> 업로드된 파일명 : " + file_name);
				out.println("<br> 원본 파일명 : " + ori_file_name);	
				out.println("<hr>");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
