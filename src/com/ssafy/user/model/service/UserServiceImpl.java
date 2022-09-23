package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.dao.UserDao;
import com.ssafy.user.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	
	private static UserService userService = new UserServiceImpl();
	private UserDao userDao;
	
	private UserServiceImpl() {
		userDao = UserDaoImpl.getUserDao();
	}
	
	public static UserService getUserService() {
		return userService;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return userDao.idCheck(userId);
	}

	@Override
	public void signup(UserDto userDto) throws Exception {
		// TODO validation check
		userDao.signup(userDto);
	}

	@Override
	public UserDto loginUser(String userId, String userPwd) throws Exception {
		return userDao.loginUser(userId, userPwd);
	}

	@Override
	public void mypageModify(UserDto userDto) throws SQLException {
		userDao.mypageModify(userDto);
	}

	@Override
	public ArrayList<UserDto> searchUserInfo(String info) throws SQLException {
		return userDao.searchUserInfo(info);
	}

	@Override
	public void delete(UserDto userDto) throws SQLException {
		userDao.delete(userDto);
	}

}