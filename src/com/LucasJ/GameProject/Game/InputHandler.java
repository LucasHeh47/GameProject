package com.LucasJ.GameProject.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.LucasJ.GameProject.Math.Vector2D;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {

	private Vector2D mouseLocation;
	private Game game;
	
	public boolean W, A, S, D, LM, RM;
	
	public InputHandler(Game game) {
		this.game = game;
		this.mouseLocation = new Vector2D(0, 0);
	}
	
	// KEYBOARD EVENTS
	
    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed event
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: W = true; break;
            case KeyEvent.VK_A: A = true; break;
            case KeyEvent.VK_S: S = true; break;
            case KeyEvent.VK_D: D = true; break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: W = false; break;
            case KeyEvent.VK_A: A = false; break;
            case KeyEvent.VK_S: S = false; break;
            case KeyEvent.VK_D: D = false; break;
        }
    }
    
    
    // MOUSE EVENTS

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
        	LM = true;
        }
        if (e.getButton() == 3) {
        	RM = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	if (e.getButton() == 1) {
        	LM = false;
        }
        if (e.getButton() == 3) {
        	RM = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Handle mouse entered event
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Handle mouse exited event
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.mouseLocation.x = e.getX();
		this.mouseLocation.y = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.mouseLocation.x = e.getX();
		this.mouseLocation.y = e.getY();
	}

	public Vector2D getMouseLocation() {
		return mouseLocation;
	}
}
