package com.LucasJ.GameProject.Game.Entity.Projectile;

import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Game.Entity.EntityTags;
import com.LucasJ.GameProject.Math.Vector2D;

public abstract class Projectile extends Entity {

	public Vector2D momentum;
	
	public int damage;
	
	public Projectile(Game game, Vector2D location, Vector2D size, int damage) {
		super(game, location, size);
		this.damage = damage;
		tags.add(EntityTags.Projectile);
		momentum = new Vector2D(0, 0);
	}
	
	public void tick(double deltaTime) {
		super.tick(deltaTime);
		location.add(momentum.multiply(0.01).multiply(deltaTime));
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.drawOval(
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
