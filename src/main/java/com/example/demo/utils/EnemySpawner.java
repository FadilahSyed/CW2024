package com.example.demo.utils;
import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.PlaneFactory;
import com.example.demo.actors.planes.EnemyPlane;
import com.example.demo.actors.planes.Enemy2Plane;
import com.example.demo.actors.planes.MiniBoss;
import com.example.demo.core.LevelConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class EnemySpawner {
    private final LevelConfig config;
    private final Random random;

    public EnemySpawner(LevelConfig config) {
        this.config=config;
        this.random=new Random();
    }

    public List<ActiveActorDestructible> spawnEnemies(int currentNumberOfEnemies, double screenWidth, double enemyMaximumYPosition) {
        List<ActiveActorDestructible> newEnemies = new ArrayList<>();
        int enemiesToSpawn = config.getTotalEnemies() - currentNumberOfEnemies;

        for (int i = 0; i < enemiesToSpawn; i++) {
            if (random.nextDouble() < config.getEnemySpawnProbability()) {
                newEnemies.add(PlaneFactory.createPlane("enemy",screenWidth,random.nextDouble() * enemyMaximumYPosition,0));
                //newEnemies.add(new EnemyPlane(screenWidth, random.nextDouble() * enemyMaximumYPosition));
            }
            if (config.getEnemy2SpawnProbability() > 0 && random.nextDouble() < config.getEnemy2SpawnProbability()) {
                newEnemies.add(PlaneFactory.createPlane("enemy2",screenWidth,random.nextDouble() * enemyMaximumYPosition,0));
                //newEnemies.add(new Enemy2Plane(screenWidth, random.nextDouble() * enemyMaximumYPosition));
            }
            if ("LevelFour".equals(config.getNextLevel())&& currentNumberOfEnemies==0) {
                newEnemies.add(PlaneFactory.createPlane("miniboss",screenWidth,random.nextDouble() * enemyMaximumYPosition,0));
                //newEnemies.add(new MiniBoss(random.nextDouble() * enemyMaximumYPosition));
            }
        }

        return newEnemies;
    }

}
