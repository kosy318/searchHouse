package com.home.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.home")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HomeController hcon;
	UserController ucon;
	
    public FrontController() {
    	hcon = new HomeController();
    	ucon = new UserController();
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	request.setCharacterEncoding("utf-8");
    	
    	String reqString = request.getServletPath();
    	System.out.println(reqString);
    	
    	if(reqString.equals("/main.home")) {
    		hcon.find3(request, response);
    	} else if(reqString.equals("/login.home")) {
    		ucon.loginForm(request, response);
    	} else if(reqString.equals("/loginProcess.home")) {
    		ucon.loginProcess(request, response);
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
