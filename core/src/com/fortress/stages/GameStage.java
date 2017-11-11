package com.fortress.stages;

public interface GameStage{

	//Called on stage switch.
    void startStage();
    
    //Called every cycle (Updating game logic).
    void update();
    
    //Called every cycle (Rendering).
    void render();
    
    //Called on closing (switching to other stage as well).
    void close();
    
    //Return to start menu.
    void returnToStart();
}
