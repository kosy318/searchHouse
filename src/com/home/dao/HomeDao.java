package com.home.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.home.model.Home;

public interface HomeDao {

	ArrayList<Home> find3() throws SQLException;
	ArrayList<String> getSido() throws SQLException;
	ArrayList<HashMap<String, String>> getNames(HashMap<String, String> address) throws SQLException;

}
