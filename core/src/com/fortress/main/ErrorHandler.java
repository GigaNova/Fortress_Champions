package com.fortress.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.fortress.entities.WorldObject;
import com.fortress.main.Error;

public class ErrorHandler {

	private static HashMap<String, WorldObject> worldObjects = new HashMap<String, WorldObject>();
	private static ArrayList<Error> errorLog = new ArrayList<Error>();
	
	public static void watchObject(WorldObject object) {
		worldObjects.put(object.getId(), object);
	}
	
	public static void unwatchObject(String ID) {
		if(worldObjects.containsKey(ID)) {
			worldObjects.remove(ID);	
		}
	}
	
	public static void check() {
		for(WorldObject object : worldObjects.values()) {
			if(object.hasError()) {
				Error thisError = object.getError();
				System.out.println(object.getId() + "@" + object.getClass().getSimpleName() + ": " + thisError.getMessage());
				if(thisError.getSeverity() == Error.SEVERITY.LOW) {
					object.clearError();
					errorLog.add(thisError);
				}
			}
		}
	}
}
