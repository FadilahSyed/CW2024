package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.MovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.projectiles.ProjectileFactory;

public class MiniBoss extends FighterPlane {


    private static final String IMAGE_NAME = "enemyplane.png";
    private static final int IMAGE_HEIGHT = 65;
    private static final double INITIAL_X_POSITION = 1000.0;
    private static final double PROJECTILE_X_POSITION_OFFSET = -50.0;
    private static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;
    private static final int INITIAL_HEALTH = 10;
    private static final double FIRE_RATE = .02;

    private final MovementStrategy movementStrategy;
    public MiniBoss(double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos, INITIAL_HEALTH);
        this.movementStrategy=new MovementPattern();
    }

    @Override
    public void updatePosition() {
        double initialTranslateY = getTranslateY();
        moveVertically(movementStrategy.getNextMove());
        double currentPosition = getLayoutY() + getTranslateY();
        if (isWithinBounds(currentPosition)) {
            setTranslateY(initialTranslateY);
        }
    }

    @Override
    public ActiveActorDestructible fireProjectile() {
        if (Math.random() < FIRE_RATE) {
            return ProjectileFactory.createProjectile("miniboss",
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
