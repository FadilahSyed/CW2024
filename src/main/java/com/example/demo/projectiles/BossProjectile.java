package com.example.demo.projectiles;

import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.StraightMovement;

/**
 * represents a projectile fired by the final boss.
 */
public class BossProjectile extends Projectile {
	
	private static final String IMAGE_NAME = "bossprojectile.png";
	private static final int IMAGE_HEIGHT = 55;
	private static final int HORIZONTAL_VELOCITY = -15;
	private static final int INITIAL_X_POSITION = 950;
	private final ProjectileMovementStrategy movementStrategy;

	/**
	 * constructs a {@code BossProjectile} starting from a fixed X position.
	 *
	 * @param initialYPos the initial Y-coordinate of the projectile.
	 */
	public BossProjectile(double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos);
		this.movementStrategy=new StraightMovement(HORIZONTAL_VELOCITY);
	}

	/**
	 * Updates the projectile's position by moving it horizontally
	 * Uses movementStrategy and StraightMovement class
	 */
	@Override
	public void updatePosition() {
		movementStrategy.updatePosition(this);
	}

	/**
	 * updates projectile
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}
	
}
