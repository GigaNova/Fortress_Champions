package com.fortress.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.fortress.entities.Merc;
import com.fortress.entities.WorldObject;
import com.fortress.helpers.MathHelper;
import com.fortress.main.Error;

public class WorldObjectHandler {

	private static HashMap<String, Merc> mercs = new HashMap<String, Merc>();
	private static HashMap<String, WorldObject> worldObjects = new HashMap<String, WorldObject>();
	private static ArrayList<Error> errorLog = new ArrayList<Error>();
	
	public static void watchObject(WorldObject object) {
		worldObjects.put(object.getId(), object);
		if(object instanceof Merc) {
			mercs.put(object.getId(), (Merc)object);
		}
	}
	
	public static void unwatchObject(String ID) {
		if(worldObjects.containsKey(ID)) {
			worldObjects.remove(ID);	
			if(mercs.containsKey(ID)) {
				mercs.remove(ID);
			}
		}
	}

	public static void update() {
		for(WorldObject object : worldObjects.values()) {
			object.update();
		}
	}
	
	public static void render(SpriteBatch batch) {
		for(WorldObject object : worldObjects.values()) {
			object.render(batch);
		}
	}
	
	public static void check() {
		for(WorldObject object : worldObjects.values()) {
			if(object.hasError()) {
				Error thisError = object.getError();
				System.out.println(object.getId() + "@" + object.getClass().getSimpleName() + ": " + thisError.getMessage());
				if(thisError.getSeverity() == Error.SEVERITY.LOW || thisError.getSeverity() == Error.SEVERITY.MEDIUM) {
					object.clearError();
					errorLog.add(thisError);
				}
			}
		}
	}
	
	public static boolean hasObjects() {
		return worldObjects.size() != 0;
	}
	
	public static void dispose() {
		if(errorLog.size() != 0) {
			
		}
	}
}
