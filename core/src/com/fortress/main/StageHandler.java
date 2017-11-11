package com.fortress.main;

import com.fortress.entities.TestEntity;
import com.fortress.stages.GameStage;

public class StageHandler{

	private GameStage currentStage;
	private TestEntity test;
	
	public StageHandler() {
		currentStage = null;
		test = new TestEntity();
	}
	
	public void update() {
		test.setError(new Error("I am an error!", Error.SEVERITY.LOW));
		ErrorHandler.check();
	}
}
