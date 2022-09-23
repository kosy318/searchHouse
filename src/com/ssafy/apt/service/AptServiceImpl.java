package com.ssafy.apt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.apt.dao.AptDao;
import com.ssafy.apt.dao.AptDaoImpl;
import com.ssafy.apt.model.AddressDto;
import com.ssafy.apt.model.AptDto;
import com.ssafy.apt.model.DealInfoDto;
import com.ssafy.apt.model.SidoDto;

public class AptServiceImpl implements AptService {
	private static AptService aptService = new AptServiceImpl();
	private AptDao aptDao;

	private AptServiceImpl() {
		aptDao = AptDaoImpl.getAptDao();
	}

	public static AptService getAptService() {
		return aptService;
	}

//	@Override
//	public ArrayList<AddressDto> findAddress(Map<String, String> map) throws SQLException {
//		return aptDao.findAddress();
//	}

	@Override
	public ArrayList<DealInfoDto> search(String dong, String year, String month) throws SQLException {
		return aptDao.search(dong, year, month);
	}

	@Override
	public ArrayList<SidoDto> getSidoList() throws SQLException {
		return aptDao.getSidoList();
	}

}
