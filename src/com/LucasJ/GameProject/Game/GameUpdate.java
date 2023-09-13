package com.LucasJ.GameProject.Game;

import java.awt.Color;
import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;

public class GameUpdate {

	private Game game;
	
	public GameUpdate(Game game) {
		this.game = game;
	}
	
	public void tick(double deltaTime) {
		DynamicEntity.activeEntities.forEach(e -> {
			e.tick(deltaTime);
		});
	}
	
	public void render() {
		Graphics g = game.getBufferStrategy().getDrawGraphics();

		// Clear the screen
	    g.setColor(Color.WHITE); // or any other background color you prefer
	    g.fillRect(0, 0, game.resolution.toDimension().width, game.resolution.toDimension().height); 
		
        DynamicEntity.activeEntities.forEach(e -> {
        	e.render(g);
        });

        // Dispose the graphics and show the buffer
        g.dispose();
        game.getBufferStrategy().show();
	}
	
}
