package com.LucasJ.GameProject.Game.Entity.Tools;

import java.awt.Color;
import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;

public class HealthBar {
	
	private int width, height;
	
	private DynamicEntity entity;
	
	private boolean isVisible;
	
	public HealthBar(DynamicEntity entity) {
		this.entity = entity;
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		if (width == 0 && height == 0) {
			setHeight((int) entity.getSize().x/4);
			setWidth((int) (entity.getSize().x*1.5));
		}
		g.setColor(Color.gray);
		g.fillRect((int) (entity.getLocation().x + width-entity.getSize().x*1.75), (int) (entity.getLocation().y - height*1.5), 
				width, height);

		g.setColor(Color.red);
		g.fillRect((int) (entity.getLocation().x + width-entity.getSize().x*1.75), (int) (entity.getLocation().y - height*1.5), 
				mapHealth(entity.getHealth()), height);
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

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
