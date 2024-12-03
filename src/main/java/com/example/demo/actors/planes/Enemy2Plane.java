package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.RandomMovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.projectiles.ProjectileFactory;

public class Enemy2Plane extends FighterPlane {

    private static final String IMAGE_NAME = "enemy3plane.png";
    private static final int IMAGE_HEIGHT = 45;
    private static final int HORIZONTAL_VELOCITY = -5;
    private static final double PROJECTILE_X_POSITION_OFFSET = -100.0;
    private static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;
    private static final int INITIAL_HEALTH = 1;
    private static final double FIRE_RATE = .01;

    private final MovementStrategy movementStrategy;

    public Enemy2Plane(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
        this.movementStrategy=new RandomMovementPattern();
    }

    @Override
    public void updatePosition() {
        moveHorizontally(HORIZONTAL_VELOCITY) ;
        double initialTranslateY = getTranslateY();
        moveVertically(movementStrategy.getNextMove());
        double currentPosition = getLayoutY() + getTranslateY();
        if (!isWithinBounds(currentPosition)) {
            setTranslateY(initialTranslateY);
        }
    }

    @Override
    public ActiveActorDestructible fireProjectile() {
        if (Math.random() < FIRE_RATE) {
            return ProjectileFactory.createProjectile("enemy",
                    getProjectileXPosition(PROJECTILE_X_POSITION_OFFSET),
                    getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
        }
        return null;
    }

    @Override
    public void updateActor() {
        updatePosition();
    }

}
