package com.example.demo.controller;

import java.lang.reflect.InvocationTargetException;

import com.example.demo.ui.GameUIFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private static final int SCREEN_WIDTH = 1300;
	private static final int SCREEN_HEIGHT = 750;
	private static final String TITLE = "Sky Battle";

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

	public static void main(String[] args) {
		launch();
	}
}