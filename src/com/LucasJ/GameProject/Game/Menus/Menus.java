package com.LucasJ.GameProject.Game.Menus;

import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Assets.Assets;

public class Menus {

	public Game game;
	
	public Menus(Game game) {
		this.game = game;
	}
	
	public void renderGameOver(Graphics g) {
		g.drawString("Game Over", (int) game.resolution.x/2, (int) game.resolution.y/2);
		g.drawImage(Assets.button10x3, 
				(int) (game.resolution.x - 100) / 2, 
				(int) (game.resolution.y - 30) / 2, 
				(int) (game.resolution.x + 100) / 2, 
				(int) (game.resolution.y + 30) / 2, 0, 0, 100, 30, null);

	}
	
	
	public void renderMainMenu(Graphics g) {
		
	}
	
}
