package com.home.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.home.dao.HomeDao;
import com.home.dao.HomeDaoImpl;
import com.home.model.Home;

public class HomeServiceImpl implements HomeService {
	
	HomeDao dao;
	
	public HomeServiceImpl() {
		dao = new HomeDaoImpl();
	}

	@Override
	public ArrayList<Home> find3() throws SQLException {
		return dao.find3();
	}

	@Override
	public ArrayList<String> getSido() throws SQLException {
		return dao.getSido();
	}

	@Override
	public ArrayList<HashMap<String, String>> getNames(HashMap<String, String> address) throws SQLException {
		return dao.getNames(address);
	}

}
