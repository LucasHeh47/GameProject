package com.LucasJ.GameProject.Game.Entity.Player;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.InputHandler;
import com.LucasJ.GameProject.Game.Entity.DynamicEntity;
import com.LucasJ.GameProject.Math.Vector2D;

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
		Vector2D movement = new Vector2D(0, 0);

	    if(input.W) movement = movement.add(new Vector2D(0, this.getMovementSpeed() * deltaTime * -1));
	    if(input.S) movement = movement.add(new Vector2D(0, this.getMovementSpeed() * deltaTime));
	    if(input.A) movement = movement.add(new Vector2D(this.getMovementSpeed() * deltaTime * -1, 0));
	    if(input.D) movement = movement.add(new Vector2D(this.getMovementSpeed() * deltaTime, 0));

	    if(movement.magnitude() > 0) {
	        movement = movement.normalize().multiply(this.getMovementSpeed() * deltaTime);
	    }

	    this.move(movement);
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
