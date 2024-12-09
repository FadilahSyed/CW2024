package com.example.demo.projectiles;

import com.example.demo.actors.ActiveActorDestructible;

/**
 * Abstract base class representing a projectile in the game.
 * Subclasses must implement the {@code updatePosition} method for movement behavior.
 */
public abstract class Projectile extends ActiveActorDestructible {

	/**
	 * constructx a {@code Projectile} with the specified image and position.
	 *
	 * @param imageName     the name of the image representing the projectile
	 * @param imageHeight   the  height of the projectile image
	 * @param initialXPos   the initial x-coordinate of the projectile
	 * @param initialYPos   the initial y-coordinate of the projectile
	 */
	public Projectile(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
	}

	/**
	 * handles damage to the projectile by destroying it
	 */
	@Override
	public void takeDamage() {
		this.destroy();
	}

	/**
	 * updates the position of the projectile
	 * subclasses must implement their specific movement behaviour
	 */
	public abstract void updatePosition();


}
