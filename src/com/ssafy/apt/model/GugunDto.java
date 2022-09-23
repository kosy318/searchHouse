package com.ssafy.apt.model;

public class GugunDto {
	private String gugunCode;
	private String gugunName;

	public GugunDto() {
	}

	public GugunDto(String gugunCode, String gugunName) {
		this.gugunCode = gugunCode;
		this.gugunName = gugunName;
	}

	public String getGugunCode() {
		return gugunCode;
	}

	public void setGugunCode(String gugunCode) {
		this.gugunCode = gugunCode;
	}

	public String getGugunName() {
		return gugunName;
	}

	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

}
