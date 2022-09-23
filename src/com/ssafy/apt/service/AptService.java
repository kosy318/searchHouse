package com.ssafy.apt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.ssafy.apt.model.AddressDto;
import com.ssafy.apt.model.AptDto;
import com.ssafy.apt.model.DealInfoDto;
import com.ssafy.apt.model.SidoDto;

public interface AptService {

//	ArrayList<Object> findAddress(Map<String, String> map) throws SQLException;
	ArrayList<SidoDto> getSidoList() throws SQLException;
	ArrayList<DealInfoDto> search(String dong, String year, String month) throws SQLException;

}
