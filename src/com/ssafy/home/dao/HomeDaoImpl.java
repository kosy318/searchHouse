package com.ssafy.home.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ssafy.home.model.DealInfo;
import com.ssafy.home.model.Home;
import com.ssafy.util.DBUtil;

public class HomeDaoImpl implements HomeDao {
	
	DBUtil util;
	
	public HomeDaoImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public ArrayList<DealInfo> find3() throws SQLException {
		String sql = "select h.aptname, h.dongname, d.dealAmount\r\n" + 
				"from houseinfo h join housedeal d\r\n" + 
				"on h.aptcode = d.aptcode\r\n" + 
				"order by d.dealAmount desc\r\n" + 
				"limit 3";
		
		Connection conn = util.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		
		ArrayList<DealInfo> list = new ArrayList<>();
		while(rs.next()) {
			String aptName = rs.getString(1);
			String dealAmount = rs.getString(2);
			String dongName = rs.getString(3);
			
			DealInfo d = new DealInfo(0, aptName, null,  null, dealAmount, dongName);
			System.out.println(aptName);
			list.add(d);
		}
		return list;
	}

}
