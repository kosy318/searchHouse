package com.home.user.service;

import java.sql.SQLException;

import com.home.user.dao.UserDao;
import com.home.user.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	UserDao dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}
	
	@Override
	public String login(String id, String password) throws SQLException {
		return dao.login(id, password);
	}
	
}
