package com.fortress.main;

import com.fortress.stages.GameStage;
import com.fortress.stages.TestStage;

public class StageHandler{

	private GameStage currentStage;
	
	public StageHandler() {
		currentStage = new TestStage();
		currentStage.startStage();
	}
	
	public void update() {
		currentStage.update();
	}
	
	public void render() {
		currentStage.render();
	}
}
