package com.example.demo.controller;

import java.util.Observer;

import com.example.demo.ui.GameOver;
import com.example.demo.ui.MainMenu;
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
	public void launchMainMenu(){
		MainMenu mainMenu=new MainMenu(stage, this::launchGame);
		mainMenu.show();
	}

	public void launchGame() {
        	loadAndStartLevel(LEVEL_ONE_CLASS_NAME);
    }

	/*private void goToLevel(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Class<?> myClass = Class.forName(className);
			Constructor<?> constructor = myClass.getConstructor(double.class, double.class);
			LevelParent myLevel = (LevelParent) constructor.newInstance(stage.getHeight(), stage.getWidth());
			myLevel.addObserver(this);
			Scene scene = myLevel.initializeScene();
			stage.setScene(scene);
			myLevel.startGame();

	}*/

	public void loadAndStartLevel(String className) {
		try {
			LevelParent level = LevelLoader.loadLevel(className, stage.getHeight(), stage.getWidth());
			level.addObserver((observable, arg) ->
			{if ("gameover".equals(arg)) {
				showGameOver();
			} else {
				loadAndStartLevel((String) arg);
			}});
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

		private void showErrorAlert(Exception e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error Loading Level");
			alert.setHeaderText("An error occurred: ");
			alert.setContentText(e.getMessage());
			alert.show();
			e.printStackTrace();
		/*(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(e.getClass().toString());
			alert.show();
			e.printStackTrace();*/
		}
	}


