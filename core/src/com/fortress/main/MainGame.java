package com.fortress.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends ApplicationAdapter {
	private StageHandler stageHandler;
	
	@Override
	public void create () {
		stageHandler = new StageHandler();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stageHandler.update();
		stageHandler.render();
	}
	
	@Override
	public void dispose () {
		WorldObjectHandler.dispose();
	}
}
