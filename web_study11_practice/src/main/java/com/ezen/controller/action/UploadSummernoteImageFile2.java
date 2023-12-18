package com.ezen.controller.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/uploadSummernoteImageFile")
public class UploadSummernoteImageFile2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String uploadPath = "upload";
		PrintWriter out = response.getWriter();
/*		
		String originalFileExtension = file.getOriginalFilename();
		String storedFilename = UUID.randomUUID().toString().replaceAll("-", "");
		
		System.out.println("stored file name : " + storedFilename);
		file.transferTo(new File(uploadPath+storedFilename));
		out.println("upload/"+storedFilename);
		out.close();										*/
///////	
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
