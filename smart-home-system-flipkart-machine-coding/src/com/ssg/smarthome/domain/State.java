package com.ssg.smarthome.domain;

import java.util.Map;

public class State {
	
	
	public State(String name, int min, int max, int currentValue, String status) {
		super();
		this.name = name;
		this.min = min;
		this.max = max;
		this.currentValue = currentValue;
		this.status = status;
	}
	private String name;
	private int min;
	private int max;
	private int currentValue;
	private String status;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
