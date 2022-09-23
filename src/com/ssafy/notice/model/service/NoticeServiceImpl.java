package com.ssafy.notice.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.ssafy.notice.model.NoticeDto;
import com.ssafy.notice.model.dao.NoticeDao;
import com.ssafy.notice.model.dao.NoticeDaoImpl;
import com.ssafy.util.SizeConstant;

public class NoticeServiceImpl implements NoticeService {

	private static NoticeService noticeService = new NoticeServiceImpl();
	private NoticeDao noticeDao;
	
	private NoticeServiceImpl() {
		noticeDao = NoticeDaoImpl.getNoticeDao();
	}

	public static NoticeService getNoticeService() {
		return noticeService;
	}

	@Override
	public int writeNotice(NoticeDto noticeDto) throws Exception {
		return noticeDao.writeNotice(noticeDto);
	}

	@Override
	public ArrayList<NoticeDto> listNotice(Map<String, String> map) throws Exception {
		return noticeDao.listNotice(map);
	}

	@Override
	public NoticeDto getNotice(int noticeNo) throws Exception {
		return noticeDao.getNotice(noticeNo);
	}

	@Override
	public void updateHit(int noticeNo) throws Exception {
		noticeDao.updateHit(noticeNo);
	}

	@Override
	public void modifyNotice(NoticeDto noticeDto) throws Exception {
		noticeDao.modifyNotice(noticeDto);
		
	}

	@Override
	public void deleteNotice(int noticeNo) throws Exception {
		noticeDao.deleteNotice(noticeNo);
	}

}
