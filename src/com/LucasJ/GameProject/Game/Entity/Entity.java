package com.LucasJ.GameProject.Game.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Math.Vector2D;

public abstract class Entity {
	
	protected Game game;
	
<<<<<<< Updated upstream
=======
	public List<EntityTags> tags;
	
>>>>>>> Stashed changes
	protected Vector2D location;
	protected Vector2D size;
	
	protected Color color;
	
	public Entity(Game game, Vector2D location, Vector2D size) { 
		tags = new ArrayList<>();
		this.location = location;
		this.size = size;
		this.game = game;
	}
	
	public Entity(Game game) { 
		tags = new ArrayList<>();
		this.location = new Vector2D(0, 0);
		this.size = new Vector2D(0, 0);
		this.game = game;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.drawRect((int)location.x, (int)location.y, 
				(int)size.x, (int)size.y);
	}
	
	public Entity addTag(EntityTags tag) {
		this.tags.add(tag);
		return this;
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
