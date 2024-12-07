package com.example.demo.projectiles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossProjectileTest {

    @Test
    void testBossProjectileMovement() {
        BossProjectile projectile = new BossProjectile(100);

        projectile.updatePosition();
        assertEquals(935, projectile.getTranslateX()); // -15 from the initial position (950)
    }
}
