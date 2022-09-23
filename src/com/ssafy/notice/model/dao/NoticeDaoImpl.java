package com.ssafy.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.notice.model.NoticeDto;
import com.ssafy.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao {

	private static NoticeDao noticeDao = new NoticeDaoImpl();
	private DBUtil dbUtil;
	
	private NoticeDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static NoticeDao getNoticeDao() {
		return noticeDao;
	}
	
	@Override
	public int writeNotice(NoticeDto noticeDto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into notices (title, content, regdate, count) \n");
			sql.append("values (?, ?, now(), 0)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContent());
			cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public ArrayList<NoticeDto> listNotice(Map<String, String> map) throws SQLException {
		ArrayList<NoticeDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select num, title, content, regdate, count \n");
			sql.append("from notices \n");
			String key = map.get("key");
			String word = map.get("word");
			if(!word.isEmpty()) {
				if("title".equals(key))
					sql.append("where title like ? \n");
				else
					sql.append("where num = ? \n");
			}
			sql.append("order by num desc");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if(!word.isEmpty()) {
				if("title".equals(key))
					pstmt.setString(++idx, "%" + word + "%");
				else 
					pstmt.setString(++idx, word);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDto noticeDto = new NoticeDto();
				noticeDto = new NoticeDto();
				noticeDto.setNum(rs.getInt("num"));
				noticeDto.setTitle(rs.getString("title"));
				noticeDto.setContent(rs.getString("content"));
				noticeDto.setRegdate(rs.getString("regdate"));
				noticeDto.setCount(rs.getInt("count"));
				
				list.add(noticeDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public NoticeDto getNotice(int num) throws SQLException {
		NoticeDto noticeDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select num, title, content, regdate, count \n");
			sql.append("from notices \n");
			sql.append("where num = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				noticeDto = new NoticeDto();
				noticeDto.setNum(rs.getInt("num"));
				noticeDto.setTitle(rs.getString("title"));
				noticeDto.setContent(rs.getString("content"));
				noticeDto.setRegdate(rs.getString("regdate"));
				noticeDto.setCount(rs.getInt("count"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return noticeDto;
	}

	@Override
	public void updateHit(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update notices \n");
			sql.append("set count = count + 1 \n");
			sql.append("where num = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void modifyNotice(NoticeDto noticeDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update notices \n");
			sql.append("set title=?, content=? \n");
			sql.append("where num = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContent());
			pstmt.setInt(3, noticeDto.getNum());

			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}		
	}

	@Override
	public void deleteNotice(int num) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from notices \n");
			sql.append("where num = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
