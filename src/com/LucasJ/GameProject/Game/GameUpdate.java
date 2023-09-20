package com.LucasJ.GameProject.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.LucasJ.GameProject.Game.Entity.Entity;

public class GameUpdate {

	private Game game;
	
	public GameUpdate(Game game) {
		this.game = game;
	}
	
	public void tick(double deltaTime) {
		Graphics g = game.getBufferStrategy().getDrawGraphics();
		
		System.out.println(Entity.activeEntities.size());

		// Clear the screen
	    g.setColor(Color.black); // or any other background color you prefer
	    g.fillRect(0, 0, game.resolution.toDimension().width, game.resolution.toDimension().height); 
		
	    //default color
	    g.setColor(Color.white);
		
		if(game.getGameState() == GameState.GAME)  { // Game
			for (Entity entity : new ArrayList<>(Entity.activeEntities)) {
				entity.tick(deltaTime);
				entity.render(g);
			}
		} else if(game.getGameState() == GameState.GAME_OVER) {
			game.getGameOverMenu().render(g);
		}
		
		g.dispose();
        game.getBufferStrategy().show();
	}
	
}
