package com.ssafy.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Alert {
	
	public static void alert(HttpServletResponse response, String msg) {
	    try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter w = response.getWriter();
			w.write("<script>alert('"+msg+"');</script>");
			w.flush();
			w.close();
	    } catch(Exception e) {
			e.printStackTrace();
	    }
	}

}
