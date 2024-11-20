package com.example.demo.ui;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class WinImage extends ImageView {
	
	private static final String IMAGE_NAME = "youwin.png";
	private static final int HEIGHT = 500;
	private static final int WIDTH = 600;
	
	public WinImage(double xPosition, double yPosition) {
		this.setImage(ImageLoader.load(IMAGE_NAME));
		this.setVisible(false);
		this.setFitHeight(HEIGHT);
		this.setFitWidth(WIDTH);
		this.setLayoutX(xPosition);
		this.setLayoutY(yPosition);
	}
	
	public void showWinImage() {
		this.setVisible(true);
	}

}
