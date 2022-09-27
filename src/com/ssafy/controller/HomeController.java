package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.home.model.DealInfo;
import com.ssafy.home.service.HomeService;
import com.ssafy.home.service.HomeServiceImpl;

public class HomeController {
	
	HomeService service;
	
	public HomeController() {
		service = new HomeServiceImpl();
	}

	public void find3(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		ArrayList<DealInfo> list = service.find3();
		HttpSession session = request.getSession();
		session.setAttribute("top3", list);
		
		response.sendRedirect(request.getContextPath());
	}

}
