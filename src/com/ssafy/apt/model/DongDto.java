package com.ssafy.apt.model;

public class DongDto {
	private String dongCode;
	private String sidoName;
	private String gugunName;
	private String dongName;

	public DongDto() {
	}

	public DongDto(String dongCode, String sidoName, String gugunName) {
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

}
