package com.LucasJ.GameProject.Game.Entity.Dynamic.Enemy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;
import com.LucasJ.GameProject.Game.Entity.Player.Player;
import com.LucasJ.GameProject.Game.Entity.Tools.HealthBar;
import com.LucasJ.GameProject.Math.Vector2D;

public class Enemy extends DynamicEntity {

	public static List<Enemy> enemiesActive = new ArrayList<>();
	
	private Entity target;
	private boolean isAggrovated = true;
	private int rangeTooAggrovate;
	private int damage;
	
	private HealthBar healthBar;
	
	public Enemy(Game game, int health, int maxHealth, int movementSpeed) {
		super(game, health, maxHealth, movementSpeed);
		healthBar = new HealthBar(this);
		enemiesActive.add(this);
		healthBar.setHeight((int) getSize().x/4);
		healthBar.setWidth((int) (getSize().x*1.5));
	}
	
	public Enemy(Game game) {
		super(game);
		healthBar = new HealthBar(this);
		enemiesActive.add(this);
		healthBar.setHeight((int) getSize().x/4);
		healthBar.setWidth((int) (getSize().x*1.5));
	}
	
	public void tick(double deltaTime) {
		super.tick(deltaTime);
		if(isAggrovated) move();
	}
	
	public void render(Graphics g) {
		super.render(g);
		if(health != maxHealth) healthBar.render(g);
	}

	public void move() {
		double dx = target.getLocation().x - getLocation().x;
	    double dy = target.getLocation().y - getLocation().y;

	    // Calculate the angle
	    double theta = Math.atan2(dy, dx);

	    double velX = movementSpeed * Math.cos(theta);
	    double velY = movementSpeed * Math.sin(theta);
	    
	    setLocation(getLocation().add(new Vector2D(velX, velY)));
	    
	    for (Entity entity : this.collisions) {
	    	if (entity instanceof Player) {
	    		this.onDeath();
	    		((Player) entity).takeDamage(damage);
	    	}
	    }
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

	public int getDamage() {
		return damage;
	}

	public Enemy setDamage(int damage) {
		this.damage = damage;
		return this;
	}
	

}
