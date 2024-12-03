package com.example.demo.ui;
import javafx.stage.Stage;

public class GameUIFactory {
    public MainMenu createMainMenu(Stage stage,Runnable onPlay) {
        return new MainMenu(stage, onPlay);
    }
    public GameOver createGameOver(Stage stage, Runnable onRetry) {
        return new GameOver(stage,onRetry);
    }
    public WinGame createWinGame(Stage stage,Runnable onNextGame) {
        return new WinGame(stage,onNextGame);
    }
}
