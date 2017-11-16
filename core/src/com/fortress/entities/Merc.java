package com.fortress.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.fortress.helpers.MathHelper;
import com.fortress.helpers.TimeHelper;

public class Merc extends WorldObject{

	//Merc team
	public enum TEAM {
		RED,
		BLUE
	}
	
	//Merc classes
	public enum CLASS {
		NULL,
		SCOUT,
		SOLDIER,
		PYRO,
		DEMOMAN,
		HEAVY,
		SNIPER,
		ENGINEER,
		MEDIC
	}
	
	//AI Actions
	public enum ACTION {
		NULL,
		RANDOM_TEST,
		FOLLOW
	}
	
	public enum FACING {
		RIGHT,
		LEFT
	}
	
	//Enum vars
	private TEAM mercTeam;
	private CLASS mercClass;
	private ACTION currentAction;
	private FACING directionFacing;
	
	//Normal vars
	private float lookingAngle;
	private float speed = 1.5f;
	private WorldObject objectFollowing;
	private Vector2 targetLocation;
	
	//Debug vars
	public double R_TIMER = 0.0f;
	
	public Merc() {
		super();
	}
	
	public Merc(int x, int y) {
		super(null, x, y);
	}

	public Merc(TEAM mercTeam, CLASS mercClass, ACTION mercAction) {
		super();
		this.mercTeam = mercTeam;
		this.mercClass = mercClass;
		this.currentAction = mercAction;
		this.directionFacing = FACING.RIGHT;
	}

	@Override
	public void update() {
		position.x += Math.round((speed * Math.cos(lookingAngle * Math.PI / 180)) * (Gdx.graphics.getRawDeltaTime() * 50));
		position.y += Math.round((speed * Math.sin(lookingAngle * Math.PI / 180)) * (Gdx.graphics.getRawDeltaTime() * 50));
		setPosition(position);
		
		if(currentAction == ACTION.FOLLOW) {
			setLookingAngle(MathHelper.getAngleFromPoints(getPosition(), objectFollowing.getPosition()));	
		}
		else if(currentAction == ACTION.RANDOM_TEST) {
			/*if(Math.abs(R_TIMER - TimeHelper.getTotalTimeAsSeconds()) >= 1) {
				R_TIMER = TimeHelper.getTotalTimeAsSeconds();
				setTargetLocation(generateRandomLocation(480, 480));
			}*/
			
			if(position.x == targetLocation.x && position.y == targetLocation.y) {
				setTargetLocation(generateRandomLocation(480, 480));
			}
			
			if(position.x < targetLocation.x && this.directionFacing == FACING.LEFT) {
				sprite.flip(true, false);
				this.directionFacing = FACING.RIGHT;
			}
			else if(position.x >= targetLocation.x && this.directionFacing == FACING.RIGHT) {
				sprite.flip(true, false);
				this.directionFacing = FACING.LEFT;
			}
			
			setLookingAngle(MathHelper.getAngleFromPoints(getPosition(), targetLocation));	
		}
	}
	
	public float getLookingAngle() {
		return lookingAngle;
	}

	public void setLookingAngle(float lookingAngle) {
		this.lookingAngle = lookingAngle;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(sprite, position.x, position.y);
	}

	@Override
	public void dispose() {
		
	}

	public WorldObject getObjectFollowing() {
		return objectFollowing;
	}

	public void setObjectFollowing(WorldObject objectFollowing) {
		this.objectFollowing = objectFollowing;
	}

	public ACTION getCurrentAction() {
		return currentAction;
	}

	public void setCurrentAction(ACTION currentAction) {
		this.currentAction = currentAction;
	}

	public Vector2 getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(Vector2 targetLocation) {
		this.targetLocation = targetLocation;
	}

	public TEAM getMercTeam() {
		return mercTeam;
	}

	public void setMercTeam(TEAM mercTeam) {
		this.mercTeam = mercTeam;
	}

	public CLASS getMercClass() {
		return mercClass;
	}

	public void setMercClass(CLASS mercClass) {
		this.mercClass = mercClass;
	}

	public FACING getDirectionFacing() {
		return directionFacing;
	}

	public void setDirectionFacing(FACING directionFacing) {
		this.directionFacing = directionFacing;
	}
}
