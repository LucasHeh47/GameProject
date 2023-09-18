package com.LucasJ.GameProject.Game.Entity.Dynamic.Enemy;

import java.util.ArrayList;
import java.util.List;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;
import com.LucasJ.GameProject.Math.Vector2D;

public class Enemy extends DynamicEntity {

	public static List<Enemy> enemiesActive = new ArrayList<>();
	
	private Entity target;
	private boolean isAggrovated = true;
	private int rangeTooAggrovate;
	
	public Enemy(Game game, int health, int maxHealth, int movementSpeed) {
		super(game, health, maxHealth, movementSpeed);
		enemiesActive.add(this);
	}
	
	public Enemy(Game game) {
		super(game);
		enemiesActive.add(this);
	}
	
	public void tick(double deltaTime) {
		super.tick(deltaTime);
		if(isAggrovated) move();
	}

	public void move() {
		double dx = target.getLocation().x - getLocation().x;
	    double dy = target.getLocation().y - getLocation().y;

	    // Calculate the angle
	    double theta = Math.atan2(dy, dx);

	    double velX = movementSpeed * Math.cos(theta);
	    double velY = movementSpeed * Math.sin(theta);
	    
	    setLocation(getLocation().add(new Vector2D(velX, velY)));
	}
	public void aggrevation() {
		
	}
	public void onDeath() {
		super.onDestroy();
		enemiesActive.remove(this);
	}

	public Entity getTarget() {
		return target;
	}

	public Enemy setTarget(Entity target) {
		this.target = target;
		return this;
	}

	public boolean isAggrovated() {
		return isAggrovated;
	}

	public Enemy setAggrovated(boolean isAggrovated) {
		this.isAggrovated = isAggrovated;
		return this;
	}

	public int getRangeTooAggrovate() {
		return rangeTooAggrovate;
	}

	public void setRangeTooAggrovate(int rangeTooAggrovate) {
		this.rangeTooAggrovate = rangeTooAggrovate;
	}
	

}
