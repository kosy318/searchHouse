package com.home.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.user.service.UserService;
import com.home.user.service.UserServiceImpl;
import com.ssafy.util.Alert;

public class UserController {
	
	UserService service;

	public UserController() {
		service = new UserServiceImpl();
	}
	
	public void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/loginForm.jsp");
		dispatcher.forward(request, response);
	}

	public void loginProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = service.login(id, password);
		System.out.println(name);
		if(name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			response.sendRedirect(request.getContextPath() + "/main.home");
		}
		else {
			Alert.alert(response, "아이디와 비밀번호를 다시 확인해주세요.");
		}
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.setAttribute("id", null);
		session.setAttribute("name", null);
		response.sendRedirect(request.getContextPath() + "/main.home");
	}

}
