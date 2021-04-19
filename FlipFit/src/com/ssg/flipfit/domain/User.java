package com.ssg.flipfit.domain;

import java.util.Arrays;
import java.util.List;

public class User {
	
	public User(String name) {
		super();
		this.name = name;
		this.daySlotTime = new int[24];
//		Arrays.fill(this.daySlotTime, 0);
	}
	private String name;
	private int[] daySlotTime;
//	private Map<Integer, >
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getDaySlotTime() {
		return daySlotTime;
	}
	public void setDaySlotTime(int[] daySlotTime) {
		this.daySlotTime = daySlotTime;
	}

}
