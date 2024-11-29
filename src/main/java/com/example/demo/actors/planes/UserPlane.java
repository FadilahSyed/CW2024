package com.example.demo.actors.planes;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.FighterPlane;
import com.example.demo.projectiles.ProjectileFactory;

public class UserPlane extends FighterPlane {

	//constants
	private static final String IMAGE_NAME = "userplane.png";
	private static final double Y_UPPER_BOUND = -40;
	private static final double Y_LOWER_BOUND = 600.0;
	private static final double INITIAL_X_POSITION = 5.0;
	private static final double INITIAL_Y_POSITION = 300.0;
	private static final double X_LEFT_BOUND=5.0;
	private static final double X_RIGHT_BOUND=1200.0;

	private static final int IMAGE_HEIGHT = 42;
	private static final int VELOCITY = 8;
	private static final int PROJECTILE_X_POSITION = 110;
	private static final int PROJECTILE_Y_POSITION_OFFSET = 20;

	//instance variables
	private int verticalVelocityMultiplier;
	private int horizontalVelocityMultiplier;
	private int numberOfKills;

	//constructor
	public UserPlane(int initialHealth) {
		super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, INITIAL_Y_POSITION, initialHealth);
		this.verticalVelocityMultiplier = 0;
		this.horizontalVelocityMultiplier=0;
	}

	//public methods
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
				this.setTranslateY(initialTranslateX);
			}
		}

	}
	
	@Override
	public void updateActor() {
		updatePosition();
	}
	
	@Override
	public ActiveActorDestructible fireProjectile() {
		return ProjectileFactory.createProjectile("user",getProjectileXPosition(PROJECTILE_X_POSITION),getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
	}

	public void moveUp() {
		verticalVelocityMultiplier = -1;
	}

	public void moveDown() {
		verticalVelocityMultiplier = 1;
	}
	public void moveLeft() {
		horizontalVelocityMultiplier = -1;
	}

	public void moveRight() {
		horizontalVelocityMultiplier = 1;
	}

	public void stopVertical() {
		verticalVelocityMultiplier = 0;
	}
	public void stopHorizontal(){
		horizontalVelocityMultiplier=0;
	}

	public int getNumberOfKills() {
		return numberOfKills;
	}

	public void incrementKillCount() {
		numberOfKills++;
	}

	//private methods
	/*private boolean isMoving() {
		return velocityMultiplier != 0;
	}*/

}
