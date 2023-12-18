package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String url = "member/login.jsp";
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(userId, pwd);
		
		if(result==1) {//로그인 성공
			MemberVO mVo = mDao.getMember(userId);
			System.out.println("====>"+mVo);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			request.setAttribute("message", "회원가입에 성공했습니다");	//이동한 페이지에 쓰이는 메세지
			url = "main.jsp";		//로그인에 성공할 경우, 해당 페이지로 이동, attribute 전달
		} else if(result==0) {	//pwd x
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if(result==-1) { //id x
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
