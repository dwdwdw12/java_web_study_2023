package com.ezen.controller.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

@WebServlet("/uploadSummernoteImageFile")
public class UploadSummernoteImageFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject jsonObject = new JsonObject();

		// 파일저장 외부 경로, 파일명, 저장할 파일명

/*		try {

			String originalFileName = multipartFile.getOriginalFilename();
			String root = request.getSession().getServletContext().getRealPath("resources");
			String savePath = root + "\\image\\review\\summerImageFiles";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			String boardFileRename = sdf.format(new Date(System.currentTimeMillis())) + "." + extension;
			File targetFile = new File(savePath);
			if (!targetFile.exists()) {
				targetFile.mkdir();
			}
			UUID.randomUUID().toString();

			multipartFile.transferTo(new File(savePath + "\\" + boardFileRename));
			System.out.println(savePath);
			jsonObject.addProperty("url", "/resources/image/review/summerImageFiles/" + boardFileRename);
			jsonObject.addProperty("originName", originalFileName);
			jsonObject.addProperty("reponseCode", "success");

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
*/	}

}
