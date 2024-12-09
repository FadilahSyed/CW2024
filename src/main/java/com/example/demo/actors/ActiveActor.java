package com.example.demo.actors;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.*;

/**
 * abstract base class for a game actor with position and image properties
 */
public abstract class ActiveActor extends ImageView {
	/**
	 * constructs an {@code ActiveActor} with the specified image and position.
	 *
	 * @param imageName   the name of the image file.
	 * @param imageHeight the height of the image.
	 * @param initialXPos the initial x-coordinate of the actor.
	 * @param initialYPos the initial y-coordinate of the actor.
	 */
	public ActiveActor(String imageName, int imageHeight, double initialXPos, double initialYPos) {
		this.setImage(ImageLoader.load(imageName));
		this.setLayoutX(initialXPos);
		this.setLayoutY(initialYPos);
		this.setFitHeight(imageHeight);
		this.setPreserveRatio(true);
	}

	/**
	 * updates the actor's position.
	 */
	public abstract void updatePosition();
	/**
	 * moves the actor horizontally by the specified distance
	 * @param horizontalMove the specified distance to move horizontally.
	 */
	public void moveHorizontally(double horizontalMove) {
		this.setTranslateX(getTranslateX() + horizontalMove);
	}

	/**
	 * moves the actor vertically by the specified distance
	 *
	 * @param verticalMove the specified distance to move vertically.
	 */
	public void moveVertically(double verticalMove) {
		this.setTranslateY(getTranslateY() + verticalMove);
	}

}
