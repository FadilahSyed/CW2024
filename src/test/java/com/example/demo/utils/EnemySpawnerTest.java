package com.example.demo.utils;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.core.LevelConfig;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnemySpawnerTest {

    @Test
    void testSpawnEnemies() {
        LevelConfig config = new LevelConfig("background.jpg", "LevelTwo", 5, 3, 0.5, 0.3, 5);
        EnemySpawner spawner = new EnemySpawner(config);

        List<ActiveActorDestructible> enemies = spawner.spawnEnemies(0, 1300, 600);
        assertFalse(enemies.isEmpty());
        assertTrue(enemies.size() <= 5); // Total enemies defined in config
    }
}
