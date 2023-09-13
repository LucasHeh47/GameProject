package com.LucasJ.GameProject.Game;

import java.awt.Graphics;

public class GameUpdate {

	private Game game;
	
	public GameUpdate(Game game) {
		this.game = game;
	}
	
	public void tick(double deltaTime) {
		
	}
	
	public void render() {
		Graphics g = game.getBufferStrategy().getDrawGraphics();

        

        // Dispose the graphics and show the buffer
        g.dispose();
        game.getBufferStrategy().show();
	}
	
}
