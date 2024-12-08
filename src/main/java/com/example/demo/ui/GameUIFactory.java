package com.example.demo.ui;
import com.example.demo.ui.menus.GameOverMenu;
import com.example.demo.ui.menus.MainMenu;
import com.example.demo.ui.menus.WinGameMenu;
import javafx.stage.Stage;

/**
 * Factory class responsible for creating game menus
 * like MainMenu, GameOverScreen and WinGameScreen
 */
public class GameUIFactory {
    /**
     * Creates the MainMenu
     * @param stage         The primary stage to display the menu
     * @param onPlay        Callback to trigger when "Play" button is clicked
     * @param screenWidth   The width of the game screen
     * @param screenHeight  The height of the game screen
     * @return              An instance of {@code MainMenu}
     */
    public MainMenu createMainMenu(Stage stage, Runnable onPlay,double screenWidth, double screenHeight) {
        return new MainMenu(stage, onPlay,screenWidth,screenHeight);
    }

    /**
     * Creates the GameOver screen
     * @param stage         The primary stage to display the menu
     * @param onRetry        Callback to trigger when "Replay" button is clicked
     * @param screenWidth   The width of the game screen
     * @param screenHeight  The height of the game screen
     * @return              An instance of {@code GameOverMenu}
     */
    public GameOverMenu createGameOver(Stage stage, Runnable onRetry, double screenWidth, double screenHeight) {
        return new GameOverMenu(stage,onRetry,screenWidth,screenHeight);
    }

    /**
     * Creates the GameOver screen
     * @param stage         The primary stage to display the menu
     * @param onRetry        Callback to trigger when "Replay" button is clicked
     * @param screenWidth   The width of the game screen
     * @param screenHeight  The height of the game screen
     * @return              An instance of {@code WinGameMenu}
     */
    public WinGameMenu createWinGame(Stage stage, Runnable onRetry,double screenWidth, double screenHeight) {
        return new WinGameMenu(stage,onRetry,screenWidth,screenHeight);
    }
}
