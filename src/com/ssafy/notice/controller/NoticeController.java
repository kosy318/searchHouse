package com.ssafy.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.notice.model.NoticeDto;
import com.ssafy.notice.model.service.NoticeService;
import com.ssafy.notice.model.service.NoticeServiceImpl;
import com.ssafy.user.model.UserDto;
import com.ssafy.util.ParameterCheck;

@WebServlet("/notice")
public class NoticeController extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService;
	private Map<String, String> map;
	
	public void init() {
		noticeService = NoticeServiceImpl.getNoticeService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		String key = ParameterCheck.nullToBlank(request.getParameter("key"));
		String word = ParameterCheck.nullToBlank(request.getParameter("word"));
		String queryString = "?key=" + key + "&word=" + word;
		map = new HashMap<>();
		map.put("key", key);
		map.put("word", word);
		
		System.out.println("act===========" + act);
		
		String path = "/notice";
		if("list".equals(act)) {
			path = list(request, response);
			forward(request, response, path + queryString);
		} else if("mvwrite".equals(act)) {
			path = "/views/notice-write.jsp";
			redirect(request, response, path);
		} else if("write".equals(act)) {
			path = write(request, response);
			forward(request, response, path);
		} else if("notice-view".equals(act)) {
			path = view(request, response);
			forward(request, response, path + queryString);
		} else if("mvmodify".equals(act)) {
			path = mvModify(request, response);
			forward(request, response, path);
		} else if("modify".equals(act)) {
			path = modify(request, response);
			forward(request, response, path);
		} else if("delete".equals(act)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response,path);
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

	private String list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("auth");
		if(userDto != null) {
			try {
				ArrayList<NoticeDto> list = noticeService.listNotice(map);
				request.setAttribute("notices", list);
				return "/views/notice.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글목록 얻기 중 에러발생!!!");
				return "/error/error.jsp";
			}
		} else {
			return "/views/login.jsp";
		}
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("auth");
		if(userDto != null) {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setTitle(request.getParameter("title"));
			noticeDto.setContent(request.getParameter("content"));
			try {
				noticeService.writeNotice(noticeDto);
				return "/notice?act=list&key=&word=";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 에러발생!!!");
				return "/error/error.jsp";
			}
		} else {
			return "/views/login.jsp";
		}
	}
	
	private String view(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("auth");
		System.out.println(userDto.getId());
		if(userDto != null) {
			try {
				int num = Integer.parseInt(request.getParameter("num"));
				NoticeDto noticeDto = noticeService.getNotice(num);
				noticeService.updateHit(num);
				request.setAttribute("notice", noticeDto);
				System.out.println(noticeDto.getNum());
				
				return "/views/notice-view.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 얻기 중 에러발생!!!");
				return "/error/error.jsp";
			}
		} else {
			return "/views/login.jsp";
		}
	}

	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			UserDto userDto = (UserDto) session.getAttribute("auth");
			if(userDto != null) {
				int noticeNo = Integer.parseInt(request.getParameter("num"));
				NoticeDto noticeDto = noticeService.getNotice(noticeNo);
				request.setAttribute("notice", noticeDto);
				
				return "/views/notice-modify.jsp";
			} else {
				return "/views/login.jsp";
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글 내용 얻는 중 문제 발생!");
			return "/error/error.jsp";
		}
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("auth");
		if(userDto != null) {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto.setNum(Integer.parseInt(request.getParameter("num")));
			noticeDto.setTitle(request.getParameter("title"));
			noticeDto.setContent(request.getParameter("content"));
			
			try {
				noticeService.modifyNotice(noticeDto);
				return "/notice?act=list&key=&word=";
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글수정 중 문제 발생!");
				return "/error/error.jsp";
			}
		} else {
			return "/views/login.jsp";
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("auth");
		if(userDto != null) {
			try {
				int num = Integer.parseInt(request.getParameter("num"));
				noticeService.deleteNotice(num);
				return "/notice?act=list&key=&word=";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글 삭제 중 에러발생!!!");
				return "/error/error.jsp";
			}
		} else {
			return "/views/login.jsp";
		}
	}

}