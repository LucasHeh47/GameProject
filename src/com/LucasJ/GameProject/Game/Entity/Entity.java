package com.LucasJ.GameProject.Game.Entity;

import java.awt.Color;
import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Math.Vector2D;

public abstract class Entity {
	
	protected Game game;
	
	protected Vector2D location;
	protected Vector2D size;
	
	protected Color color;
	
	public Entity(Game game, Vector2D location, Vector2D size) { 
		this.location = location;
		this.size = size;
		this.game = game;
	}
	
	public Entity(Game game) { 
		this.location = new Vector2D(0, 0);
		this.size = new Vector2D(0, 0);
		this.game = game;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
