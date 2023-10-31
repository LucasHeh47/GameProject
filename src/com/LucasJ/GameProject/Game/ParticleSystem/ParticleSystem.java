package com.LucasJ.GameProject.Game.ParticleSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Math.Vector2D;

public class ParticleSystem {
	
	public static List<ParticleSystem> activeParticleSystems = new ArrayList<>();
    
    private List<Particle> particlesToBeDeleted = new ArrayList<>();

    private Game game;
    
    private Vector2D initialLocation;
    private Color[] color;
    private int[] size;
    private ParticleShape[] shape;
    private int density;
    private double speed;
    private double time;
    private double length;
    
    private List<Particle> particles = new ArrayList<>();
    
    private double startTime = -1;
    
    private double spawnInterval;
    private double timeSinceLastSpawn;
    private int particlesToSpawn;
    
    public ParticleSystem(Game game) {
        this.game = game;
        activeParticleSystems.add(this);
    }
    
//    TO DO -> ADD TIMER FOR WHOLE SYSTEM AND REMOVE SYSTEM FROM STATIC LISTw
    
    public void tick(double deltaTime, Graphics g) {
        if (startTime == -1) {
            startTime = System.currentTimeMillis() / 1000.0; // Convert milliseconds to seconds
        }

        double elapsedTime = System.currentTimeMillis() / 1000.0 - startTime;

        if (elapsedTime < length && length > 0) {
            timeSinceLastSpawn += deltaTime;
            while (timeSinceLastSpawn >= spawnInterval && particlesToSpawn > 0) {
                spawnParticle();
                timeSinceLastSpawn -= spawnInterval;
                particlesToSpawn--;
            }
        } else if(length == -1) {
        	spawnParticle();
            timeSinceLastSpawn -= spawnInterval;
            particlesToSpawn--;
        }

        particles.forEach(particle -> particle.tick(deltaTime, g));
        particles.removeAll(particlesToBeDeleted);
        particlesToBeDeleted.clear();

        if (elapsedTime >= length && particles.isEmpty()) {
            activeParticleSystems.remove(this);
        }
    }
    
    public void setLocation(Vector2D loc) {
    	initialLocation = loc;
    }
    
    private void spawnParticle() {
        Random rand = new Random();
        Particle particle = new Particle(
                color[rand.nextInt(color.length)], 
                initialLocation, // Make sure to create a new instance
                rand.nextInt(size[0], size[1]), 
                time,
                new Vector2D(rand.nextDouble(-speed, speed), rand.nextDouble(-speed, speed)),
                shape[rand.nextInt(shape.length)],
                this
        );
        particles.add(particle);
    }

    public void markForDeletion(Particle particle) {
        particlesToBeDeleted.add(particle);
    }
    
    public void initiateParticles() {
    	this.spawnInterval = time / density;
        this.timeSinceLastSpawn = 0;
        this.particlesToSpawn = density;
    }
    
    public List<Particle> getParticles() {
    	return particles;
    }

    public static class Builder {
        private ParticleSystem particleSystem;

        public Builder(Game game) {
            particleSystem = new ParticleSystem(game);
        }

        public Builder setInitialLocation(Vector2D initialLocation) {
            particleSystem.initialLocation = initialLocation;
            return this;
        }

        public Builder setColor(Color[] color) {
            particleSystem.color = color;
            return this;
        }

        public Builder setSize(int[] size) {
            particleSystem.size = size;
            return this;
        }

        public Builder setDensity(int density) {
            particleSystem.density = density;
            return this;
        }

        public Builder setSpeed(double speed) {
            particleSystem.speed = speed;
            return this;
        }

        public Builder setTime(double time) {
            particleSystem.time = time;
            return this;
        }
        
        public Builder setLength(double length) {
        	if(length == -1) {
        		particleSystem.length = -1;
        		return this;
        	}
        	particleSystem.length = length*1000;
        	return this;
        }
        
        public Builder setShape(ParticleShape[] shape) {
        	particleSystem.shape = shape;
        	return this;
        }

        public ParticleSystem build() {
        	particleSystem.initiateParticles();
            return particleSystem;
        }
    }
}

