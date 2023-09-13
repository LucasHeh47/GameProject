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
	
	public boolean W, A, S, D;
	
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
        // Handle mouse clicked event
        System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handle mouse pressed event
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Handle mouse released event
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.mouseLocation.x = e.getX();
		this.mouseLocation.y = e.getY();
	}
}
