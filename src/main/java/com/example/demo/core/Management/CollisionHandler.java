package com.example.demo.core.Management;

import com.example.demo.actors.ActiveActorDestructible;

import java.util.List;

public class CollisionHandler {

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

    public boolean enemyHasPenetratedDefenses(ActiveActorDestructible enemy, double screenWidth) {
        return Math.abs(enemy.getTranslateX()) > screenWidth;
    }
}
