package com.LucasJ.GameProject.Game.ParticleSystem;

import java.awt.Color;
import java.awt.Graphics;

import com.LucasJ.GameProject.Math.Vector2D;

public class Particle {

	private ParticleSystem particleSystem;
	
	private Color color;
	private Vector2D location;
	private int size;
	private double time;
	private double timeAlive;
	private Vector2D speed;
	private ParticleShape shape;
	
	public Particle(Color color, Vector2D location, int size, double time, Vector2D speed, ParticleShape shape, ParticleSystem system) {
		this.color = color;
		this.location = location;
		this.size = size;
		this.time = time;
		this.timeAlive = 0;
		this.speed = speed;
		this.shape= shape; 
		this.particleSystem = system;
	}
	
	public void tick(double deltaTime, Graphics g) {
		this.timeAlive += deltaTime;
		if(timeAlive >= time) {
			particleSystem.markForDeletion(this);
			return;
		}
		location = location.add(speed);
		
		g.setColor(color);
//		Add actual visuals
		if(shape == ParticleShape.SQUARE) {
			g.fillRect((int) location.x, (int) location.y, 
					size, size);
		} else if(shape == ParticleShape.CIRCLE) {
			g.fillOval((int) location.x, (int) location.y, 
					size, size);
		}
		
	}
	
}
