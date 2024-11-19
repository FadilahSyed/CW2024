package com.example.demo.ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ShieldImage extends ImageView {
	
	private static final String IMAGE_NAME = "/com/example/demo/images/shield.png";
	private static final int SHIELD_SIZE = 400;
	
	public ShieldImage(double xPosition, double yPosition) {
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
		//this.setImage(new Image(IMAGE_NAME));
		this.setImage(new Image(Objects.requireNonNull(getClass().getResource(IMAGE_NAME)).toExternalForm()));
		//this.setVisible(false);
		/*try {
			this.setImage(new Image(Objects.requireNonNull(getClass().getResource("/com/example/demo/images/heart.png")).toExternalForm()));
		} catch (NullPointerException e) {
			System.out.println("Error loading image: shield.png");
		}*/
		this.setVisible(false);
		this.setFitHeight(SHIELD_SIZE);
		this.setFitWidth(SHIELD_SIZE);
	}

	public void showShield() {
		this.setVisible(true);
		System.out.println("1");
	}
	
	public void hideShield() {
		this.setVisible(false);
		System.out.println("2");
	}

}
