package com.example.demo.controller;

import com.example.demo.core.Management.LevelFactory;
import com.example.demo.ui.GameUIFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import com.example.demo.core.Management.LevelParent;

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
		//MainMenu mainMenu = new MainMenu(stage, this::launchGame);
		//mainMenu.show();
		uiFactory.createMainMenu(stage,this::launchGame).show();
	}

	public void launchGame() {
		loadAndStartLevel(LEVEL_ONE_CLASS_NAME);
	}

	public void loadAndStartLevel(String levelName) {
		try {
			LevelParent level= LevelFactory.createLevel(levelName,stage.getHeight(),stage.getWidth());
			level.setEventListener(event-> {
				try {
					GameEvent gameEvent=GameEvent.valueOf(event.toUpperCase());
					handleGameEvent(gameEvent);
					//handleGameEvent(GameEvent.valueOf(event.toUpperCase())));
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

		/*try {
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
		}*/
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
		uiFactory.createGameOver(stage,this::launchGame).show();
		//GameOver gameOver = new GameOver(stage, this::launchGame);
		//gameOver.show();
	}

	public void showWinGame() {
		uiFactory.createWinGame(stage,this::launchGame).show();
		//WinGame winGame = new WinGame(stage, this::launchGame);
		//winGame.show();
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