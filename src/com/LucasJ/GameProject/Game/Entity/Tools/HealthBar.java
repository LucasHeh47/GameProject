package com.LucasJ.GameProject.Game.Entity.Tools;

import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;

public class HealthBar {
	
	private int width, height;
	
	private DynamicEntity entity;
	
	private boolean isVisible;
	
	public HealthBar(DynamicEntity entity) {
		this.entity = entity;
		width = (int) entity.getSize().x;
		height = width/10;
	}
	
	public void update() {
		
	}
	
	private int mapHealth(double value) {
	    return (int) ((value) / (entity.getMaxHealth()) * (width));
	}
	
	public void setVisible(boolean vis) {
		isVisible = vis;
	}
	public boolean isVisible() {
		return isVisible;
	}
	
}
