package com.home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.user.service.UserService;

public class UserController {
	
	UserService service;

	public void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");
		dispatcher.forward(request, response);
	}

	public void loginProcess(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		service.login();
	}

}
