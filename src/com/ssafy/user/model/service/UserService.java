package com.ssafy.user.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.user.model.UserDto;

public interface UserService {

	int idCheck(String userId) throws Exception;

	void signup(UserDto userDto) throws Exception;

	UserDto loginUser(String userId, String userPwd) throws Exception;

	void mypageModify(UserDto userDto) throws SQLException;

	ArrayList<UserDto> searchUserInfo(String info) throws SQLException;

	void delete(UserDto userDto) throws SQLException;


}
