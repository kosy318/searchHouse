package com.ssafy.home.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.home.model.DealInfo;
import com.ssafy.home.model.Home;

public interface HomeService {

	ArrayList<DealInfo> find3() throws SQLException;

}