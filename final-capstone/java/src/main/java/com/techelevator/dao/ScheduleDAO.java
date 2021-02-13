package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Schedule;

public interface ScheduleDAO {
	
	public void addNewSchedule(Schedule schedule);
	
	public void editSchedule(Schedule schedule);
	
	public List<Schedule> viewScheduleForMealPlan(int mealPlanId);
	
	public void deleteMealFromSchedule(int scheduleId, int mealId);
	
	public void BuildSchedule (List<Schedule> schedules);
	
	public void updateSchedule(List<Schedule> schedule);

}
