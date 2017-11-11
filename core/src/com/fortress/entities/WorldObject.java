package com.fortress.entities;

import java.util.UUID;

import com.fortress.main.Error;
import com.fortress.main.ErrorHandler;

public abstract class WorldObject {
	
	private String _ID;
	private int xPos, yPos, zIndex;
	private Error error;
	
	public WorldObject() {
		_ID = UUID.randomUUID().toString();
		
		ErrorHandler.watchObject(this);
	}
	
	public WorldObject(int x, int y) {
		_ID = UUID.randomUUID().toString();
		xPos = x;
		yPos = y;
		zIndex = -1;
		
		ErrorHandler.watchObject(this);
	}
	
	public WorldObject(int x, int y, int z) {
		_ID = UUID.randomUUID().toString();
		xPos = x;
		yPos = y;
		zIndex = z;
		
		ErrorHandler.watchObject(this);
	}
	
	public String getId() {
		return _ID;
	}
	
	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getZ() {
		return zIndex;
	}

	public void setZ(int zIndex) {
		if(zIndex < 0) {
			System.out.println("Z index cannot be negative!");
			return;
		}
		this.zIndex = zIndex;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Error getError() {
		return error;
	}
	
	public boolean hasError() {
		return error != null;
	}
	
	public void clearError() {
		this.error = null;
	}
	
	public abstract void update();
	
	public abstract void render();
	
}
