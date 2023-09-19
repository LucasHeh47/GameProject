package com.LucasJ.GameProject.Game.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Math.Vector2D;

public abstract class Entity {
	
	public static List<Entity> activeEntities = new ArrayList<>();
	
	protected Game game;
	
	public List<Entity> collisions;
	
	public List<EntityTags> tags;
	
	protected Vector2D location;
	protected Vector2D size;
	
	protected Color color;
	
	public Entity(Game game, Vector2D location, Vector2D size) { 
		tags = new ArrayList<>();
		this.location = location;
		this.size = size;
		this.game = game;
		collisions = new ArrayList<>();
		activeEntities.add(this);
	}
	
	public Entity(Game game) { 
		tags = new ArrayList<>();
		this.location = new Vector2D(0, 0);
		this.size = new Vector2D(0, 0);
		this.game = game;
		collisions = new ArrayList<>();
		activeEntities.add(this);
	}
	
	public void tick(double deltaTime) {
		// Clear the existing collisions for the current frame
	    collisions.clear();

	    for (Entity otherEntity : activeEntities) {
	        // Avoid self-collision check
	        if (this == otherEntity) continue;

	        // Check for collision using AABB
	        if (location.x < otherEntity.location.x + otherEntity.size.x &&
	            location.x + size.x > otherEntity.location.x &&
	            location.y < otherEntity.location.y + otherEntity.size.y &&
	            location.y + size.y > otherEntity.location.y) {
	            
	            // There is a collision
	            collisions.add(otherEntity);
	        }
	    }
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect((int)location.x, (int)location.y, 
				(int)size.x, (int)size.y);
	}
	
	public void onDestroy() {
		activeEntities.remove(this);
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

	public Entity setColor(Color color) {
		this.color = color;
		return this;
	}
	
	
	
}
