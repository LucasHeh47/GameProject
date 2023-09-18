package com.LucasJ.GameProject.Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.LucasJ.GameProject.Game.Entity.EntityTags;
import com.LucasJ.GameProject.Game.Entity.Dynamic.Enemy.Enemy;
import com.LucasJ.GameProject.Game.Entity.Player.Player;
import com.LucasJ.GameProject.Math.Vector2D;
import com.LucasJ.GameProject.Settings.GraphicsSettings;

public class Game implements Runnable {
	
	private Thread thread;
	private boolean isRunning = false;
	
//	Variables for game loop
	private final long OPTIMAL_TIME = 1000000000 / GraphicsSettings.TARGET_FPS;
// -------------------------
	
	
// Variables for Graphics
	
	public Vector2D resolution;
	private JFrame frame;
    private Canvas canvas;
    private BufferStrategy bufferStrategy;
    
// -----------------------
    
    private Player player;
    
	private GameState gameState;
    
    private InputHandler inputHandler;
    
    private GameUpdate gameUpdate;

	public Game(Vector2D resolution) {
		this.resolution = resolution;
		frame = new JFrame("Game Window");
		frame.setSize((int) resolution.x, (int) resolution.y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        inputHandler = new InputHandler(this);
        
        this.gameUpdate = new GameUpdate(this);
        
        this.setGameState(GameState.GAME);
        
        player = new Player(this);
        player.setHealth(30)
	        .setMaxHealth(100)
	        .setMovementSpeed(10)
	        .setSize(new Vector2D(30, 30))
	        .setLocation(new Vector2D(0, 0))
	        .setColor(Color.BLUE)
	        .addTag(EntityTags.Player);
        
        Enemy zombie = new Enemy(this);
        ((Enemy) zombie.setTarget(player)
        		.setHealth(100)
        		.addTag(EntityTags.Enemy)
        		.setLocation(new Vector2D(500, 500))
        		.setSize(new Vector2D(20, 20)))
        		.setMovementSpeed(3)
        		.setColor(Color.GREEN);
        
        canvas = new Canvas();

        canvas.addKeyListener(inputHandler);
        canvas.addMouseListener(inputHandler);
        canvas.addMouseMotionListener(inputHandler);
        frame.getContentPane().add(canvas);
        canvas.setPreferredSize(resolution.toDimension());
        frame.pack();
        
        frame.setVisible(true);
        canvas.requestFocus();

        canvas.createBufferStrategy(2);
        setBufferStrategy(canvas.getBufferStrategy());
	}
	
	public void start() {
        if (thread == null || !isRunning) {
            thread = new Thread(this);
            thread.start();
        } else {
            System.out.println("Game is already running");
        }
    }

    public void end() {
        if (thread != null && isRunning) {
            thread.interrupt();
        } else {
            System.out.println("Game is not running");
        }
    }
	
	
	@Override
	public void run() {
		isRunning = true;
		long lastTickTime = System.nanoTime();
		while(isRunning) {
			long now = System.nanoTime();
			long updateLength = now - lastTickTime;
			lastTickTime = now;
			
			double delta = updateLength / ((double) OPTIMAL_TIME);
			
			// Tick
			gameUpdate.tick(delta);
			
			long sleepTime = (lastTickTime - System.nanoTime() + this.OPTIMAL_TIME) / 1000000;
			if (sleepTime > 0) {
			    try {
			        Thread.sleep(sleepTime);
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			}
		}
		
		
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public BufferStrategy getBufferStrategy() {
		return bufferStrategy;
	}

	public void setBufferStrategy(BufferStrategy bufferStrategy) {
		this.bufferStrategy = bufferStrategy;
	}
	public InputHandler getInputHandler() {
		return this.inputHandler;
	}
	public Player getPlayer() {
		return player;
	}

}
