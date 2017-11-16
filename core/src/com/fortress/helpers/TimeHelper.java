package com.fortress.helpers;

public class TimeHelper {

	private static final double START_TIME = System.currentTimeMillis();
	private static double totalTime = 0.0d;
	
	public static void update() {
		totalTime = System.currentTimeMillis() - START_TIME;
	}
	
	public static double getTotalTime() {
		return totalTime;
	}
	
	public static double getTotalTimeAsSeconds() {
		return totalTime / 1000.0d;
	}
}
