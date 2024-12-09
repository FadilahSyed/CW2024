package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.RandomMovementPattern;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.actors.shield.ShieldManager;
import com.example.demo.actors.shield.ShieldStrategy;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.ui.LevelViewLevelTwo;
import com.example.demo.utils.CommonConstants;

/**
 * represents the final boss in level final - moves vertically randomly and fires projectiles
 */
public class Boss extends FighterPlane {

	// constant variables
	private static final String IMAGE_NAME = "boss.png";
	private static final double INITIAL_X_POSITION = CommonConstants.INITIAL_X_POSITION;
	private static final double INITIAL_Y_POSITION = CommonConstants.INITIAL_Y_POSITION;
	private static final double PROJECTILE_Y_POSITION_OFFSET = CommonConstants.BOSS_PROJECTILE_Y_POSITION_OFFSET;
	private static final double BOSS_FIRE_RATE = CommonConstants.BOSS_FIRE_RATE;
	private static final int IMAGE_HEIGHT = CommonConstants.BOSS_IMAGE_HEIGHT;
	private static final int HEALTH = CommonConstants.BOSS_INITIAL_HEALTH;

	private final MovementStrategy movementStrategy;
	private final ShieldStrategy shieldStrategy;

	/**
	 * constructs an {@code Boss} with the specified levelview
	 * @param levelView the levelview for the level - includes elements like shield and health
	 */
	public Boss(LevelViewLevelTwo levelView) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, HEALTH);
		this.movementStrategy = new RandomMovementPattern();
		this.shieldStrategy = new ShieldManager(levelView);
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
		shieldStrategy.updateShieldPosition(getLayoutX(), getLayoutY()+getTranslateY());
	}

	/**
	 * updates position and shield by calling methods
	 */
	@Override
	public void updateActor() {
		updatePosition();
		shieldStrategy.updateShield();
	}

	/**
	 * fires a projectile with a probability
	 * @return A new enemy projectile, or {@code null} if no projectile is fired.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		return shouldFire(BOSS_FIRE_RATE)
				? ProjectileFactory.createProjectile("boss",getLayoutX(),getProjectileInitialPosition())
				: null;
	}

	/**
	 * boss only takes damage when not shielded
	 */
	@Override
	public void takeDamage() {
		if (!shieldStrategy.isShielded()) {
			super.takeDamage();
		}
	}

	/**
	 * calculates projectile y-coordinate
	 * -- gets the boss's position and adds an offset
	 * @return the initial projectile y-coordinate
	 */
	private double getProjectileInitialPosition() {
		return getLayoutY() + getTranslateY() + PROJECTILE_Y_POSITION_OFFSET;
	}
}
