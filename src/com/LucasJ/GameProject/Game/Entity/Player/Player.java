package com.LucasJ.GameProject.Game.Entity.Player;

import java.awt.Color;
import java.awt.Graphics;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.GameState;
import com.LucasJ.GameProject.Game.InputHandler;
import com.LucasJ.GameProject.Game.Entity.Entity;
import com.LucasJ.GameProject.Game.Entity.Dynamic.DynamicEntity;
import com.LucasJ.GameProject.Game.ParticleSystem.ParticleShape;
import com.LucasJ.GameProject.Game.ParticleSystem.ParticleSystem;
import com.LucasJ.GameProject.Math.Vector2D;

public class Player extends DynamicEntity{

	private boolean isSprinting = false;
	private double sprintSpeedMultiplier = 1.25;
	
	InputHandler input;
	
	private PlayerHealth playerHealth;
	private PlayerAttack playerAttack;
	
    private double timeSinceLastAttack = 0.0;
	public int playerDamage;
	public double playerAttackSpeed;
	public double playerProjectileSpeed;
	
	public boolean isAiming = false;
	
	public Player(Game game) {
		super(game);
		input = this.game.getInputHandler();
		playerDamage = 50;
		playerProjectileSpeed = 2000;
		playerAttackSpeed = 10;
		playerHealth = new PlayerHealth(game, this);
		playerAttack = new PlayerAttack(game, this);
	}
	
	public void tick(double deltaTime) {
		super.tick(deltaTime);
		timeSinceLastAttack += deltaTime;
//		Can player attack
		if (input.LM && game.getGameState() == GameState.GAME) {
			this.attemptToAttack(input.getMouseLocation());
		}
		isAiming = input.RM;
		
		Vector2D movement = new Vector2D(0, 0);

	    if(input.W) movement = movement.add(new Vector2D(0, this.getMovementSpeed() * deltaTime * -1));
	    if(input.S) movement = movement.add(new Vector2D(0, this.getMovementSpeed() * deltaTime));
	    if(input.A) movement = movement.add(new Vector2D(this.getMovementSpeed() * deltaTime * -1, 0));
	    if(input.D) movement = movement.add(new Vector2D(this.getMovementSpeed() * deltaTime, 0));

	    if(movement.magnitude() > 0) {
	        movement = movement.normalize().multiply(this.getMovementSpeed() * deltaTime);
	    }

	    this.move(movement);
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval((int)location.x, (int)location.y, 
				(int)size.x, (int)size.y);
		
		playerHealth.render(g);
	}
	
	public void attemptToAttack(Vector2D mouseLocation) {
		if (timeSinceLastAttack >= playerAttackSpeed) {
            playerAttack.attack(mouseLocation);
            timeSinceLastAttack = 0.0;
        }
	}
	
	public void onDeath() {
		game.setGameState(GameState.GAME_OVER);
		game.getEnemySpawner().stopSpawning();
		Entity.clearEntities();
		this.onDestroy();
	}
	
	public boolean isSprinting() {
		return isSprinting;
	}
	public void setSprinting(boolean isSprinting) {
		this.isSprinting = isSprinting;
	}
	public double getSprintSpeedMultiplier() {
		return sprintSpeedMultiplier;
	}
	public Player setSprintSpeedMultiplier(double sprintSpeedMultiplier) {
		this.sprintSpeedMultiplier = sprintSpeedMultiplier;
		return this;
	}

	public PlayerHealth getPlayerHealth() {
		return playerHealth;
	}
	
}
