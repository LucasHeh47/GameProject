package com.LucasJ.GameProject.Game.Entity.Dynamic;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Math.Vector2D;

public abstract class DynamicEntity extends Entity {
	
	public static List<DynamicEntity> activeDynamicEntities = new ArrayList<>();

	protected int health;
	protected int maxHealth;
	
	protected float movementSpeed;
	
	public DynamicEntity(Game game, int health, int maxHealth, int movementSpeed) {
		super(game);
		this.health = health;
		this.maxHealth = maxHealth;
		this.movementSpeed = movementSpeed;
		activeDynamicEntities.add(this);
	}
	public DynamicEntity(Game game) {
		super(game);
		this.health = 100;
		this.maxHealth = 100;
		this.movementSpeed = 5;
		activeDynamicEntities.add(this);
	}
	
	public void tick(double deltaTime) {
		super.tick(deltaTime);
	}
	
	public void render(Graphics g) {
		super.render(g);
	}
	
	public void move(Vector2D movement) {
		Vector2D newLocation = getLocation().add(movement).clamp(0, game.resolution.x - size.x, 0, game.resolution.y - size.y);
		setLocation(newLocation);
	}
	
	public void takeDamage(int damage) {
		setHealth(getHealth()-damage);
	}

	public int getHealth() {
		return health;
	}

	public DynamicEntity setHealth(int health) {
		this.health = health;
		return this;
	}

	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void onDestroy() {
		super.onDestroy();
		activeDynamicEntities.remove(this);
	}

	public DynamicEntity setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
		return this;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public DynamicEntity setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
		return this;
	}
	
}
