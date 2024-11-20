package com.example.demo.ui;

import com.example.demo.utils.ImageLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class HeartDisplay {
	
	private static final String HEART_IMAGE_NAME = "heart.png";
	private static final int HEART_HEIGHT = 50;
	private static final int INDEX_OF_FIRST_ITEM = 0;
	private final HBox container = new HBox();
	//private double containerXPosition;
	//private double containerYPosition;
	//private int numberOfHeartsToDisplay;
	
	public HeartDisplay(double xPosition, double yPosition, int heartsToDisplay) {
		container.setLayoutX(xPosition);
		container.setLayoutY(yPosition);
		//this.numberOfHeartsToDisplay = heartsToDisplay;
		//initializeContainer();
		initializeHearts(heartsToDisplay);
	}
	
	/*private void initializeContainer() {
		container = new HBox();
		container.setLayoutX(containerXPosition);
		container.setLayoutY(containerYPosition);		
	}*/
	
	private void initializeHearts(int numberOfHearts) {
		for (int i = 0; i < numberOfHearts; i++) {
			ImageView heart = new ImageView(ImageLoader.load(HEART_IMAGE_NAME));
			heart.setFitHeight(HEART_HEIGHT);
			heart.setPreserveRatio(true);
			container.getChildren().add(heart);
		}
	}
	
	public void removeHeart() {
		if (!container.getChildren().isEmpty())
			container.getChildren().remove(INDEX_OF_FIRST_ITEM);
	}
	
	public HBox getContainer() {
		return container;
	}

}
