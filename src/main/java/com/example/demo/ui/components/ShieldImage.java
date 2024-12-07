package com.example.demo.ui.components;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ShieldImage extends ImageView {
	
	private static final String IMAGE_NAME = "shield.png";
	private static final int SHIELD_SIZE = 200;
	
	public ShieldImage() {
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
