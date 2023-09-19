package com.LucasJ.GameProject.Game.Entity.Projectile;

import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Game.Entity.EntityTags;
import com.LucasJ.GameProject.Math.Vector2D;

public abstract class Projectile extends Entity {

	public Vector2D momentum;
	
	public int damage;
	
	public double timeAlive;
	
	private double lastTick = 0;
	
	public Projectile(Game game, Vector2D location, Vector2D size, int damage) {
		super(game, location, size);
		this.damage = damage;
		tags.add(EntityTags.Projectile);
		momentum = new Vector2D(0, 0);
	    timeAlive = 0;
	    lastTick = System.currentTimeMillis(); 
	}
	
	public void tick(double deltaTime) {
		super.tick(deltaTime);
	    double currentTick = System.currentTimeMillis();
	    timeAlive += currentTick - lastTick;
		setLocation(location.add(momentum.multiply(0.01).multiply(deltaTime)));
		
		if(location.x <= 0 || location.x >= game.resolution.x) this.onDestroy();
		if(location.y <= 0 || location.y >= game.resolution.y) this.onDestroy();
		
	    lastTick = currentTick;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(
				location.toDimension().width, 
				location.toDimension().height, 
				size.toDimension().width, 
				size.toDimension().height);
	}
	
	public Projectile setMomentum(Vector2D momentum) {
		this.momentum = momentum;
		return this;
	}
	
	public abstract void onDestroy();

}
