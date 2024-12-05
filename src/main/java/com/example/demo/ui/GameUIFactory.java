package com.example.demo.ui;
import com.example.demo.ui.menus.GameOverMenu;
import com.example.demo.ui.menus.MainMenu;
import com.example.demo.ui.menus.WinGameMenu;
import javafx.stage.Stage;

public class GameUIFactory {
    public MainMenu createMainMenu(Stage stage, Runnable onPlay) {
        return new MainMenu(stage, onPlay);
    }
    public GameOverMenu createGameOver(Stage stage, Runnable onRetry) {
        return new GameOverMenu(stage,onRetry);
    }
    public WinGameMenu createWinGame(Stage stage, Runnable onNextGame) {
        return new WinGameMenu(stage,onNextGame);
    }
}
