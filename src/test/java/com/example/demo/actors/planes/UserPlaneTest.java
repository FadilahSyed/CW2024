package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPlaneTest {

    @Test
    void testMoveUp() {
        UserPlane plane = new UserPlane(5);
        double initialY = plane.getTranslateY();

        plane.moveUp();
        plane.updatePosition();

        assertTrue(plane.getTranslateY() < initialY);
    }

    @Test
    void testFireProjectile() {
        UserPlane plane = new UserPlane(5);
        ActiveActorDestructible projectile = plane.fireProjectile();

        assertNotNull(projectile);
    }

    @Test
    void testIncrementKillCount() {
        UserPlane plane = new UserPlane(5);

        plane.incrementKillCount();
        assertEquals(1, plane.getNumberOfKills());
    }
}
