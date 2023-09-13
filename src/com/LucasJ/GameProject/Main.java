package com.LucasJ.GameProject;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Settings.GraphicsSettings;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(GraphicsSettings.RESOLUTION);
		
		game.start();
	}
	
}
