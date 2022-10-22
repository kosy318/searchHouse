package com.home.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {

	DBUtil util;
	
	public UserDaoImpl() {
		util = DBUtil.getInstance();
	}
	
	@Override
	public String login(String id, String password) throws SQLException {
		Connection con = util.getConnection();
		String q = "select name from users where id=? and password=?";
		PreparedStatement stat = con.prepareStatement(q);
		stat.setString(1, id);
		stat.setString(2, password);
		
		ResultSet rs = stat.executeQuery();
		String name = null;
		if(rs.next()) {
			name = rs.getString(1);
		}
		
		util.close(rs, stat, con);
		
		return name;
	}

}
