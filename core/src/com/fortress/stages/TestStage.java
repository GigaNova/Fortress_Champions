package com.fortress.stages;


import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.fortress.entities.Merc;
import com.fortress.entities.Merc.ACTION;
import com.fortress.factories.MercFactory;
import com.fortress.helpers.MathHelper;
import com.fortress.helpers.TextureManager;
import com.fortress.helpers.TimeHelper;
import com.fortress.main.WorldObjectHandler;

public class TestStage implements GameStage {

	private Merc testMerc, testMerc2;
	private SpriteBatch batch = new SpriteBatch();
	private Sprite background;
	
	@Override
	public void startStage() {
		background = TextureManager.loadSprite("backgrounds/debug.png");
		
		testMerc = MercFactory.createMerc(Merc.TEAM.BLUE, Merc.CLASS.SOLDIER, Merc.ACTION.RANDOM_TEST);
		testMerc2 = MercFactory.createMerc(Merc.TEAM.RED, Merc.CLASS.SOLDIER, Merc.ACTION.RANDOM_TEST);
		
		testMerc.setCurrentAction(ACTION.RANDOM_TEST);
		testMerc.setTargetLocation(testMerc.generateRandomLocation(480, 480));
		
		testMerc2.setCurrentAction(ACTION.RANDOM_TEST);
		testMerc2.setTargetLocation(testMerc2.generateRandomLocation(480, 480));
	}

	@Override
	public void update() {
		TimeHelper.update();
		if(WorldObjectHandler.hasObjects()) {
			WorldObjectHandler.update();
			WorldObjectHandler.check();	
		}
	}

	@Override
	public void render() {
		batch.begin();
		batch.draw(background, 0, 0);
		WorldObjectHandler.render(batch);
		batch.end();
	}

	@Override
	public void close() {
		
	}

	@Override
	public void returnToStart() {
		// TODO Auto-generated method stub
		
	}
}
