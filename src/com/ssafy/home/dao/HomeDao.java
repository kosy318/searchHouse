package com.ssafy.home.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.home.model.DealInfo;
import com.ssafy.home.model.Home;

public interface HomeDao {

	ArrayList<DealInfo> find3() throws SQLException;

}
