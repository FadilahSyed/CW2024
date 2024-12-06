package com.example.demo.ui;
import com.example.demo.ui.menus.GameOverMenu;
import com.example.demo.ui.menus.MainMenu;
import com.example.demo.ui.menus.WinGameMenu;
import javafx.stage.Stage;

public class GameUIFactory {
    public MainMenu createMainMenu(Stage stage, Runnable onPlay,double screenWidth, double screenHeight) {
        return new MainMenu(stage, onPlay,screenWidth,screenHeight);
    }
    public GameOverMenu createGameOver(Stage stage, Runnable onRetry, double screenWidth, double screenHeight) {
        return new GameOverMenu(stage,onRetry,screenWidth,screenHeight);
    }
    public WinGameMenu createWinGame(Stage stage, Runnable onNextGame,double screenWidth, double screenHeight) {
        return new WinGameMenu(stage,onNextGame,screenWidth,screenHeight);
    }
}
