package com.example.demo.actors;

import com.example.demo.core.BossProjectile;
import com.example.demo.ui.LevelViewLevelTwo;
import com.example.demo.actors.ShieldManager;
import com.example.demo.actors.MovementPattern;


public class Boss extends FighterPlane {

	// constant variables
	private static final String IMAGE_NAME = "bossplane.png";
	private static final double INITIAL_X_POSITION = 1000.0;
	private static final double INITIAL_Y_POSITION = 400;
	private static final double PROJECTILE_Y_POSITION_OFFSET = 75.0;
	private static final double BOSS_FIRE_RATE = .04;
	private static final int IMAGE_HEIGHT = 300;
	private static final int HEALTH = 100;
	private static final int Y_POSITION_UPPER_BOUND = -100;
	private static final int Y_POSITION_LOWER_BOUND = 475;

	private final MovementPattern movementPattern;
	private final ShieldManager shieldManager;

	//constructor
	public Boss(LevelViewLevelTwo levelView) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, HEALTH);
        this.movementPattern = new MovementPattern();
        this.shieldManager = new ShieldManager(levelView);
	}

	//public methods
	@Override
	public void updatePosition() {
		double initialTranslateY = getTranslateY();
		moveVertically(movementPattern.getNextMove());
		double currentPosition = getLayoutY() + getTranslateY();
		if (currentPosition < Y_POSITION_UPPER_BOUND || currentPosition > Y_POSITION_LOWER_BOUND) {
			setTranslateY(initialTranslateY);
		}
	}
	
	@Override
	public void updateActor() {
		updatePosition();
		shieldManager.updateShield();
	}

	@Override
	public ActiveActorDestructible fireProjectile() {
		return shouldFire(BOSS_FIRE_RATE) ? new BossProjectile(getProjectileInitialPosition()) : null;
	}
	
	@Override
	public void takeDamage() {
		if (!shieldManager.isShielded()) {
			super.takeDamage();
		}
	}

	private double getProjectileInitialPosition() {
		return getLayoutY() + getTranslateY() + PROJECTILE_Y_POSITION_OFFSET;
	}
	//private methods
	/*private void initializeMovePattern() {
		for (int i = 0; i < MOVE_FREQUENCY_PER_CYCLE; i++) {
			movePattern.add(VERTICAL_VELOCITY);
			movePattern.add(-VERTICAL_VELOCITY);
			movePattern.add(ZERO);
		}
		Collections.shuffle(movePattern);
	}*/

	/*private void updateShield() {
		if (isShielded) framesWithShieldActivated++;
		else if (shieldShouldBeActivated()) {
			activateShield();
		}
		if (shieldExhausted()) deactivateShield();
	}*/

	/*private int getNextMove() {
		int currentMove = movePattern.get(indexOfCurrentMove);
		consecutiveMovesInSameDirection++;
		if (consecutiveMovesInSameDirection == MAX_FRAMES_WITH_SAME_MOVE) {
			Collections.shuffle(movePattern);
			consecutiveMovesInSameDirection = 0;
			indexOfCurrentMove++;
		}
		if (indexOfCurrentMove == movePattern.size()) {
			indexOfCurrentMove = 0;
		}
		return currentMove;
	}*/

	/*private boolean bossFiresInCurrentFrame() {
		return Math.random() < BOSS_FIRE_RATE;
	}*/


	/*private boolean shieldShouldBeActivated() {
		return Math.random() < BOSS_SHIELD_PROBABILITY;
	}

	private boolean shieldExhausted() {
		return framesWithShieldActivated == MAX_FRAMES_WITH_SHIELD;
	}

	private void activateShield() {
		isShielded = true;
		levelView.showShield(); //calls method from levelviewlevel2
	}

	private void deactivateShield() {
		isShielded = false;
		framesWithShieldActivated = 0;
		levelView.hideShield(); //calls method from levelviewlevel2
	}*/

}
