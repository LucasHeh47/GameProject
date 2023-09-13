package com.LucasJ.GameProject.Game.Entity.Projectile;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Math.Vector2D;

public abstract class Projectile extends Entity {

	public Vector2D momentum;
	
	public Projectile(Game game, Vector2D location, Vector2D size) {
		super(game, location, size);
		momentum = new Vector2D(0, 0);
	}
	
	public void tick() {
		location.add(momentum.multiply(0.01));
	}
	
	public Projectile setMomentum(Vector2D momentum) {
		this.momentum = momentum;
		return this;
	}

}
