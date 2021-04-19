package com.ssg.flipfit.domain;

import java.util.HashMap;
import java.util.Map;

public class Center {
	
	public Center(String name) {
		super();
		this.name = name;
		this.slots = new HashMap<>();
	}

	private String name;
	private Map<Integer, Slot> slots;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Integer, Slot> getSlots() {
		return slots;
	}

	public void setSlots(Map<Integer, Slot> slots) {
		this.slots = slots;
	}
	

}
