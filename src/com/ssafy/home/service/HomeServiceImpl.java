package com.ssafy.home.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.home.dao.HomeDao;
import com.ssafy.home.dao.HomeDaoImpl;
import com.ssafy.home.model.DealInfo;

public class HomeServiceImpl implements HomeService {
	
	HomeDao dao;
	
	public HomeServiceImpl() {
		dao = new HomeDaoImpl();
	}

	@Override
	public ArrayList<DealInfo> find3() throws SQLException {
		return dao.find3();
	}

}
