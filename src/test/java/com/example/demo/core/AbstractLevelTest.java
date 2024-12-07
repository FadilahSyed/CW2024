package com.example.demo.core;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractLevelTest {
    private TestLevel testLevel;
    private LevelConfig testConfig;

    @BeforeEach
    void setUp() {
        testConfig = new LevelConfig(
                "testBackground.jpg",
                null, // No next level
                5,    // Total enemies
                3,    // Kills to advance
                0.5,  // Enemy spawn probability
                0.0,  // Enemy2 spawn probability
                3     // Player health
        );
        testLevel = new TestLevel(testConfig, 750, 1300);
    }

    @Test
    void testInitializeScene() {
        Scene scene = testLevel.initializeScene();
        assertNotNull(scene);
        assertTrue(scene.getRoot().getChildrenUnmodifiable().size() > 0);
    }

    @Test
    void testStartGame() {
        assertDoesNotThrow(() -> testLevel.startGame());
        assertFalse(testLevel.userIsDestroyed());
    }

    @Test
    void testSpawnEnemyUnits() {
        testLevel.spawnEnemyUnits();
        assertEquals(1, testLevel.getCurrentNumberOfEnemies());
    }

    @Test
    void testFireProjectile() {
        testLevel.fireProjectile();
        assertEquals(1, testLevel.getRoot().getChildrenUnmodifiable().size());
    }

    @Test
    void testLoseGame() {
        testLevel.setEventListener(event -> assertEquals("GAME_OVER", event));
        testLevel.getUser().takeDamage();
        testLevel.getUser().takeDamage();
        testLevel.getUser().takeDamage(); // User health reaches zero
        testLevel.checkIfGameOver();
        assertTrue(testLevel.userIsDestroyed());
    }

    @Test
    void testWinGame() {
        testLevel.setEventListener(event -> assertEquals("WIN_GAME", event));
        for (int i = 0; i < 5; i++) {
            testLevel.fireProjectile(); // Simulate kills
        }
        testLevel.winGame();
    }
}
