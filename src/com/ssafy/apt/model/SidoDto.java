package com.ssafy.apt.model;

public class SidoDto {
	private String sidoCode;
	private String sidoName;

	public SidoDto() {
	}

	public SidoDto(String sidoCode, String sidoName) {
		this.sidoCode = sidoCode;
		this.sidoName = sidoName;
	}

	public String getSidoCode() {
		return sidoCode;
	}

	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

}
