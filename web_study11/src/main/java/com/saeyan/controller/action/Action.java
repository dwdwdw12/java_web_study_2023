package com.saeyan.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception;	
	//functional interface...추상 메서드가 1개
}
