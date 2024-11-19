package com.example.demo.ui;

import com.example.demo.ui.LevelView;
import com.example.demo.ui.ShieldImage;
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
		root.getChildren().addAll(shieldImage);
		//addImagesToRoot();
	}


	/*private void addImagesToRoot() {
		root.getChildren().addAll(shieldImage);
		//shieldImage.setViewOrder(1.0);
	}*/
	
	public void showShield() {
		//root.getChildren().addAll(shieldImage);
		shieldImage.showShield();
		shieldImage.toFront();
	}

	public void hideShield() {
		shieldImage.hideShield();
	}

}
