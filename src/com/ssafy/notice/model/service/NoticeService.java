package com.ssafy.notice.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.ssafy.notice.model.NoticeDto;

public interface NoticeService {

	int writeNotice(NoticeDto noticeDto) throws Exception;
	ArrayList<NoticeDto> listNotice(Map<String, String> map) throws Exception;
	NoticeDto getNotice(int noticeNo) throws Exception;
	void updateHit(int noticeNo) throws Exception;
	void modifyNotice(NoticeDto noticeDto) throws Exception;
	void deleteNotice(int noticeNo) throws Exception;
}
