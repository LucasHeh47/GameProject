package com.LucasJ.GameProject.Game.Entity.Player;

import java.awt.Color;
import java.util.Random;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Assets.ColorGradientBuilder;
import com.LucasJ.GameProject.Game.Entity.Projectile.Bullet;
import com.LucasJ.GameProject.Game.ParticleSystem.ParticleShape;
import com.LucasJ.GameProject.Game.ParticleSystem.ParticleSystem;
import com.LucasJ.GameProject.Math.Vector2D;

public class PlayerAttack {

	private Game game;
	private Player player;
	
	public PlayerAttack(Game game, Player player) {
		this.game = game;
		this.player = player;
		
		
	}
	
	public void attack(Vector2D mouseLocation) {
	    Bullet bullet = new Bullet(game, player.getLocation(), new Vector2D(10, 10), player.playerDamage);
	    bullet.setColor(Color.red);
	    
	    double dx = mouseLocation.x - player.getLocation().x;
	    double dy = mouseLocation.y - player.getLocation().y;

	    // Calculate the angle
	    double theta = Math.atan2(dy, dx);
	    
	    if(!player.isAiming) {
	    	Random rand = new Random();
	    	double bloom = rand.nextDouble(-0.1, 0.1);
	    	theta += bloom;
	    }

	    double velX = player.playerProjectileSpeed * Math.cos(theta);
	    double velY = player.playerProjectileSpeed * Math.sin(theta);
	    ColorGradientBuilder colorBuilder = new ColorGradientBuilder(new Color[] {Color.pink, Color.red, Color.orange, Color.black});
	    Color color[] = colorBuilder.generateGradient(10);
	    bullet.addParticles(
	    		new ParticleSystem.Builder(game)
				.setColor(color)
				.setDensity(10)
				.setInitialLocation(player.getLocation())
				.setSize(new int[] {3, 5})
				.setSpeed(7)
				.setTime(5)
				.setLength(-1)
				.setShape(new ParticleShape[] {ParticleShape.CIRCLE})
				.build()
	    		);
	    
	    bullet.setMomentum(new Vector2D(velX, velY));
	}
	
}
