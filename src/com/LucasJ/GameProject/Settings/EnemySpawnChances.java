package com.LucasJ.GameProject.Settings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import com.LucasJ.GameProject.Game.Entity.Dynamic.Enemy.EnemyTypes;

public class EnemySpawnChances {

    // Define a map with enemy names as keys and their spawn chances as values
    private static Map<EnemyTypes, Double> spawnChances = new LinkedHashMap<>(); // Maintain insertion order

    static {
        spawnChances.put(EnemyTypes.Zombie, 0.35);
    }

    private static Random random = new Random();

    public static EnemyTypes spawnEnemy() {
        double totalChances = spawnChances.values().stream().mapToDouble(Double::doubleValue).sum();
        
        double randomNumber = random.nextDouble() * totalChances;
        double cumulativeChance = 0.0;

        for (Map.Entry<EnemyTypes, Double> entry : spawnChances.entrySet()) {
            cumulativeChance += entry.getValue();
            if (randomNumber <= cumulativeChance) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("Unable to spawn an enemy. Check the spawn chances configuration.");
    }
}