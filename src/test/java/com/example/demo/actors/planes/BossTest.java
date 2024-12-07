package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.ui.LevelViewLevelTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {

    @Test
    void testFireProjectile() {
        Boss boss = new Boss(new LevelViewLevelTwo(null, 5));
        ActiveActorDestructible projectile = boss.fireProjectile();

        assertNotNull(projectile);
    }

    @Test
    void testShieldBlocksDamage() {
        LevelViewLevelTwo levelView = new LevelViewLevelTwo(null, 5);
        Boss boss = new Boss(levelView);

        // Simulate shield activation
        boss.updateActor();
        boss.takeDamage();

        assertFalse(boss.isDestroyed());
    }
}
