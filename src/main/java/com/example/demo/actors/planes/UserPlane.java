package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.projectiles.ProjectileFactory;
import com.example.demo.utils.CommonConstants;

/**
 * represents the user's plane in the game.
 */
public class UserPlane extends FighterPlane {

	//constants
	private static final String IMAGE_NAME = "userplane.png";
	private static final double Y_UPPER_BOUND = CommonConstants.Y_UPPER_BOUND;
	private static final double Y_LOWER_BOUND = CommonConstants.Y_LOWER_BOUND;
	private static final double INITIAL_X_POSITION = CommonConstants.USER_INITIAL_X_POSITION;
	private static final double INITIAL_Y_POSITION = CommonConstants.USER_INITIAL_Y_POSITION;
	private static final double X_LEFT_BOUND= CommonConstants.X_LEFT_BOUND;
	private static final double X_RIGHT_BOUND= CommonConstants.X_RIGHT_BOUND;

	private static final int IMAGE_HEIGHT = CommonConstants.USER_IMAGE_HEIGHT;
	private static final int VELOCITY = CommonConstants.VERTICAL_VELOCITY;
	private static final int PROJECTILE_X_POSITION = CommonConstants.PROJECTILE_X_POSITION;
	private static final int PROJECTILE_Y_POSITION_OFFSET = CommonConstants.USER_PROJECTILE_Y_POSITION_OFFSET;


	private int verticalVelocityMultiplier;
	private int horizontalVelocityMultiplier;
	private int numberOfKills;

	/**
	 * constructs a {@code UserPlane} with the specified initial health.
	 *
	 * @param initialHealth the initial health of the user's plane.
	 */
	public UserPlane(int initialHealth) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, initialHealth);
		this.verticalVelocityMultiplier = 0;
		this.horizontalVelocityMultiplier=0;
	}

	/**
	 * updates the position of the user's plane based on movement input.
	 */
	@Override
	public void updatePosition() {
		double initialTranslateY=getTranslateY();
		double initialTranslateX=getTranslateX();

		if(verticalVelocityMultiplier!=0) {
			this.moveVertically(VELOCITY*verticalVelocityMultiplier);
			double newYPosition=getLayoutY()+getTranslateY();
			if(newYPosition<Y_UPPER_BOUND || newYPosition>Y_LOWER_BOUND) {
				this.setTranslateY(initialTranslateY);
			}
		}
		if(horizontalVelocityMultiplier!=0) {
			this.moveHorizontally(VELOCITY*horizontalVelocityMultiplier);
			double newXPosition=getLayoutX()+getTranslateX();
			if(newXPosition<X_LEFT_BOUND || newXPosition>X_RIGHT_BOUND) {
				this.setTranslateX(initialTranslateX);
			}
		}

	}

	/**
	 * updates the user plane by updating its position
	 */
	@Override
	public void updateActor() {
		updatePosition();
	}

	/**
	 * fires a projectile from the user's plane
	 *
	 * @return A projectile instance.
	 */
	@Override
	public ActiveActorDestructible fireProjectile() {
		return ProjectileFactory.createProjectile("user",getProjectileXPosition(PROJECTILE_X_POSITION),getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
	}

	/**
	 * moves the user plane up by changing the vertical velocity to negative
	 */
	public void moveUp() {
		verticalVelocityMultiplier = -1;
	}
	/**
	 * moves the user plane down by changing the vertical velocity to positive
	 */
	public void moveDown() {
		verticalVelocityMultiplier = 1;
	}
	/**
	 * moves the user plane left by changing the horizontal velocity to negative
	 */
	public void moveLeft() {
		horizontalVelocityMultiplier = -1;
	}
	/**
	 * moves the user plane right by changing the horizontal velocity to positive
	 */
	public void moveRight() {
		horizontalVelocityMultiplier = 1;
	}
	/**
	 * stops the user plane vertically by changing the vertical velocity to 0
	 */
	public void stopVertical() {
		verticalVelocityMultiplier = 0;
	}
	/**
	 * stops the user plane horizontally by changing the horizontal velocity to 0
	 */
	public void stopHorizontal(){
		horizontalVelocityMultiplier=0;
	}

	/**
	 * gets the number of kills made by the user
	 *
	 * @return the total kill count
	 */
	public int getNumberOfKills() {
		return numberOfKills;
	}

	/**
	 * increments the kill count when an enemy is destroyed.
	 */
	public void incrementKillCount() {
		numberOfKills++;
	}


}
