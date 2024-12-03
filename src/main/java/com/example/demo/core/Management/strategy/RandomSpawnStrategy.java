/*package com.example.demo.core.Management.strategy;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.EnemyPlane;

import java.util.ArrayList;
import java.util.List;

public class RandomSpawnStrategy implements SpawnStrategy {

    private static final int MAX_ENEMIES=5;
    private static final double SPAWN_PROBABILITY=0.2;

    @Override
    public List<ActiveActorDestructible> spawnEnemies(int currentEnemies, double screenWidth, double maxEnemyYPosition) {
        List<ActiveActorDestructible> newEnemies=new ArrayList<>();

        for (int i = 0; i < MAX_ENEMIES - currentEnemies; i++) {
            if (Math.random() <SPAWN_PROBABILITY) {
                double newEnemyYPosition = Math.random() * maxEnemyYPosition;
                newEnemies.add(new EnemyPlane(screenWidth,newEnemyYPosition));
            }
        }

        return newEnemies;

    }

}*/
