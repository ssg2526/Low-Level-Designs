package com.ssg.flipfit.service;

import java.util.HashMap;
import java.util.Map;

import com.ssg.flipfit.domain.Center;
import com.ssg.flipfit.domain.Slot;
import com.ssg.flipfit.domain.User;
import com.ssg.flipfit.domain.Workout;

public class FlipFitService {
	
	Map<String, Center> centerMap = new HashMap<>();
	Map<String, User> userMap = new HashMap<>();
	
	public void init() {
		
	}
	
	public void addWorkout(String centerName, String workoutName, int slotStart, int slotEnd, int capacity) {
		Workout workout = new Workout(workoutName, capacity);
		if(centerMap.containsKey(centerName)) {
			Center ct = centerMap.get(centerName);
			if(ct.getSlots().containsKey(slotStart)) {
				Slot slot = ct.getSlots().get(slotStart);
				if(slot.getWorkouts().containsKey(workoutName)) {
					System.out.println("Workout already available for the given slot");
				} else {
					slot.getWorkouts().put(workoutName, workout);
				}
			} else {
				Slot slot = new Slot(slotStart, slotEnd);
				slot.getWorkouts().put(workoutName, workout);
				ct.getSlots().put(slotStart, slot);
			}
			System.out.println("Workout Added");
		} else {
			Slot slot = new Slot(slotStart, slotEnd);
			slot.getWorkouts().put(workoutName, workout);
			Center center = new Center(centerName);
			center.getSlots().put(slotStart, slot);
			centerMap.put(centerName, center);
			System.out.println("Workout Added");
		}	
	}
	
	public void register(String user) {
		userMap.put(user, new User(user));
		System.out.println("user "+user+ " registered");
	}
	
	public void viewWorkoutAvailability(String wts) {
		for(Map.Entry<String, Center> entry: centerMap.entrySet()) {
			Center c = entry.getValue();
			for(Map.Entry<Integer, Slot> slotEntry: c.getSlots().entrySet()) {
				Slot s = slotEntry.getValue();
//				System.out.println("Check "+s.getWorkouts().get("Yoga"));
				if(s.getWorkouts().containsKey(wts)) {
					Workout w = s.getWorkouts().get(wts);
					if(w.getCapacity() > 0) {
						System.out.println(c.getName()+", "+ wts+", "+s.getStart()+", "+s.getEnd()+", "+w.getCapacity());
					} else {
						System.out.println("No free slots");
					}
				}
			}
		}
	}
	
	public void bookSession(String user, String center, String workout, int slotStart, int slotEnd) {
		Center c = centerMap.get(center);
		Slot s = c.getSlots().get(slotStart);
		if(s != null) {
			Workout w = s.getWorkouts().get(workout);
			if(w != null) {
				if(w.getCapacity() > 0) {
					System.out.println("Slot booked for "+workout+" at "+c.getName());
					w.setCapacity(w.getCapacity()-1);
					User u = userMap.get(user);
					u.getDaySlotTime()[slotStart] = 1;
				} else {
					System.out.println("No Seats available");
				}
			} else {
				System.out.println("workout unavailable");
			}
		} else {
			System.out.println("Given Slot not available for this center");
		}
		
	}
	
	public void getNearestTimeSlot(String workout, String center, String user) {
		User u = userMap.get(user);
		Center c = centerMap.get(center);
		
	}

}
