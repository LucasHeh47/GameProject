package com.LucasJ.GameProject.Game.Assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {
	public static BufferedImage button10x3 = Assets.getImage("menubutton.png");

	public static BufferedImage getImage(String path) {
	    try {
	    	return ImageIO.read(new File("src/com/LucasJ/GameProject/Game/Assets/" + path));
	    } catch(IOException e) {
	    	System.out.println("Image not found");
	    	e.getStackTrace();
	    	return null;
	    }
	}

	
}
