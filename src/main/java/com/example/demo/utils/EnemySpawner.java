package com.example.demo.utils;
import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.PlaneFactory;
import com.example.demo.core.LevelConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * the {@code EnemySpawner} class handles the spawning of enemies in
 * the game based on level configurations
 */
public class EnemySpawner {
    private final LevelConfig config;
    private final Random random;

    /**
     * constructs an {@code EnemySpawner} with the specified level configuration
     *
     * @param config the {@code LevelConfig} containing enemy spawn configurations
     */
    public EnemySpawner(LevelConfig config) {
        this.config=config;
        this.random=new Random();
    }

    /**
     * spawns enemies based on the current number of enemies and the level configuration
     *
     * @param currentNumberOfEnemies the number of enemies currently on screen
     * @param screenWidth            the width of the game screen
     * @param enemyMaximumYPosition  the maximum Y-coordinate for spawning enemies
     * @return a list of newly spawned enemy actors
     */
    public List<ActiveActorDestructible> spawnEnemies(int currentNumberOfEnemies, double screenWidth, double enemyMaximumYPosition) {
        List<ActiveActorDestructible> newEnemies = new ArrayList<>();
        int enemiesToSpawn = config.getTotalEnemies() - currentNumberOfEnemies;

        for (int i = 0; i < enemiesToSpawn; i++) {
            if (random.nextDouble() < config.getEnemySpawnProbability()) {
                newEnemies.add(PlaneFactory.createPlane("enemy",screenWidth,random.nextDouble() * enemyMaximumYPosition,0));
            }
            if (config.getEnemy2SpawnProbability() > 0 && random.nextDouble() < config.getEnemy2SpawnProbability()) {
                newEnemies.add(PlaneFactory.createPlane("enemy2",screenWidth,random.nextDouble() * enemyMaximumYPosition,0));
            }
            if ("LevelFour".equals(config.getNextLevel())&& currentNumberOfEnemies==0) {
                newEnemies.add(PlaneFactory.createPlane("miniboss",screenWidth,random.nextDouble() * enemyMaximumYPosition,0));
            }
        }

        return newEnemies;
    }

}
