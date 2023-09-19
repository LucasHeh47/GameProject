package com.LucasJ.GameProject.Game.Entity.Player;

import java.awt.Color;
import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Math.Vector2D;
import com.LucasJ.GameProject.Settings.GraphicsSettings;

public class PlayerHealth {

	private Player player;
	private Game game;
	
	private Vector2D barSize = new Vector2D(
			GraphicsSettings.PLAYER_HEALTH_BAR_SIZE_X,
			GraphicsSettings.PLAYER_HEALTH_BAR_SIZE_Y);
	
	private Vector2D barLocation;
	
	public PlayerHealth(Game game, Player player) {
		this.player = player;
		this.game = game;
		
		barLocation = new Vector2D(
			    (game.resolution.x - barSize.x) / 2,
			    game.resolution.y - barSize.y - 10  // Assuming a gap of 10 pixels
			);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(
				barLocation.toDimension().width, 
				barLocation.toDimension().height, 
				barSize.toDimension().width, 
				barSize.toDimension().height);
		g.setColor(Color.WHITE);
		g.drawRect(
				barLocation.toDimension().width, 
				barLocation.toDimension().height, 
				barSize.toDimension().width, 
				barSize.toDimension().height);
		g.setColor(Color.RED);
		g.fillRect(
				barLocation.toDimension().width+1, 
				barLocation.toDimension().height+1, 
				mapHealth(player.getHealth())-1, 
				barSize.toDimension().height-1);
	}
	
	// Takes in health and gives a new width for bar
	public int mapHealth(double value) {
	    return (int) ((value) / (player.getMaxHealth()) * (barSize.x));
	}
	
}
