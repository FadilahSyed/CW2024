package com.example.demo.ui;

import com.example.demo.ui.components.ShieldImage;
import com.example.demo.utils.PlaneConstants;
import javafx.scene.Group;

/**
 * the {@code LevelViewLevelTwo} class extends {@code LevelView} to
 * include a shield display in level final of the game.
 * It manages the shield's visibility and position
 */
public class LevelViewLevelTwo extends LevelView {

	private static final double SHIELD_X_OFFSET  = PlaneConstants.SHIELD_X_OFFSET;
	private static final double SHIELD_Y_OFFSET = PlaneConstants.SHIELD_Y_OFFSET;
	private final Group root;
	private final ShieldImage shieldImage;

	/**
	 * constructs a {@code LevelViewLevelTwo} with shield functionality
	 *
	 * @param root				The root group where the shield and hearts are added
	 * @param heartsToDisplay	The number of hearts to display initially
	 */
	public LevelViewLevelTwo(Group root, int heartsToDisplay) {
		super(root, heartsToDisplay);
		this.root = root;
		this.shieldImage = new ShieldImage();
		root.getChildren().addAll(shieldImage);
	}

	/**
	 * updates the shield's position to follow the boss
	 * @param x The x-coordinates of the boss
	 * @param y the y-coordinates of the boss
	 */
	public void updateShieldPosition(double x, double y) {
		shieldImage.setLayoutX(x + SHIELD_X_OFFSET);
		shieldImage.setLayoutY(y +SHIELD_Y_OFFSET);
	}

	/**
	 * shows the shield on the screen
	 */
	public void showShield() {
		shieldImage.showShield();
		shieldImage.toFront();
	}

	/**
	 * hides the shield from the screen
	 */
	public void hideShield() {
		shieldImage.hideShield();
	}

}
