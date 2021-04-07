package com.ssg.smarthome;

import com.ssg.smarthome.service.SmartHomeService;

public class Applcation {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		SmartHomeService smService = new SmartHomeService();
		smService.initializeService();
		
//		adding devices interfaces
		smService.addInterfaceDevice("Alexa", "Alexa");
		smService.addInterfaceDevice("Google Home", "OK GOOGLE");
		
//		adding smart devices
		smService.addSmartHomeDevice(Category.FAN.name(), "Living Room Fan", "Google Home");
		smService.addSmartHomeDevice(Category.LIGHT.name(), "Drawing Room Light", "Alexa");
		smService.addSmartHomeDevice(Category.GENERIC.name(), "Smart Charger", "Alexa");
		
//		Commands for testing
		smService.giveCommand("OK GOOGLE", "Living Room Fan", "ON");
		smService.giveCommand("OK GOOGLE", "Living Room Fan", "SPEED#5");
		smService.giveCommand("OK GOOGLE", "Living Room Fan", "SPEED#7");
		
		Thread.sleep(3000);
		smService.giveCommand("Alexa", "Drawing Room Light", "ON");
		smService.giveCommand("Alexa", "Drawing Room Light", "BRIGHTNESS#8");
		
//		printing connected devices
		smService.printConnectedDevices("Alexa");
		Thread.sleep(2000);
		
//		Get Usage
		smService.printUsage();//TODO
	}

}
