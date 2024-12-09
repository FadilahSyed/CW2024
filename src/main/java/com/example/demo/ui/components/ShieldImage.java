package com.example.demo.ui.components;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.ImageView;

/**
 * the {@code ShieldImage} class represents a shield graphic
 * that can be shown or hidden during gameplay to indicate the
 * boss's shield status
 */
public class ShieldImage extends ImageView {
	
	private static final String IMAGE_NAME = "shield.png";
	private static final int SHIELD_SIZE = 150;

	/**
	 * constructs a {@code ShieldImage} with preloaded shield graphics
	 * the shield is initialised as invisible by default
	 */
	public ShieldImage() {
		this.setImage(ImageLoader.load(IMAGE_NAME));
		this.setVisible(false);
		this.setFitHeight(SHIELD_SIZE);
		this.setFitWidth(SHIELD_SIZE);
	}

	/**
	 * makes the shield visible on screen
	 */
	public void showShield() {
		this.setVisible(true);
	}

	/**
	 * hides shield from screen
	 */
	public void hideShield() {
		this.setVisible(false);
	}

}
