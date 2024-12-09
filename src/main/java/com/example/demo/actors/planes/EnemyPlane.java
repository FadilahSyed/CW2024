package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.utils.CommonConstants;

/**
 * represents a basic enemy plane that moves horizontally and fires projectiles.
 */
public class EnemyPlane extends FighterPlane {

	private static final String IMAGE_NAME = "enemyplane.png";

	private static final int IMAGE_HEIGHT = CommonConstants.ENEMY_IMAGE_HEIGHT;
	private static final int HORIZONTAL_VELOCITY = CommonConstants.ENEMY_HORIZONTAL_VELOCITY;
	private static final double PROJECTILE_X_POSITION_OFFSET = CommonConstants.PROJECTILE_X_POSITION_OFFSET;
	private static final double PROJECTILE_Y_POSITION_OFFSET = CommonConstants.PROJECTILE_Y_POSITION_OFFSET;
	private static final int INITIAL_HEALTH = CommonConstants.ENEMY_INITIAL_HEALTH;
	private static final double FIRE_RATE = CommonConstants.ENEMY_FIRE_RATE;

	/**
	 * constructs an {@code EnemyPlane} at a specified position.
	 *
	 * @param initialXPos the initial X-coordinate.
	 * @param initialYPos The initial Y-coordinate.
	 */
	public EnemyPlane(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
	}

	/**
	 * updayes the enemy's position, moving it horizontally.
	 */
	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
	}

	/**
	 * fires a projectile with a probability.
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
	 * updates enemyplane
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}

}
