package com.LucasJ.GameProject.Game.Entity;

import java.awt.Color;
import java.awt.Graphics;

import com.LucasJ.GameProject.Math.Vector2D;

public abstract class Entity {
	
	private Vector2D location;
	private Vector2D size;
	
	private Color color;
	
	public Entity(Vector2D location, Vector2D size) { 
		this.location = location;
		this.size = size;
	}
	
	public Entity() { 
		this.location = new Vector2D(0, 0);
		this.size = new Vector2D(0, 0);
	}
	
	public void render(Graphics g) {
		g.drawRect((int)location.x, (int)location.y, 
				(int)size.x, (int)size.y);
	}
	
	public Vector2D getLocation() {
		return location;
	}
	public Entity setLocation(Vector2D location) {
		this.location = location;
		return this;
	}
	public Vector2D getSize() {
		return size;
	}
	public Entity setSize(Vector2D size) {
		this.size = size;
		return this;
	}
	
	
	
}
