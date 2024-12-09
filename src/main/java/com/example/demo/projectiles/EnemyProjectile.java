package com.example.demo.projectiles;

import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.StraightMovement;

/**
 * represents a projectile fired by enemy planes.
 */
public class EnemyProjectile extends Projectile {
	
	private static final String IMAGE_NAME = "enemyplaneprojectile.png";
	private static final int IMAGE_HEIGHT = 15;
	private static final int HORIZONTAL_VELOCITY = -10;
	private final ProjectileMovementStrategy movementStrategy;

	/**
	 * constructs an {@code EnemyProjectile} at the specified position.
	 *
	 * @param initialXPos the initial X-coordinate of the projectile.
	 * @param initialYPos the initial Y-coordinate of the projectile.
	 */
	public EnemyProjectile(double initialXPos, double initialYPos) {
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
