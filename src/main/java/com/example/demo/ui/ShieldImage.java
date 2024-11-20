package com.example.demo.ui;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ShieldImage extends ImageView {
	
	private static final String IMAGE_NAME = "shield.png";
	private static final int SHIELD_SIZE = 400;
	
	public ShieldImage(double xPosition, double yPosition) {
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
		this.setImage(ImageLoader.load(IMAGE_NAME));
		this.setVisible(false);
		this.setFitHeight(SHIELD_SIZE);
		this.setFitWidth(SHIELD_SIZE);
	}

	public void showShield() {
		this.setVisible(true);
	}
	
	public void hideShield() {
		this.setVisible(false);
	}

}
