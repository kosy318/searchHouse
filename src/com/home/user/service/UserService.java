package com.home.user.service;

import java.sql.SQLException;

public interface UserService {
	
	public String login(String id, String password) throws SQLException;
	
}
