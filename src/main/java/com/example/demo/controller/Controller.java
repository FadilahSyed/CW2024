package com.example.demo.controller;

import com.example.demo.core.LevelFactory;
import com.example.demo.ui.GameUIFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import com.example.demo.core.AbstractLevel;

public class Controller {

	private static final String LEVEL_ONE_CLASS_NAME = "LevelOne";

	public enum GameEvent{
		GAME_OVER,
		WIN_GAME
	}
	private final Stage stage;
	private final GameUIFactory uiFactory;


	public Controller(Stage stage, GameUIFactory uiFactory) {
		this.stage = stage;
		this.uiFactory=uiFactory;
	}

	public void launchMainMenu() {
		uiFactory.createMainMenu(stage,this::launchGame,stage.getWidth(), stage.getHeight()).show(stage.getWidth(), stage.getHeight());
	}

	public void launchGame() {
		loadAndStartLevel(LEVEL_ONE_CLASS_NAME);
	}

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

	public void showGameOver() {
		uiFactory.createGameOver(stage,this::launchGame,stage.getWidth(), stage.getHeight()).show(stage.getWidth(), stage.getHeight());
	}

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