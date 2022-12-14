package com.home.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.home.model.Home;
import com.home.service.HomeService;
import com.home.service.HomeServiceImpl;

public class HomeController {
	
	HomeService service;
	
	public HomeController() {
		service = new HomeServiceImpl();
	}

	public void find3(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		ArrayList<Home> list = service.find3();
		HttpSession session = request.getSession();
		session.setAttribute("top3", list);
		
		response.sendRedirect(request.getContextPath());
	}

	public void dealSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("sidoList") == null) {
			ArrayList<String> list = service.getSido();
			session.setAttribute("sidoList", list);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/dealSearch.jsp");
		dispatcher.forward(request, response);
	}

	public void getNames(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HashMap<String, String> address = new HashMap<>();
		address.put("sido", request.getParameter("sido"));
		address.put("gugun", request.getParameter("gugun"));
		ArrayList<HashMap<String, String>> list = service.getNames(address);
		
		String gson = new Gson().toJson(list);
		System.out.println(gson);
	}

}
