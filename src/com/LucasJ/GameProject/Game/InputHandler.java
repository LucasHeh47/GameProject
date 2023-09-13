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
	
	public InputHandler(Game game) {
		this.game = game;
	}
	
	// KEYBOARD EVENTS
	
    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed event
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key pressed event
        System.out.println("Key pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released event
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
