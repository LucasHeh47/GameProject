package com.LucasJ.GameProject.Game.Entity;

import java.util.ArrayList;
import java.util.List;

import com.LucasJ.GameProject.Game.Game;
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
		
	}
	
	public void move(Vector2D movement) {
		setLocation(getLocation().add(movement));
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
