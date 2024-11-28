package com.example.demo.ui;

import com.example.demo.ui.LevelView;
import com.example.demo.ui.ShieldImage;
import javafx.scene.Group;

public class LevelViewLevelTwo extends LevelView {

	private static final double SHIELD_X_OFFSET  = -150;
	private static final int SHIELD_Y_OFFSET = -80;
	private final Group root;
	private final ShieldImage shieldImage;
	
	public LevelViewLevelTwo(Group root, int heartsToDisplay) {
		super(root, heartsToDisplay);
		this.root = root;
		this.shieldImage = new ShieldImage();
		root.getChildren().addAll(shieldImage);
	}

	public void updateShieldPosition(double x, double y) {
		shieldImage.setLayoutX(x + SHIELD_X_OFFSET);
		shieldImage.setLayoutY(y +SHIELD_Y_OFFSET);
	}


	public void showShield() {
		shieldImage.showShield();
		shieldImage.toFront();
	}

	public void hideShield() {
		shieldImage.hideShield();
	}

}
