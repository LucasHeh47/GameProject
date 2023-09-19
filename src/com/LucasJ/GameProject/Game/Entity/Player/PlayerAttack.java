package com.LucasJ.GameProject.Game.Entity.Player;

import java.awt.Color;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.Projectile.Bullet;
import com.LucasJ.GameProject.Math.Vector2D;

public class PlayerAttack {

	private Game game;
	private Player player;
	
	public PlayerAttack(Game game, Player player) {
		this.game = game;
		this.player = player;
		
		
	}
	
	public void attack(Vector2D mouseLocation) {
	    Bullet bullet = new Bullet(game, player.getLocation(), new Vector2D(5, 5), player.playerDamage);
	    bullet.setColor(Color.red);
	    
	    double dx = mouseLocation.x - player.getLocation().x;
	    double dy = mouseLocation.y - player.getLocation().y;

	    // Calculate the angle
	    double theta = Math.atan2(dy, dx);

	    double velX = player.playerProjectileSpeed * Math.cos(theta);
	    double velY = player.playerProjectileSpeed * Math.sin(theta);

	    bullet.setMomentum(new Vector2D(velX, velY));
	}
	
}
