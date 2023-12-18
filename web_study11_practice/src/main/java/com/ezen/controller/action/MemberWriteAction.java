package com.ezen.controller.action;

import java.sql.Date;

import javax.servlet.ServletException; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.vo.MemberVO;

public class MemberWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		MemberVO vo = new MemberVO();
		
		vo.setCustno(Integer.parseInt(request.getParameter("custno")));
		vo.setCustname(request.getParameter("custname"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAddress(request.getParameter("address"));
		vo.setJoindate(Date.valueOf(request.getParameter("joindate")));
		vo.setGrade(request.getParameter("grade"));
		vo.setCity(request.getParameter("city"));
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(vo);
		System.out.println(result);
		
		if(result==1) {
			response.sendRedirect("MemberServlet?command=member_list");
		}
		
//		new BoardListAction().execute(request, response);
		
	}

}
