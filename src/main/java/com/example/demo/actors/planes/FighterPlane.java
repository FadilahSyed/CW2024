package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.PlaneConstants;
import com.example.demo.projectiles.ProjectileFactory;

public abstract class FighterPlane extends ActiveActorDestructible {

	private int health;
	private static final int Y_POSITION_UPPER_BOUND = PlaneConstants.Y_POSITION_UPPER_BOUND;
	private static final int Y_POSITION_LOWER_BOUND = PlaneConstants.Y_POSITION_LOWER_BOUND;


	//constructors
	public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		this.health = health;
	}

	public abstract ActiveActorDestructible fireProjectile();
	
	@Override
	public void takeDamage() {
		health--;
		if (healthAtZero()) {
			this.destroy();
		}
	}
	public int getHealth() {
		return health;
	}

	//private/protected methods
	protected double getProjectileXPosition(double xPositionOffset) {
		return getLayoutX() + getTranslateX() + xPositionOffset;
	}

	protected double getProjectileYPosition(double yPositionOffset) {
		return getLayoutY() + getTranslateY() + yPositionOffset;
	}

	protected boolean shouldFire(double fireRate) {
		return Math.random() < fireRate;
	}
	private boolean healthAtZero() {
		return health == 0;
	}

	protected boolean isWithinBounds(double currentPosition) {
		return currentPosition >= Y_POSITION_UPPER_BOUND && currentPosition <= Y_POSITION_LOWER_BOUND;
	}


}
