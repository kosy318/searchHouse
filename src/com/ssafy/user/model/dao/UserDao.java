package com.ssafy.user.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.user.model.UserDto;

public interface UserDao {

	int idCheck(String userId) throws SQLException;

	void signup(UserDto userDto) throws SQLException;

	UserDto loginUser(String userId, String userPwd) throws SQLException;

	void mypageModify(UserDto userDto) throws SQLException;

	ArrayList<UserDto> searchUserInfo(String info) throws SQLException;

	void delete(UserDto userDto) throws SQLException;

}
