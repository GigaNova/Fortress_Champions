package com.fortress.factories;

import com.fortress.entities.Merc;
import com.fortress.helpers.TextureManager;

public class MercFactory {

	public static Merc createMerc(Merc.TEAM mercTeam, Merc.CLASS mercClass, Merc.ACTION mercAction) {
		Merc newMerc = new Merc(mercTeam, mercClass, mercAction);
		
		String teamString = "";
		switch(mercTeam) {
		case BLUE:
			teamString = "_blu";
			break;
		case RED:
			teamString = "_red";
			break;
		default:
			break;
		}
		
		switch(mercClass) {
		case DEMOMAN:
			newMerc.setSprite(TextureManager.loadSprite("classes/detonator" + teamString + ".png"));
			break;
		case ENGINEER:
			newMerc.setSprite(TextureManager.loadSprite("classes/constructor" + teamString + ".png"));
			break;
		case HEAVY:
			newMerc.setSprite(TextureManager.loadSprite("classes/overweight" + teamString + ".png"));
			break;
		case MEDIC:
			newMerc.setSprite(TextureManager.loadSprite("classes/healer" + teamString + ".png"));
			break;
		case PYRO:
			newMerc.setSprite(TextureManager.loadSprite("classes/firebug" + teamString + ".png"));
			break;
		case SCOUT:
			newMerc.setSprite(TextureManager.loadSprite("classes/runner" + teamString + ".png"));
			break;
		case SNIPER:
			newMerc.setSprite(TextureManager.loadSprite("classes/rifleman" + teamString + ".png"));
			break;
		case SOLDIER:
			newMerc.setSprite(TextureManager.loadSprite("classes/rocket_man" + teamString + ".png"));
			break;
		case NULL:
		default:
			break;
		}
		
		return newMerc;
	}
	
}
