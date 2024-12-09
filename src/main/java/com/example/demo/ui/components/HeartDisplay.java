package com.example.demo.ui.components;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * the {@code HeartDisplay} class is responsible for managing and
 * displaying a set of heart icons to represent the player's health
 * in the game
 */
public class HeartDisplay {
	
	private static final String HEART_IMAGE_NAME = "health.png";
	private static final int HEART_HEIGHT = 50;
	private static final int INDEX_OF_FIRST_ITEM = 0;
	private final HBox container = new HBox();

	/**
	 * constructs a {@code HeartDisplay} at specified positions
	 * and initialises the given number of heart images
	 * @param xPosition			x-coordinate position of heart container
	 * @param yPosition			y-coordinate position of heart container
	 * @param heartsToDisplay	total number of hearts to dislpay initially
	 */
	public HeartDisplay(double xPosition, double yPosition, int heartsToDisplay) {
		container.setLayoutX(xPosition);
		container.setLayoutY(yPosition);
		initializeHearts(heartsToDisplay);
	}

	/**
	 * initialises the heart container with a specified number of heart images
	 * @param numberOfHearts number of hearts to add to the container
	 */
	private void initializeHearts(int numberOfHearts) {
		for (int i = 0; i < numberOfHearts; i++) {
			ImageView heart = new ImageView(ImageLoader.load(HEART_IMAGE_NAME));
			heart.setFitHeight(HEART_HEIGHT);
			heart.setPreserveRatio(true);
			container.getChildren().add(heart);
		}
	}

	/**
	 * removes one heart from the container
	 * --> starts from the first heart
	 * does nothing if theres no hearts left
	 */
	public void removeHeart() {
		if (!container.getChildren().isEmpty())
			container.getChildren().remove(INDEX_OF_FIRST_ITEM);
	}

	/**
	 * retrieves heart container for game UI
	 * @return the {@code HBox} containing the heart images
	 */
	public HBox getContainer() {
		return container;
	}

}
