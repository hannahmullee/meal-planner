package com.techelevator.model;

public class Schedule {
	
	private int scheduleId;
	private int mealPlanId;
	private int mealId;
	private String mealName;
	private String dayOfWeek;
	private String timeOfDay;
	
	
	public Schedule(int scheduleId, int mealPlanId, int mealId, String mealName, String dayOfWeek, String timeOfDay) {
		super();
		this.scheduleId = scheduleId;
		this.mealPlanId = mealPlanId;
		this.mealId = mealId;
		this.mealName = mealName;
		this.dayOfWeek = dayOfWeek;
		this.timeOfDay = timeOfDay;
	}
	
	public Schedule () {}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getMealPlanId() {
		return mealPlanId;
	}

	public void setMealPlanId(int mealPlanId) {
		this.mealPlanId = mealPlanId;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	
	

}
