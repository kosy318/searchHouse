package com.home.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.home.model.Home;

public interface HomeDao {

	ArrayList<Home> find3() throws SQLException;

}
