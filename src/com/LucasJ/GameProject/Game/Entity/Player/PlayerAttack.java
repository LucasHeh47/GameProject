package com.LucasJ.GameProject.Game.Entity.Player;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.EntityTags;
import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;
import com.LucasJ.GameProject.Game.Entity.Projectile.Bullet;
import com.LucasJ.GameProject.Math.Vector2D;

public class PlayerAttack {

	private Game game;
	private Player player;
	
	public PlayerAttack(Game game, Player player) {
		this.game = game;
		this.player = player;
		
		
	}
	
	public void attack() {
		Bullet bullet = new Bullet(game, player.getLocation(), new Vector2D(5, 5), player.playerDamage);
	}
	
	
}
