package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.utils.PlaneConstants;

public class EnemyPlane extends FighterPlane {

	private static final String IMAGE_NAME = "enemyplane.png";

	private static final int IMAGE_HEIGHT = PlaneConstants.ENEMY_IMAGE_HEIGHT;
	private static final int HORIZONTAL_VELOCITY = PlaneConstants.ENEMY_HORIZONTAL_VELOCITY;
	private static final double PROJECTILE_X_POSITION_OFFSET =PlaneConstants.PROJECTILE_X_POSITION_OFFSET;
	private static final double PROJECTILE_Y_POSITION_OFFSET = PlaneConstants.PROJECTILE_Y_POSITION_OFFSET;
	private static final int INITIAL_HEALTH = PlaneConstants.ENEMY_INITIAL_HEALTH;
	private static final double FIRE_RATE = PlaneConstants.ENEMY_FIRE_RATE;

	public EnemyPlane(double initialXPos, double initialYPos) {
		super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos, INITIAL_HEALTH);
	}

	@Override
	public void updatePosition() {
		moveHorizontally(HORIZONTAL_VELOCITY);
	}

	@Override
	public ActiveActorDestructible fireProjectile() {
		if (Math.random() < FIRE_RATE) {
			return ProjectileFactory.createProjectile("enemy",
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
