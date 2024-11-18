package com.example.demo;

import javafx.scene.Group;

public class LevelViewLevelTwo extends LevelView {

	private static final int SHIELD_X_POSITION = 1000;
	private static final int SHIELD_Y_POSITION = 400;
	private final Group root;
	private final ShieldImage shieldImage;
	
	public LevelViewLevelTwo(Group root, int heartsToDisplay) {
		super(root, heartsToDisplay);
		this.root = root;
		this.shieldImage = new ShieldImage(SHIELD_X_POSITION, SHIELD_Y_POSITION);
		addImagesToRoot();
	}


	private void addImagesToRoot() {
		root.getChildren().addAll(shieldImage);
		shieldImage.setViewOrder(1.0);
	}
	
	public void showShield() {
		System.out.println("Shield position: X=" + shieldImage.getLayoutX() + ", Y=" + shieldImage.getLayoutY());
		System.out.println("Showing shield");
		shieldImage.showShield();
		shieldImage.toFront();
	}

	public void hideShield() {
		System.out.println("Hiding shield");
		shieldImage.hideShield();
	}

}
