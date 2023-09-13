package com.LucasJ.GameProject.Game;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.LucasJ.GameProject.Math.Vector2D;
import com.LucasJ.GameProject.Settings.GraphicsSettings;

public class Game implements Runnable {
	
	private Thread thread;
	private boolean isRunning = false;
	
//	Variables for game loop
	private final long OPTIMAL_TIME = 1000000000 / GraphicsSettings.TARGET_FPS;
// -------------------------
	
	
// Variables for Graphics
	
	private JFrame frame;
    private Canvas canvas;
    private BufferStrategy bufferStrategy;
    
// -----------------------
    
    private GameState gameState;
    
    private InputHandler inputHandler;
    
    private GameUpdate gameUpdate;

	public Game(Vector2D resolution) {
		frame = new JFrame("Game Window");
		frame.setSize(resolution.toDimension());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        inputHandler = new InputHandler(this);
        
        frame.addKeyListener(inputHandler);
        frame.addMouseListener(inputHandler);
        
        this.gameUpdate = new GameUpdate(this);
        
        this.setGameState(GameState.GAME);
        
        canvas = new Canvas();
        frame.add(canvas);
        frame.setVisible(true);

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
			// Render
			gameUpdate.render();
			
			try {
				Thread.sleep((lastTickTime - System.nanoTime() + this.OPTIMAL_TIME) / 1000000);
			} catch (InterruptedException e) {
				e.printStackTrace();
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

}
