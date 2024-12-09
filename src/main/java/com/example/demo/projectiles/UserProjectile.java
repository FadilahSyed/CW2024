package com.example.demo.projectiles;

import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.StraightMovement;

/**
 * represents the projectile fired by user's plane
 */
public class UserProjectile extends Projectile {

	private static final String IMAGE_NAME = "userplaneprojectile.png";
	private static final int IMAGE_HEIGHT = 12;
	private static final int HORIZONTAL_VELOCITY = 15;
	private final ProjectileMovementStrategy movementStrategy;

	/**
	 * constructs a {@code UserProjectile} at the specified position
	 * @param initialXPos the initial x-coordinate of the projectile
	 * @param initialYPos the initial y-coordinate of the projectile
	 */
	public UserProjectile(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
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
