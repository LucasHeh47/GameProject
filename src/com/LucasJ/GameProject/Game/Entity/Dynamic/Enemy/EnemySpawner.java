package com.LucasJ.GameProject.Game.Entity.Dynamic.Enemy;

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.LucasJ.GameProject.Game.Game;
import com.LucasJ.GameProject.Game.Entity.EntityTags;
import com.LucasJ.GameProject.Math.Vector2D;
import com.LucasJ.GameProject.Settings.EnemySpawnChances;

public class EnemySpawner {
	
	private Game game;
	private ScheduledExecutorService scheduler;
    private long spawnRateInSeconds = 2;  // default value

    public EnemySpawner(Game game) {
        this.game = game;
    }

    private void startSpawning() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
        }

        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> spawnEnemy(), 0, spawnRateInSeconds, TimeUnit.SECONDS);
    }

    public void stopSpawning() {
        if (scheduler != null) {
            scheduler.shutdown();
        }
    }

    public void setSpawnRate(long rateInSeconds) {
        this.spawnRateInSeconds = rateInSeconds;
        startSpawning();  // restart the scheduler with the new rate
    }
	
	public void spawnEnemy() {
		Random rand = new Random();
//		spawns on top/bottom or left/right
		int result = rand.nextInt(2);
		int spawnY = 0, spawnX = 0;
		if (result == 0) {
//			Top / Bottom
			spawnY = rand.nextInt(2) == 1 ? -10 : (int) game.resolution.y+10;
			spawnX = rand.nextInt(-10, (int) (game.resolution.x+10));
		} else {
			spawnX = rand.nextInt(2) == 1 ? -10 : (int) game.resolution.x+10;
			spawnY = rand.nextInt(-10, (int) (game.resolution.y+10));
		}
		EnemyTypes enemyType = EnemySpawnChances.spawnEnemy();
		if(enemyType == EnemyTypes.Zombie) {
			spawnZombie(new Vector2D(spawnX, spawnY));
		} else {
			System.out.println("No entity found");
		}
	}
	
	public void spawnZombie(Vector2D location) {
		Enemy zombie = new Enemy(game);
	    ((Enemy) zombie.setTarget(game.getPlayer())
	    		.setDamage(30)
	    		.setMaxHealth(200)
	    		.addTag(EntityTags.Enemy)
	    		.setLocation(location)
	    		.setSize(new Vector2D(20, 20)))
	    		.setMovementSpeed(3)
	    		.setColor(Color.GREEN);
	}

}
