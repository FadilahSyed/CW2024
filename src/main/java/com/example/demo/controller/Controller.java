package com.example.demo.controller;

import com.example.demo.ui.GameOver;
import com.example.demo.ui.MainMenu;
import com.example.demo.ui.WinGame;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import com.example.demo.core.LevelParent;
import com.example.demo.utils.LevelLoader;

public class Controller {

	private static final String LEVEL_ONE_CLASS_NAME = "com.example.demo.core.LevelOne";
	private final Stage stage;


	public Controller(Stage stage) {
		this.stage = stage;
	}

	public void launchMainMenu() {
		MainMenu mainMenu = new MainMenu(stage, this::launchGame);
		mainMenu.show();
	}

	public void launchGame() {
		loadAndStartLevel(LEVEL_ONE_CLASS_NAME);
	}

	public void loadAndStartLevel(String className) {
		try {
			LevelParent level = LevelLoader.loadLevel(className, stage.getHeight(), stage.getWidth());
			level.setEventListener(event ->
			{
				if ("gameover".equals(event)) {
					showGameOver();
				} else if ("wingame".equals(event)) {
					showWinGame();
				} else {
					loadAndStartLevel(event);
				}
			});
			Scene scene = level.initializeScene();
			stage.setScene(scene);
			level.startGame();
		} catch (ReflectiveOperationException e) {
			showErrorAlert(e);
		}
	}


	public void showGameOver() {
		GameOver gameOver = new GameOver(stage, this::launchGame);
		gameOver.show();
	}

	public void showWinGame() {
		WinGame winGame = new WinGame(stage, this::launchGame);
		winGame.show();
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