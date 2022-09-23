package com.ssafy.notice.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.notice.model.NoticeDto;

public interface NoticeDao {
	int writeNotice(NoticeDto noticeDto) throws SQLException;
	ArrayList<NoticeDto> listNotice(Map<String, String> map) throws SQLException;
	NoticeDto getNotice(int noticeNo) throws SQLException;
	void updateHit(int noticeNo) throws SQLException;
	void modifyNotice(NoticeDto noticeDto) throws SQLException;
	void deleteNotice(int noticeNo) throws SQLException;
}
