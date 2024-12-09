package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.utils.CommonConstants;

/**
 * abstract base class representing an actor/fighter plane in the game
 */
public abstract class FighterPlane extends ActiveActorDestructible {
	private int health;
	private static final int Y_POSITION_LOWER_BOUND = CommonConstants.Y_POSITION_LOWER_BOUND;
	private static final int Y_POSITION_UPPER_BOUND = CommonConstants.Y_POSITION_UPPER_BOUND;


	/**
	 * constructs a {@code FighterPlane} with the specified properties
	 *
	 * @param imageName    the name of the image of the plane
	 * @param imageHeight  the height of the plane image
	 * @param initialXPos  the initial X-coordinate of the plane
	 * @param initialYPos  the initial Y-coordinate of the plane
	 * @param health       the initial health of the plane
	 */
	public FighterPlane(String imageName, int imageHeight, double initialXPos, double initialYPos, int health) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		this.health = health;
	}

	/**
	 * fires a projectile.
	 * subclasses must implement this method to define the projectile type.
	 *
	 * @return A {@code ActiveActorDestructible} representing the fired projectile.
	 */
	public abstract ActiveActorDestructible fireProjectile();

	/**
	 * decrements health
	 * 'destroys' actor when health = 0
	 */
	@Override
	public void takeDamage() {
		health--;
		if (healthAtZero()) {
			this.destroy();
		}
	}

	/**
	 * getter method to get health
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * calculates x-coordinate of projectile by
	 * getting enemy x-coordinate and adding the offset
	 * @param xPositionOffset x-offset for the projectile
	 * @return initial x-coordinate of the projectile
	 */
	protected double getProjectileXPosition(double xPositionOffset) {
		return getLayoutX() + getTranslateX() + xPositionOffset;
	}

	/**
	 * calculates y-coordinate of projectile by
	 * getting enemy y-coordinate and adding the offset
	 * @param yPositionOffset y-offset for the projectile
	 * @return initial y-coordinate of the projectile
	 */
	protected double getProjectileYPosition(double yPositionOffset) {
		return getLayoutY() + getTranslateY() + yPositionOffset;
	}

	/**
	 * checks if projectile should be fired based on probability
	 * @param fireRate fireRate probability personalised to each plane
	 * @return {@code true} if random number less than probability (projectile will be fired), otherwise {@code false}.
	 */
	protected boolean shouldFire(double fireRate) {
		return Math.random() < fireRate;
	}

	/**
	 * checks if health is at zero
	 * @return  {@code true} if health at zero, otherwise {@code false}.
	 */
	private boolean healthAtZero() {
		return health == 0;
	}

	/**
	 * checks if actor is within bounds
	 * @param currentPosition the current position of the actor
	 * @return {@code true} if plane is within bounds, otherwise {@code false}.
	 */
	protected boolean isWithinBounds(double currentPosition) {
		return currentPosition >= Y_POSITION_LOWER_BOUND && currentPosition <= Y_POSITION_UPPER_BOUND;
	}


}
