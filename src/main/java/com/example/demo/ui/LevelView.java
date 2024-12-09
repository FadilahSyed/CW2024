package com.example.demo.ui;

import com.example.demo.ui.components.HeartDisplay;
import com.example.demo.utils.CommonConstants;
import javafx.scene.Group;

/**
 * the {@code LevelView} class is responsible for displaying the player's health
 * using heart icons in the game UI (HeartDisplay)
 */

public class LevelView {
	
	private static final double HEART_DISPLAY_X_POSITION = CommonConstants.HEART_DISPLAY_X_POSITION;
	private static final double HEART_DISPLAY_Y_POSITION = CommonConstants.HEART_DISPLAY_Y_POSITION;
	private final Group root;
	private final HeartDisplay heartDisplay;

	/**
	 * Constructs a {@code LevelView} with a specified number of hearts to display
	 *
	 * @param root				The root group to which the heart display will be added
	 * @param heartsToDisplay	The number of hearts to display initially
	 */
	public LevelView(Group root, int heartsToDisplay) {
		this.root = root;
		this.heartDisplay = new HeartDisplay(HEART_DISPLAY_X_POSITION, HEART_DISPLAY_Y_POSITION, heartsToDisplay);
	}

	/**
	 * displays the heart icons on the screen
	 */
	public void showHeartDisplay() {
		root.getChildren().add(heartDisplay.getContainer());
	}

	/**
	 * updates the heart display by removing hearts based on remaining health
	 * @param heartsRemaining	The number of hearts to keep displayed
	 */
	public void removeHearts(int heartsRemaining) {
		int currentNumberOfHearts = heartDisplay.getContainer().getChildren().size();
		for (int i = 0; i < currentNumberOfHearts - heartsRemaining; i++) {
			heartDisplay.removeHeart();
		}
	}

}
