package com.ssg.smarthome.domain;

import java.util.HashMap;
import java.util.Map;

public class Device {
	
	public Device(String name, String activationKwy) {
		super();
		this.name = name;
		this.activationKwy = activationKwy;
		this.hmDevice = new HashMap<>();
	}
	private String name;
	private String activationKwy;
	private Map<String, SmartHomeDevice> hmDevice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getActivationKwy() {
		return activationKwy;
	}
	public void setActivationKwy(String activationKwy) {
		this.activationKwy = activationKwy;
	}
	public Map<String, SmartHomeDevice> getHmDevice() {
		return hmDevice;
	}
	public void setHmDevice(Map<String, SmartHomeDevice> hmDevice) {
		this.hmDevice = hmDevice;
	}
}
