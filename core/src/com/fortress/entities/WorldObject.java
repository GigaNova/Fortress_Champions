package com.fortress.entities;

import java.util.Random;
import java.util.UUID;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.fortress.main.Error;
import com.fortress.main.WorldObjectHandler;

public abstract class WorldObject{
	
	protected String _ID;
	protected Error error;
	private boolean checkedForRemoval;
	protected Sprite sprite;
	protected Vector2 position;

	public WorldObject() {
		_ID = UUID.randomUUID().toString();
		this.position = new Vector2(0, 0);
		
		WorldObjectHandler.watchObject(this);
	}
	
	public WorldObject(Sprite sprite, int x, int y) {
		_ID = UUID.randomUUID().toString();
		this.sprite = sprite;
		this.position = new Vector2(x, y);
		
		WorldObjectHandler.watchObject(this);
	}
	
	public WorldObject(Sprite sprite, int x, int y, int z) {
		_ID = UUID.randomUUID().toString();
		this.sprite = sprite;
		this.position = new Vector2(x, y);
		
		WorldObjectHandler.watchObject(this);
	}
	
	public String getId() {
		return _ID;
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
	
	public boolean isCheckedForRemoval() {
		return checkedForRemoval;
	}

	public void setCheckedForRemoval(boolean checkedForRemoval) {
		this.checkedForRemoval = checkedForRemoval;
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 generateRandomLocation(int boundX, int boundY) {
		Random rand = new Random();
		return new Vector2(rand.nextInt(boundX), rand.nextInt(boundY));
	}
	
	public abstract void update();
	
	public abstract void render(SpriteBatch batch);
	
	public abstract void dispose();
	
}
