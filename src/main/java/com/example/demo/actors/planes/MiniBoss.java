package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.RandomMovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.utils.PlaneConstants;

public class MiniBoss extends FighterPlane {


    private static final String IMAGE_NAME = "miniboss.png";

    private static final int IMAGE_HEIGHT = PlaneConstants.MINIBOSS_IMAGE_HEIGHT;
    private static final double PROJECTILE_X_POSITION_OFFSET =PlaneConstants.MINIBOSS_PROJECTILE_X_POSITION_OFFSET;
    private static final double PROJECTILE_Y_POSITION_OFFSET = PlaneConstants.PROJECTILE_Y_POSITION_OFFSET;
    private static final int INITIAL_HEALTH = PlaneConstants.MINIBOSS_INITIAL_HEALTH;
    private static final double FIRE_RATE = PlaneConstants.MINIBOSS_FIRE_RATE;
    private static final double INITIAL_X_POSITION = PlaneConstants.INITIAL_X_POSITION;


    private final MovementStrategy movementStrategy;
    public MiniBoss(double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos, INITIAL_HEALTH);
        this.movementStrategy=new RandomMovementPattern();
    }

    public static double getProjectileXPositionOffset() {
        return PROJECTILE_X_POSITION_OFFSET;
    }

    @Override
    public void updatePosition() {
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
            return ProjectileFactory.createProjectile("miniboss",
                    getProjectileXPosition(getProjectileXPositionOffset()),
                    getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
        }
        return null;
    }

    @Override
    public void updateActor() {
        updatePosition();
    }

}
