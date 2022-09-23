package com.ssafy.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.service.UserService;
import com.ssafy.user.model.service.UserServiceImpl;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		userService = UserServiceImpl.getUserService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println("act ==== " + act);
		
		String path = "/index.jsp";
		if("mvsignup".equals(act)) {
			path = "/views/signup.jsp";
			redirect(request, response, path);
		} else if("idcheck".equals(act)) {
			int cnt = idCheck(request, response);
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println(cnt);
		} else if("signup".equals(act)) {
			path = signup(request, response);
			forward(request, response, path);
		} else if("mvlogin".equals(act)) {
			path = "/views/login.jsp";
			redirect(request, response, path);
		} else if("login".equals(act)) {
			path = login(request, response);
			forward(request, response, path);
		} else if("logout".equals(act)) {
			path = logout(request, response);
			forward(request, response, path);
		} else if("mvmypage".equals(act)) {
			HttpSession session = request.getSession();
			if(session.getAttribute("auth") != null)
				path = "/views/mypage.jsp";
			else
				path = "/views/login.jsp";
			redirect(request, response, path);
		} else if("mypage".equals(act)) {
			path = mypage(request, response);
			forward(request, response, path);
		} else if("mvsearch".equals(act)) {
			path = "/views/userInfo.jsp";
			redirect(request, response, path);
		} else if("search-userinfo".equals(act)) {
			path = searchUserInfo(request, response);
			forward(request, response, path);
		} else if("checkPwd".equals(act)) {
			path = "/views/checkPwd.jsp";
			redirect(request, response, path);
		} else if("delete".equals(act)) {
			path = deleteAccount(request, response);
			forward(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}
	
	private String deleteAccount(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = ((UserDto)session.getAttribute("auth")).getId(); 
		String password = request.getParameter("password");
		try {
			UserDto userDto = userService.loginUser(id, password);
			if(userDto != null) { // 로그인 성공(id, pwd 일치!!!!)
				
				userService.delete(userDto);
				return logout(request, response);
			} else { // 로그인 실패(id, pwd 불일치!!!!)
				request.setAttribute("msg", "비밀번호 확인 후 다시 시도!!!");
				return "/views/checkPwd.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 처리중 에러 발생!!!");
			return "/error/error.jsp";
		}
	}

	private String searchUserInfo(HttpServletRequest request, HttpServletResponse response) {
		String info = request.getParameter("search-info");
		if(info != null) {
			try {
				ArrayList<UserDto> list = userService.searchUserInfo(info);
				System.out.println(list.size());
				request.setAttribute("userlist", list);
			} catch (SQLException e) {
				e.printStackTrace();
				request.setAttribute("msg", "에러발생!!!");
				return "/error/error.jsp";
			}
		}
		return "/views/userInfo.jsp";
	}

	private String mypage(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			UserDto userDto = userService.loginUser(id, password);
			if(userDto != null) { // 로그인 성공(id, pwd 일치!!!!)
				
				userDto.setName(request.getParameter("name"));
				userDto.setAddress(request.getParameter("address"));
				userDto.setPhone(request.getParameter("phone"));
				userService.mypageModify(userDto);
				
				HttpSession session = request.getSession();
				session.setAttribute("auth", userDto);
				request.setAttribute("msg", "수정 완료");
				return "/index.jsp";
			} else { // 로그인 실패(id, pwd 불일치!!!!)
				request.setAttribute("msg", "비밀번호 확인!!!");
				return "/views/mypage.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원정보 수정중 에러 발생!!!");
			return "/error/error.jsp";
		}
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		session.removeAttribute("userinfo");
		session.invalidate();
		return "/index.jsp";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			UserDto userDto = userService.loginUser(id, password);
			if(userDto != null) { // 로그인 성공(id, pwd 일치!!!!)
				
				HttpSession session = request.getSession();
				session.setAttribute("auth", userDto);
				return "/index.jsp";
			} else { // 로그인 실패(id, pwd 불일치!!!!)
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인!!!");
				return "/views/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 처리중 에러 발생!!!");
			return "/error/error.jsp";
		}
	}

	private String signup(HttpServletRequest request, HttpServletResponse response) {
		UserDto userDto = new UserDto();
		userDto.setId(request.getParameter("id"));
		userDto.setName(request.getParameter("name"));
		userDto.setPassword(request.getParameter("password"));
		userDto.setAddress(request.getParameter("address"));
		userDto.setPhone(request.getParameter("phone"));
		try {
			userService.signup(userDto);
			return "/user?act=mvlogin";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 가입 처리중 에러 발생!!!");
			return "/error/error.jsp";
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private int idCheck(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println(id);
		try {
			int count = userService.idCheck(id);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 500;
	}

}