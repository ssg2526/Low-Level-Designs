package com.ssg.flipfit.domain;

import java.util.HashMap;
import java.util.Map;

public class Slot {
	public Slot(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		this.workouts = new HashMap<>(); 
	}
	private int start;
	private int end;
	private Map<String, Workout> workouts;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public Map<String, Workout> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(Map<String, Workout> workouts) {
		this.workouts = workouts;
	}
	
}
