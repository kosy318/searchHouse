package com.ssafy.apt.controller;

import java.io.IOException;
import java.sql.SQLException;
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

import com.ssafy.apt.model.DealInfoDto;
import com.ssafy.apt.model.SidoDto;
import com.ssafy.apt.service.AptService;
import com.ssafy.apt.service.AptServiceImpl;
import com.ssafy.util.ParameterCheck;

@WebServlet("/apt")
public class AptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AptService aptService;
    private Map<String, String> map;
    
    public void init() {
    	aptService = AptServiceImpl.getAptService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		
		String act = request.getParameter("act");
		
		String path = "/index.jsp";
		if("mvsearch".equals(act)) {
			String sidoName = ParameterCheck.nullToBlank(request.getParameter("sidoName"));
			String gugunName = ParameterCheck.nullToBlank(request.getParameter("gugunName"));
			String dongName = ParameterCheck.nullToBlank(request.getParameter("dongName"));
//			String queryString = "&sidoName="+sidoName+"&gugunName="+gugunName+"&dongName="+dongName;
			map = new HashMap<>();
			map.put("sidoName", sidoName);
			map.put("gugunName", gugunName);
			map.put("dongName", dongName);
			if(sidoName.equals("")) {
				path = getSidoList(request, response);
			} else if(!sidoName.equals("") && gugunName.equals("")) {
				path = getGugunList(request, response);
			} else {
				path = getDongList(request, response);
			}
			redirect(request, response, path);
		} else if ("searchProcess".equals(act)) {
			path = search(request, response);
			forward(request, response, path);
		} else {
			
		}
	}







	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}


	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	private String getDongList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getGugunList(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	private String getSidoList(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<SidoDto> list = aptService.getSidoList();
			HttpSession session = request.getSession();
			session.setAttribute("sidoList", list);
			return "/views/aptSearch.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "도시 정보 불러오는 데 실패했습니다.");
			return "/error/error.jsp";
		}
	}
	
//	private String mvsearch(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			ArrayList<Object> list = aptService.findAddress(map);
//			request.setAttribute("list", list);
//			return "/views/aptSearch.jsp";
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		request.setAttribute("address", list);
//		
//		return null;
//	}
	
	private String search(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<DealInfoDto> list = new ArrayList<>();
		try {
			String dongName = request.getParameter("dong");
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			
			list = aptService.search(dongName, year, month);
			request.setAttribute("apts", list);
			return "/views/aptlist.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	private String toJsonArr(ArrayList<> list) {
//		JSONArray jArray= null;
//        try {
//            jArray = new JSONArray();
//            for (int j = 0; j < list.size(); j++) {
//                JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
//                sObject.put("no", list.get(j).getNo());
//                sObject.put("sidoName", list.get(j).getSidoName());
//                sObject.put("gugunName", list.get(j).getGugunName());
//                sObject.put("dongName", list.get(j).getDongCode());
//                sObject.put("dongcode", list.get(j).getDongCode());
//                sObject.put("lat", list.get(j).getLat());
//                sObject.put("lng", list.get(j).getLng());
//                jArray.add(sObject);
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//		return jArray.toJSONString();
//	}
}
