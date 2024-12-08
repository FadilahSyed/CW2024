package com.example.demo.controller;

import com.example.demo.core.LevelFactory;
import com.example.demo.ui.GameUIFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import com.example.demo.core.AbstractLevel;

/**
 * The {@code Controller} class manages the flow of the game
 * - it handles transitions between different game states
 *  and navigates through appropriate screens
 *  by launching menus, loading levels and handling game events
 */
public class Controller {

	private static final String LEVEL_ONE_CLASS_NAME = "LevelOne";

	/**
	 * Enum represents the game events GAME_OVER and WIN_GAME
	 */
	public enum GameEvent{
		GAME_OVER,
		WIN_GAME
	}
	private final Stage stage;
	private final GameUIFactory uiFactory;

	/**
	 * Constructs a {@code Controller} with the given stage and UIFactory
	 * @param stage		The primary stage for displaying the game scenes
	 * @param uiFactory The factory for creating UI components
	 */
	public Controller(Stage stage, GameUIFactory uiFactory) {
		this.stage = stage;
		this.uiFactory=uiFactory;
	}

	/**
	 * Launches the main menu screen
	 */
	public void launchMainMenu() {
		uiFactory.createMainMenu(stage,this::launchGame,stage.getWidth(), stage.getHeight()).show(stage.getWidth(), stage.getHeight());
	}

	/**
	 * Launches the first level
	 */
	public void launchGame() {
		loadAndStartLevel(LEVEL_ONE_CLASS_NAME);
	}

	/**
	 * Laods and starts a specified level
	 * @param levelName The name of the level to load
	 */
	public void loadAndStartLevel(String levelName) {
		try {
			AbstractLevel level= LevelFactory.createLevel(levelName,stage.getHeight(),stage.getWidth());
			level.setEventListener(event-> {
				try {
					GameEvent gameEvent=GameEvent.valueOf(event.toUpperCase());
					handleGameEvent(gameEvent);
				} catch (IllegalArgumentException e) {
					loadAndStartLevel(event);
				}
			});

			Scene scene=level.initializeScene();
			stage.setScene(scene);
			level.startGame();

		} catch (IllegalArgumentException e) {
			showErrorAlert(e);
		}
	}

	/**
	 * Handles game event by calling methods required when an event occurs
	 * @param event The game event to handle
	 */
	private void handleGameEvent(GameEvent event) {
		switch(event) {
			case GAME_OVER:
				showGameOver();
				break;
			case WIN_GAME:
				showWinGame();
				break;
			default:
				loadAndStartLevel(event.name());
				break;
		}
	}

	/**
	 * shows the game over screen - launches when player fails
	 */
	public void showGameOver() {
		uiFactory.createGameOver(stage,this::launchGame,stage.getWidth(), stage.getHeight()).show(stage.getWidth(), stage.getHeight());
	}

	/**
	 * shows win game screen - launches when player wins all levels
	 */
	public void showWinGame() {
		uiFactory.createWinGame(stage,this::launchGame,stage.getWidth(), stage.getHeight()).show(stage.getWidth(), stage.getHeight());
	}


	private void showErrorAlert(Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Loading Level");
		alert.setHeaderText("An error occurred: ");
		alert.setContentText(e.getMessage());
		alert.show();
		e.printStackTrace();
	}
}