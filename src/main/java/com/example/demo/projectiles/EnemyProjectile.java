package com.example.demo.projectiles;

import com.example.demo.projectiles.Projectile;
import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.StraightMovement;

public class EnemyProjectile extends Projectile {
	
	private static final String IMAGE_NAME = "enemyFire.png";
	private static final int IMAGE_HEIGHT = 10; //reduced the hitbox of normal enemy's projectile
	private static final int HORIZONTAL_VELOCITY = -10;
	private final ProjectileMovementStrategy movementStrategy;

	public EnemyProjectile(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
		this.movementStrategy=new StraightMovement(HORIZONTAL_VELOCITY);
	}

	@Override
	public void updatePosition() {
		movementStrategy.updatePosition(this);
	}

	@Override
	public void updateActor() {
		updatePosition();
	}


}
