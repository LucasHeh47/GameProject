package com.LucasJ.GameProject.Game.Entity.Projectile;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Game.Entity.EntityTags;
import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;
import com.LucasJ.GameProject.Math.Vector2D;

public class Bullet extends Projectile{

	public Bullet(Game game, Vector2D location, Vector2D size, int damage) {
		super(game, location, size, damage);
	}
	
	@Override
	public void tick(double deltaTime) {
		super.tick(deltaTime);

        checkCollisions();
	}
	
	private void checkCollisions() {
        this.collisions.forEach(x -> {
            if(x instanceof DynamicEntity)
                x.tags.forEach(tag -> {
                    if(tag == EntityTags.Enemy) {
                        ((DynamicEntity) x).takeDamage(damage);
                        onDestroy();
                    }
                });
        });
    }
	
	public void onDestroy() {
		Entity.activeEntities.remove(this);
	}

}
