package com.LucasJ.GameProject.Game.Entity;

public abstract class DynamicEntity extends Entity {

	private int health;
	private int maxHealth;
	
	private float movementSpeed;
	
	public DynamicEntity(int health, int maxHealth, int movementSpeed) {
		this.health = health;
		this.maxHealth = maxHealth;
		this.movementSpeed = movementSpeed;
	}
	public DynamicEntity() {
		this.health = 100;
		this.maxHealth = 100;
		this.movementSpeed = 5;
	}
	
	public void tick(double deltaTime) {
		
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
