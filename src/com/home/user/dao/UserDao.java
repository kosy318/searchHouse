package com.home.user.dao;

import java.sql.SQLException;

public interface UserDao {
	
	String login(String id, String password) throws SQLException;

}
