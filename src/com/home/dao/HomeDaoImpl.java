package com.home.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

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

	@Override
	public ArrayList<String> getSido() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select distinct(sidoName) from dongcode";
		
		Connection conn = util.getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()) {
			String sido = rs.getString(1);
			list.add(sido);
		}
		
		util.close(rs, stat, conn);
		return list;
	}

	@Override
	public ArrayList<HashMap<String, String>> getNames(HashMap<String, String> address) throws SQLException {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		
		Connection conn = util.getConnection();
		PreparedStatement stat;
		System.out.println(address.get("gugun"));
		if(address.get("gugun") == null || address.get("gugun") == "") {
			String sql = "select distinct(gugunName) from dongcode where sidoName=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, address.get("sido"));
		}
		else {
			String sql = "distinct(dongName, dongCode) from dongcode where sidoName=? and gugunName=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, address.get("sido"));
			stat.setString(2, address.get("gugun"));
		}
		
		ResultSet rs = stat.executeQuery();
		while(rs.next()) {
			String name = rs.getString(1);
			String code = rs.getString(1);
			System.out.println(name + ", " + code);
			if(address.get("gugun") != null) code = rs.getString(2);
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", name);
			map.put("code", code);
			list.add(map);
		}
		
		util.close(rs, stat, conn);
		return list;
	}

}
