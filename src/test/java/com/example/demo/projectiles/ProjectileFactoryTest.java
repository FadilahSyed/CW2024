package com.example.demo.projectiles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectileFactoryTest {

    @Test
    void testCreateBossProjectile() {
        Projectile projectile = ProjectileFactory.createProjectile("boss", 0, 100);
        assertTrue(projectile instanceof BossProjectile);
    }

    @Test
    void testCreateEnemyProjectile() {
        Projectile projectile = ProjectileFactory.createProjectile("enemy", 50, 50);
        assertTrue(projectile instanceof EnemyProjectile);
    }

    @Test
    void testCreateMiniBossProjectile() {
        Projectile projectile = ProjectileFactory.createProjectile("miniboss", 30, 60);
        assertTrue(projectile instanceof MiniBossProjectile);
    }

    @Test
    void testCreateUserProjectile() {
        Projectile projectile = ProjectileFactory.createProjectile("user", 10, 20);
        assertTrue(projectile instanceof UserProjectile);
    }

    @Test
    void testInvalidProjectileType() {
        assertThrows(IllegalArgumentException.class, () -> {
            ProjectileFactory.createProjectile("unknown", 0, 0);
        });
    }
}
