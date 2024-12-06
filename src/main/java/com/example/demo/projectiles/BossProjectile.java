package com.example.demo.projectiles;
import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.StraightMovement;

public class BossProjectile extends Projectile {
	
	private static final String IMAGE_NAME = "fireball.png";
	private static final int IMAGE_HEIGHT = 75;
	private static final int HORIZONTAL_VELOCITY = -15;
	private static final int INITIAL_X_POSITION = 950;
	private final ProjectileMovementStrategy movementStrategy;

	public BossProjectile(double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos);
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
