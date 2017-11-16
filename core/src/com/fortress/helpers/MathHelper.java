package com.fortress.helpers;

import com.badlogic.gdx.math.Vector2;

public class MathHelper {

	public static float getAngleFromPoints(Vector2 base, Vector2 target) {
	    float angle = (float) Math.toDegrees(Math.atan2(target.y - base.y, target.x - base.x));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
}
