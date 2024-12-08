package com.example.demo.controller;

import com.example.demo.ui.GameUIFactory;
import com.example.demo.utils.PlaneConstants;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The {@code Main} class is the entry point for the game application
 * It sets up the main JavaFX stage/window with the appropraite properties
 * and launches the game through the {@code Controller}
 */
public class Main extends Application {

	private static final int SCREEN_WIDTH = PlaneConstants.SCREEN_WIDTH;
	private static final int SCREEN_HEIGHT = PlaneConstants.SCREEN_HEIGHT;
	private static final String TITLE = "Space Battle";

	/**
	 * Starts the JavaFX application by setting up the main stage
	 * @param stage The primary stage for this application
	 */

	@Override
	public void start(Stage stage) {
		try {
			stage.setTitle(TITLE);
			stage.setResizable(false);
			stage.setHeight(SCREEN_HEIGHT);
			stage.setWidth(SCREEN_WIDTH);
			GameUIFactory uiFactory = new GameUIFactory();
			Controller controller = new Controller(stage,uiFactory);
			controller.launchMainMenu();
		} catch (Exception e) {
			System.err.println("error launching game: " + e.getMessage());
		}
	}

	/**
	 * The main method, which launches the application
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		launch();
	}
}