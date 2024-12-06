package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.RandomMovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.projectiles.ProjectileFactory;

public class Enemy2Plane extends FighterPlane {

    private static final String IMAGE_NAME = "enemy3plane.png";
    private static final int IMAGE_HEIGHT = PlaneConstants.ENEMY2_IMAGE_HEIGHT;
    private static final int HORIZONTAL_VELOCITY = PlaneConstants.ENEMY2_HORIZONTAL_VELOCITY;
    private static final double PROJECTILE_X_POSITION_OFFSET =PlaneConstants.PROJECTILE_X_POSITION_OFFSET;
    private static final double PROJECTILE_Y_POSITION_OFFSET = PlaneConstants.PROJECTILE_Y_POSITION_OFFSET;
    private static final int INITIAL_HEALTH = PlaneConstants.ENEMY_INITIAL_HEALTH;
    private static final double FIRE_RATE = PlaneConstants.ENEMY_FIRE_RATE;

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
