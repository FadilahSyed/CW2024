package com.example.demo.ui;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.ImageView;

public class GameOverImage extends ImageView {
	
	private static final String IMAGE_NAME = "gameover.png";

	public GameOverImage(double xPosition, double yPosition) {
		setImage(ImageLoader.load(IMAGE_NAME));
		setLayoutX(xPosition);
		setLayoutY(yPosition);
	}

}
