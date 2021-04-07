package com.ssg.smarthome.service;

import java.util.HashMap;
import java.util.Map;

import com.ssg.smarthome.Category;
import com.ssg.smarthome.StateAttributes;
import com.ssg.smarthome.StateEnum;
import com.ssg.smarthome.domain.Device;
import com.ssg.smarthome.domain.SmartHomeDevice;
import com.ssg.smarthome.domain.State;

public class SmartHomeService {
	
	public SmartHomeService() {
		super();
		this.deviceIdMap = new HashMap<>();
		this.deviceMap = new HashMap<>();
		this.categoryAttribMap = new HashMap<>();
	}

	Map<String, Device> deviceMap;
	Map<String, Device> deviceIdMap;
	Map<String, State> categoryAttribMap;
	
	public void initializeService(){//initial data
		categoryAttribMap.put(Category.FAN.name(), new State(StateAttributes.SPEED.name(), 0, 5, 0, StateEnum.OFF.name()));
		categoryAttribMap.put(Category.LIGHT.name(), new State(StateAttributes.BRIGHTNESS.name(), 0, 10, 0, StateEnum.OFF.name()));
		categoryAttribMap.put(Category.GENERIC.name(), new State(null, 0, 0, 0, StateEnum.OFF.name()));
	}
	
	public void addInterfaceDevice(String name, String activationKey) {
		Device device = new Device(name, activationKey );
		deviceMap.put(activationKey, device);
		deviceIdMap.put(device.getName(), device);
	}
	public void addSmartHomeDevice(String category, String name, String deviceName) {
		SmartHomeDevice homeDevice = new SmartHomeDevice(category, name, categoryAttribMap.get(category));
		if(!deviceIdMap.containsKey(deviceName)) {
			System.out.println("No Device Added: "+deviceName);
		} else {
			deviceIdMap.get(deviceName).getHmDevice().put(name, homeDevice);
		}
	}
	
	public void printConnectedDevices(String deviceName) {
		System.out.println("***********************************************************");
		Device device = deviceIdMap.get(deviceName);
		if(device==null) {
			System.out.println("No device found");
			return;
		}
		Map<String, SmartHomeDevice> smMap= device.getHmDevice();
		int i=1;
		for(Map.Entry<String, SmartHomeDevice> entry: smMap.entrySet()) {
			SmartHomeDevice smd = entry.getValue();
			String details = (smd.getState().getName()==null)?"":("["+ smd.getState().getName()+"="+smd.getState().getCurrentValue() +"]");
			System.out.println(i+"	"+smd.getCatagory()+"		"+smd.getName()+"		"+smd.getState().getStatus()+details);
			i++;
		}
	}
	
	public void giveCommand(String activationKey, String smartDeviceName, String commandStr) {
		String[] commandList = commandStr.split("#");
		if(!deviceMap.containsKey(activationKey)) {
			System.out.println("No device exists for the given command");
			return;
		}
		SmartHomeDevice smd = deviceMap.get(activationKey).getHmDevice().get(smartDeviceName);
		if(smd == null) {
			System.out.println("No smart device attached with name: "+smartDeviceName +" for given command");
		}
		if(commandList.length == 1) {
			deviceMap.get(activationKey).getHmDevice().get(smartDeviceName).getState().setStatus(commandList[0]);
			if(commandList[0].equals(StateEnum.ON.name())) {
				smd.setLastStartTime(System.currentTimeMillis());
			} else {
				smd.setTotalUsageTime(smd.getTotalUsageTime()+(System.currentTimeMillis() - smd.getLastStartTime())/1000);
			}
			
			System.out.println("Ok, "+smartDeviceName+" turned "+commandList[0]);
		}else {
			if("OFF".equalsIgnoreCase(smd.getState().getStatus())){
				System.out.println("Sorry the "+smartDeviceName+ " in not ON");
			}
			else if(Integer.parseInt(commandList[1]) > smd.getState().getMax() || Integer.parseInt(commandList[1]) > smd.getState().getMax()) {
				System.out.println("Sorry the action is beyond regulating limits");
			} else {
				deviceMap.get(activationKey).getHmDevice().get(smartDeviceName).getState().setCurrentValue(Integer.parseInt(commandList[1]));
				System.out.println("Ok, "+smartDeviceName+" "+commandList[0]+ " set to "+commandList[1] );
			}
		}
	}
	
	public void printUsage() {
		int count = 1;
		System.out.println("***********************************************************");
		for(Map.Entry<String, Device> entry: deviceIdMap.entrySet()) {
			Device d = entry.getValue();
			for(Map.Entry<String, SmartHomeDevice> smdSet: d.getHmDevice().entrySet()) {
				SmartHomeDevice smd = smdSet.getValue();
				long usage = 0;
				if(smd.getState().getStatus().equals(StateEnum.ON.name())) {
					usage = smd.getTotalUsageTime()+(System.currentTimeMillis() - smd.getLastStartTime())/1000;
				} else {
					usage = smd.getTotalUsageTime();
				}
				
				System.out.println(count+"		"+smd.getName()+"		"+usage);
				count++;
			}
		}
	}
 
}
