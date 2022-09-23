package com.ssafy.apt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.apt.model.AddressDto;
import com.ssafy.apt.model.AptDto;
import com.ssafy.apt.model.DealInfoDto;
import com.ssafy.apt.model.SidoDto;
import com.ssafy.util.DBUtil;

public class AptDaoImpl implements AptDao {
	private static AptDao aptDao = new AptDaoImpl();
	private DBUtil dbUtil;

	private AptDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static AptDao getAptDao() {
		return aptDao;
	}

//	@Override
//	public ArrayList<Object> findAddress() throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<AddressDto> list = new ArrayList<>();
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder sql = new StringBuilder();
//			sql.append("select * from baseaddress ");
//
//			pstmt = conn.prepareStatement(sql.toString());
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				AddressDto address = new AddressDto();
//				address.setNo(rs.getInt("no"));
//				address.setSidoName(rs.getString("sidoname"));
//				address.setGugunName(rs.getString("gugunname"));
//				address.setDongName(rs.getString("dongname"));
//				address.setDongCode(rs.getString("dongcode"));
//				address.setLat(rs.getString("lat"));
//				address.setLng(rs.getString("lng"));
//				list.add(address);
//			}
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//		return list;
//	}	
	@Override
	public ArrayList<SidoDto> getSidoList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SidoDto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from sidocode ");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SidoDto sidoDto = new SidoDto();
				sidoDto.setSidoCode(rs.getString("sidoCode"));
				sidoDto.setSidoName(rs.getString("sidoName"));

//				System.out.println(sidoDto.getSidoName());
				list.add(sidoDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public ArrayList<DealInfoDto> search(String dong, String year, String month) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DealInfoDto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			String sql = "";
			sql = "select h.aptcode, h.aptname, d.area, d.floor, h.dongname, d.dealAmount\r\n"
					+ "from houseinfo h join housedeal d \r\n" + "on h.aptcode = d.aptcode\r\n"
					+ "where h.dongname=? and d.dealYear=? and d.dealMonth=?";

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dong);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				DealInfoDto deal = new DealInfoDto();
				deal.setAptCode(rs.getInt("aptcode"));
				deal.setAptName(rs.getString("aptname"));
				deal.setArea(rs.getString("area"));
				deal.setFloor(rs.getString("floor"));
				deal.setDongName(rs.getString("dongname"));
				deal.setDealAmount(rs.getString("dealamount"));
				list.add(deal);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}



}
