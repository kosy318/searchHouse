package com.ssafy.home.model;

public class DealInfo {
	private int aptCode;
	private String aptName;
	private String area;
	private String floor;
	private String dealAmount;
	private String dongName;
	public DealInfo() {
	}
	public DealInfo(int aptCode, String aptName, String area, String floor, String dealAmount, String dongName) {
		this.aptName = aptName;
		this.area = area;
		this.floor = floor;
		this.dealAmount = dealAmount;
		this.dongName = dongName;
	}
	public int getAptCode() {
		return aptCode;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	
	
	
}
