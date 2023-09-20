package com.LucasJ.GameProject.Game.Menus;

import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Game;

public class GameOver {

	public Game game;
	
	public GameOver(Game game) {
		this.game = game;
	}
	
	public void render(Graphics g) {
		g.drawString("Game Over", (int) game.resolution.x/2, (int) game.resolution.y/2);
	}
	
}
