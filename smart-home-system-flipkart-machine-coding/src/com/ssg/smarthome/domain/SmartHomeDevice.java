package com.ssg.smarthome.domain;

import java.util.Date;

public class SmartHomeDevice {
	
	public SmartHomeDevice(String catagory, String name, State state) {
		super();
		this.name = name;
		this.state = state;
		this.catagory = catagory;
		this.lastStartTime=0;
		this.totalUsageTime=0;
	}
	private String name;
	private State state;
	private String catagory;
	private long lastStartTime;
	private long totalUsageTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public long getLastStartTime() {
		return lastStartTime;
	}
	public void setLastStartTime(long lastStartTime) {
		this.lastStartTime = lastStartTime;
	}
	public long getTotalUsageTime() {
		return totalUsageTime;
	}
	public void setTotalUsageTime(long totalUsageTime) {
		this.totalUsageTime = totalUsageTime;
	}
	

}
