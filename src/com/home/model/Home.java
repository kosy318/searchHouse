package com.home.model;

public class Home {
	private String aptCode;
	private String apartmentName;
	private String dealAmount;
	private String dongCode;
	private String dong;
	private String buildYear;
	private String lng;
	private String lat;

	public Home() {}

	public Home(String aptCode, String apartmentName, String dealAmount, String dongCode, String dong, String buildYear, String lng,
			String lat) {
		super();
		this.aptCode = aptCode;
		this.apartmentName = apartmentName;
		this.dealAmount = dealAmount;
		this.dongCode = dongCode;
		this.dong = dong;
		this.buildYear = buildYear;
		this.lng = lng;
		this.lat = lat;
	}

	public String getAptCode() {
		return aptCode;
	}

	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}

	public String getApartmentName() {
		return apartmentName;
	}

	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

}
