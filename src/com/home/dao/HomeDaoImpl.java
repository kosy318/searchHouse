package com.home.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.home.model.Home;
import com.ssafy.util.DBUtil;

public class HomeDaoImpl implements HomeDao {
	
	DBUtil util;
	
	public HomeDaoImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public ArrayList<Home> find3() throws SQLException {
		String sql = "select i.buildYear, i.apartmentName, i.aptCode, i.dong, i.lng, i.lat, d.dealAmount, i.dongCode\r\n" + 
				"from houseinfo i join housedeal d\r\n" + 
				"on i.aptcode = d.aptcode\r\n" + 
				"limit 3";
		
		Connection conn = util.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		ArrayList<Home> list = new ArrayList<>();
		while(rs.next()) {
			String buildYear = rs.getString(1);
			String apartmentName = rs.getString(2);
			String aptCode = rs.getString(3);
			String dong = rs.getString(4);
			String lng = rs.getString(5);
			String lat = rs.getString(6);
			String dealAmount = rs.getString(7);
			String dongCode = rs.getString(8);
			
			System.out.println(dealAmount);
			Home h = new Home(aptCode, apartmentName, dealAmount, dongCode, dong, buildYear, lng, lat);
			list.add(h);
		}
		return list;
	}

}
