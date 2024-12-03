/*package com.example.demo.core.Management.strategy;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.Enemy3Plane;
import com.example.demo.actors.planes.MiniBoss;

import java.util.ArrayList;
import java.util.List;

public class MiniBossSpawnStrategy implements SpawnStrategy {

    private static final int ENEMIES_PER_WAVE = 3;
    private static final int Y_POSITION_UPPER_BOUND = 100;
    private static final int Y_POSITION_LOWER_BOUND = 475;


    @Override
    public List<ActiveActorDestructible> spawnEnemies(int currentEnemies, double screenWidth, double maxEnemyYPosition) {
        List<ActiveActorDestructible> newEnemies = new ArrayList<>();

        if (currentEnemies == 0) { // Only spawn a new wave if no enemies exist
            for (int i = 0; i < ENEMIES_PER_WAVE; i++) {
                double newEnemyYPosition = generateYPositionWithinBounds();
                newEnemies.add(new MiniBoss(newEnemyYPosition));
            }
        }

        return newEnemies;
    }

    private double generateYPositionWithinBounds() {
        return Y_POSITION_LOWER_BOUND+ (Math.random() * (yUpperBound - yLowerBound));
    }
}*/
