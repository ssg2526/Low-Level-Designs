package com.ssg.flipfit;

import com.ssg.flipfit.service.FlipFitService;

public class Application {
	
	public static void main(String[] args) {
		FlipFitService flipfitService = new FlipFitService();
		
		flipfitService.init();
//		flipfitService.addWorkout("Koramangala", "Weights", 6, 7, 100);
//		flipfitService.addWorkout("Koramangala", "Cardio", 7, 8, 150);
//		flipfitService.addWorkout("Koramangala", "Yoga", 8, 9, 10);
//		flipfitService.addWorkout("Koramangala", "Yoga", 10, 11, 5);
//		flipfitService.addWorkout("Koramangala", "Yoga", 6, 7, 8);
		flipfitService.addWorkout("Koramangala", "Yoga", 6, 7, -1);
		
		
		flipfitService.addWorkout("Bellandur", "Weights", 18, 19, 100);
		flipfitService.addWorkout("Bellandur", "Cardio", 18, 19, 20);
		
		flipfitService.register("Saurabh");
//		flipfitService.register("Sagar");
		flipfitService.viewWorkoutAvailability("Yoga");
		
		flipfitService.bookSession("Saurabh", "Bellandur", "Yoga", 8, 9);
		
		flipfitService.viewWorkoutAvailability("Yoga");
		flipfitService.viewWorkoutAvailability("Weights");
		
	}

}
