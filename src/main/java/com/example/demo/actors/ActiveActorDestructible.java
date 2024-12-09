package com.example.demo.actors;

/**
 * abstract class for actors that can take damage and be destroyed.
 */
public abstract class ActiveActorDestructible extends ActiveActor implements Destructible {

	private boolean isDestroyed;

	/**
	 * constructs an {@code ActiveActorDestructible} with specified properties.
	 *
	 * @param imageName   the name of the image file.
	 * @param imageHeight the height of the image.
	 * @param initialXPos the initial X-coordinate.
	 * @param initialYPos teh initial Y-coordinate.
	 */
	public ActiveActorDestructible(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		super(imageName, imageHeight, initialXPos, initialYPos);
		isDestroyed = false;
	}

	@Override
	public abstract void updatePosition();

	/**
	 * updates the actor state each frame.
	 */
	public abstract void updateActor();

	@Override
	public abstract void takeDamage();

	@Override
	public void destroy() {
		setDestroyed(true);
	}

	/**
	 * marks the actor as destroyed.
	 * @param isDestroyed the destroyed state.
	 */
	protected void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}

	/**
	 * checks if the actor is destroyed.
	 * @return {@code true} if destroyed, otherwise {@code false}.
	 */
	public boolean isDestroyed() {
		return isDestroyed;
	}
}
