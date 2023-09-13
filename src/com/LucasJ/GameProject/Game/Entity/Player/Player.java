package com.LucasJ.GameProject.Game.Entity.Player;

import com.LucasJ.GameProject.Game.Entity.DynamicEntity;

public class Player extends DynamicEntity{

	private boolean isSprinting = false;
	private double sprintSpeedMultiplier = 1.25;
	
	public Player() {
		
	}
	
	@Override
	public void tick(double deltaTime) {
		
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
