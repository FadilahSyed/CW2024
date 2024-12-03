package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.RandomMovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.actors.shield.ShieldManager;
import com.example.demo.actors.shield.ShieldStrategy;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.ui.LevelViewLevelTwo;

public class Boss extends FighterPlane {

	// constant variables
	private static final String IMAGE_NAME = "bossplane.png";
	private static final double INITIAL_X_POSITION = 1000.0;
	private static final double INITIAL_Y_POSITION = 400;
	private static final double PROJECTILE_Y_POSITION_OFFSET = 75.0;
	private static final double BOSS_FIRE_RATE = .04;
	private static final int IMAGE_HEIGHT = 59;
	private static final int HEALTH = 50;
	private static final int Y_POSITION_UPPER_BOUND = 100;
	private static final int Y_POSITION_LOWER_BOUND = 475;

	private final MovementStrategy movementStrategy;
	private final ShieldStrategy shieldStrategy;

	//constructor
	public Boss(LevelViewLevelTwo levelView) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, HEALTH);
		this.movementStrategy = new RandomMovementPattern();
		this.shieldStrategy = new ShieldManager(levelView);
	}

	//public methods
	@Override
	public void updatePosition() {
		double initialTranslateY = getTranslateY();
		moveVertically(movementStrategy.getNextMove());
		double currentPosition = getLayoutY() + getTranslateY();
		if (!isWithinBounds(currentPosition)) {
			setTranslateY(initialTranslateY);
		}
		shieldStrategy.updateShieldPosition(getLayoutX(), getLayoutY()+getTranslateY());
	}

	@Override
	public void updateActor() {
		updatePosition();
		shieldStrategy.updateShield();
	}

	@Override
	public ActiveActorDestructible fireProjectile() {
		return shouldFire(BOSS_FIRE_RATE)
				? ProjectileFactory.createProjectile("boss",getLayoutX(),getProjectileInitialPosition())
				: null;
	}

	@Override
	public void takeDamage() {
		if (!shieldStrategy.isShielded()) {
			super.takeDamage();
		}
	}

	private double getProjectileInitialPosition() {
		return getLayoutY() + getTranslateY() + PROJECTILE_Y_POSITION_OFFSET;
	}
}
