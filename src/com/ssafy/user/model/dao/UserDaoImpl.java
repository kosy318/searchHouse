package com.ssafy.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.user.model.UserDto;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	private static UserDao userDao = new UserDaoImpl();
	private DBUtil dbUtil;
	
	private UserDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static UserDao getUserDao() {
		return userDao;
	}

	@Override
	public int idCheck(String userId) throws SQLException {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(id) \n");
			sql.append("from users \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return cnt;
	}

	@Override
	public void signup(UserDto userDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into users (id, name, password, address, phone) \n");
			sql.append("values (?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, userDto.getId());
			pstmt.setString(++idx, userDto.getName());
			pstmt.setString(++idx, userDto.getPassword());
			pstmt.setString(++idx, userDto.getAddress());
			pstmt.setString(++idx, userDto.getPhone());
			
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}

	@Override
	public UserDto loginUser(String id, String password) throws SQLException {
		UserDto userDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select name, address, phone \n");
			sql.append("from users \n");
			sql.append("where id = ? and password = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userDto = new UserDto();
				userDto.setId(id);
				userDto.setName(rs.getString("name"));
				userDto.setAddress(rs.getString("address"));
				userDto.setPhone(rs.getString("phone"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return userDto;
	}

	@Override
	public void mypageModify(UserDto userDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update users \n");
			sql.append("set name=?, address=?, phone=? \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userDto.getName());
			pstmt.setString(2, userDto.getAddress());
			pstmt.setString(3, userDto.getPhone());
			pstmt.setString(4, userDto.getId());

			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}		
	}

	@Override
	public ArrayList<UserDto> searchUserInfo(String info) throws SQLException {
		ArrayList<UserDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, name, address, phone \n");
			sql.append("from users \n");
			sql.append("where id like ? or name like ?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;

			String likeInfo = "%"+info+"%";
			pstmt.setString(++idx, likeInfo);
			pstmt.setString(++idx, likeInfo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getString("id"));
				userDto.setName(rs.getString("name"));
				userDto.setAddress(rs.getString("address"));
				userDto.setPhone(rs.getString("phone"));
				
				System.out.println(userDto.getId() + " " + userDto.getName());
				list.add(userDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public void delete(UserDto userDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from users \n");
			sql.append("where id=? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userDto.getId());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

}