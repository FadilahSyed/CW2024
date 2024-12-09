package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.RandomMovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.utils.CommonConstants;

/**
 * represents miniboss - enemy in level 3 that moves vertically randomly and fires zigzag projectiles
 */
public class MiniBoss extends FighterPlane {


    private static final String IMAGE_NAME = "miniboss.png";

    private static final int IMAGE_HEIGHT = CommonConstants.MINIBOSS_IMAGE_HEIGHT;
    private static final double PROJECTILE_X_POSITION_OFFSET = CommonConstants.MINIBOSS_PROJECTILE_X_POSITION_OFFSET;
    private static final double PROJECTILE_Y_POSITION_OFFSET = CommonConstants.PROJECTILE_Y_POSITION_OFFSET;
    private static final int INITIAL_HEALTH = CommonConstants.MINIBOSS_INITIAL_HEALTH;
    private static final double FIRE_RATE = CommonConstants.MINIBOSS_FIRE_RATE;
    private static final double INITIAL_X_POSITION = CommonConstants.INITIAL_X_POSITION;

    private final MovementStrategy movementStrategy;

    /**
     * constructs an {@code MiniBoss} at a specified position
     * @param initialYPos the initial y-coordinates
     */
    public MiniBoss(double initialYPos) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos, INITIAL_HEALTH);
        this.movementStrategy=new RandomMovementPattern();
    }

    /**
     * getter method for projectile's x-offset
     * @return the projectile's x-offset
     */
    public static double getProjectileXPositionOffset() {
        return PROJECTILE_X_POSITION_OFFSET;
    }

    /**
     * updates the enemy's position using RandomMovementPattern
     * moves vertically randomly, stays between y bounds
     */
    @Override
    public void updatePosition() {
        double initialTranslateY = getTranslateY();
        moveVertically(movementStrategy.getNextMove());
        double currentPosition = getLayoutY() + getTranslateY();
        if (!isWithinBounds(currentPosition)) {
            setTranslateY(initialTranslateY);
        }
    }

    /**
     * fires a projectile with probability
     * @return A new miniboss projectile, or {@code null} if no projectile is fired
     */
    @Override
    public ActiveActorDestructible fireProjectile() {
        return shouldFire(FIRE_RATE)
                ? ProjectileFactory.createProjectile("miniboss",
                getProjectileXPosition(getProjectileXPositionOffset()),
                getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET))
                : null;
    }

    /**
     * updates miniboss
     */
    @Override
    public void updateActor() {
        updatePosition();
    }

}
