package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.RandomMovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.utils.CommonConstants;

/**
 * represents 2nd enemy plane that moves horizontally as well as vertically randomly, fires projectiles
 */
public class Enemy2Plane extends FighterPlane {

    private static final String IMAGE_NAME = "enemy2plane.png";
    private static final int IMAGE_HEIGHT = CommonConstants.ENEMY2_IMAGE_HEIGHT;
    private static final int HORIZONTAL_VELOCITY = CommonConstants.ENEMY2_HORIZONTAL_VELOCITY;
    private static final double PROJECTILE_X_POSITION_OFFSET = CommonConstants.PROJECTILE_X_POSITION_OFFSET;
    private static final double PROJECTILE_Y_POSITION_OFFSET = CommonConstants.PROJECTILE_Y_POSITION_OFFSET;
    private static final int INITIAL_HEALTH = CommonConstants.ENEMY_INITIAL_HEALTH;
    private static final double FIRE_RATE = CommonConstants.ENEMY_FIRE_RATE;

    private final MovementStrategy movementStrategy;

    /**
     * constructs an {@code Enemy2Plane} at a specified position
     * @param initialXPos the initial x-coordinate
     * @param initialYPos the initial y-coordinate
     */
    public Enemy2Plane(double initialXPos, double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
        this.movementStrategy=new RandomMovementPattern();
    }

    /**
     * updates the enemy's position
     * moves horizontally with horizontal velocity + stays within bounds
     * moves vertically randomly with RandomMovementPattern
     */
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

    /**
     * fires a projectile with probability
     * @return A new enemy projectile, or {@code null} if no projectile is fired.
     */
    @Override
    public ActiveActorDestructible fireProjectile() {
        return shouldFire(FIRE_RATE)
                ? ProjectileFactory.createProjectile("enemy",
                getProjectileXPosition(PROJECTILE_X_POSITION_OFFSET),
                getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET))
                : null;
    }

    /**
     * updates enemy2plane
     */
    @Override
    public void updateActor() {
        updatePosition();
    }

}
