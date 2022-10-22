package com.home.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.home.model.Home;

public interface HomeService {

	ArrayList<Home> find3() throws SQLException;

}
