package com.ssafy.apt.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.apt.model.AddressDto;
import com.ssafy.apt.model.AptDto;
import com.ssafy.apt.model.DealInfoDto;
import com.ssafy.apt.model.SidoDto;

public interface AptDao {

//	ArrayList<Object> findAddress() throws SQLException;
	ArrayList<DealInfoDto> search(String dong, String year, String month) throws SQLException;

	ArrayList<SidoDto> getSidoList() throws SQLException; 
}
