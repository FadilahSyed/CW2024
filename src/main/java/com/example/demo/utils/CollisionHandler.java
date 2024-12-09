package com.example.demo.utils;

import com.example.demo.actors.ActiveActorDestructible;

import java.util.List;

/**
 * the {@code CollisionHandler} class handles collision detection
 * between game actors and processes damage or boundary violations (enemyHasPenetratedDefenses)
 */
public class CollisionHandler {
    /**
     * detects collisions between two lists of actors and applies damage to both colliding actors
     *
     * @param actors1 The first list of destructible actors
     * @param actors2 The second list of destructible actors
     */
    public void handleCollisions(List<ActiveActorDestructible> actors1, List<ActiveActorDestructible> actors2) {
        for (ActiveActorDestructible actor : actors2) {
            for (ActiveActorDestructible otherActor : actors1) {
                if (actor.getBoundsInParent().intersects(otherActor.getBoundsInParent())) {
                    actor.takeDamage();
                    otherActor.takeDamage();
                }
            }
        }
    }

    /**
     * checks if an enemy has passed the left/right boundary of the screen.
     *
     * @param enemy       the enemy actor to check (if it has penetrated defenses)
     * @param screenWidth the width of the game screen
     * @return {@code true} if the enemy has passed the screen boundaries; otherwise {@code false}
     */
    public boolean enemyHasPenetratedDefenses(ActiveActorDestructible enemy, double screenWidth) {
        return Math.abs(enemy.getTranslateX()) > screenWidth;
    }
}
