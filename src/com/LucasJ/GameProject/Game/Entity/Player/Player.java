package com.LucasJ.GameProject.Game.Entity.Player;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.InputHandler;
import com.LucasJ.GameProject.Game.Entity.DynamicEntity;

public class Player extends DynamicEntity{

	private boolean isSprinting = false;
	private double sprintSpeedMultiplier = 1.25;
	
	InputHandler input;
	
	public Player(Game game) {
		super(game);
		input = this.game.getInputHandler();
	}
	
	@Override
	public void tick(double deltaTime) {
		// Subtract because up is closer to 0
		if(input.W) this.setLocation(getLocation().subtractY(this.getMovementSpeed()*deltaTime));
		if(input.S) this.setLocation(getLocation().addY(this.getMovementSpeed()*deltaTime));
		
		if(input.A) this.setLocation(getLocation().subtractX(this.getMovementSpeed()*deltaTime));
		if(input.D) this.setLocation(getLocation().addX(this.getMovementSpeed()*deltaTime));
	}
	
	public boolean isSprinting() {
		return isSprinting;
	}
	public void setSprinting(boolean isSprinting) {
		this.isSprinting = isSprinting;
	}
	public double getSprintSpeedMultiplier() {
		return sprintSpeedMultiplier;
	}
	public Player setSprintSpeedMultiplier(double sprintSpeedMultiplier) {
		this.sprintSpeedMultiplier = sprintSpeedMultiplier;
		return this;
	}
	
}
