package com.example.demo.ui;

import com.example.demo.ui.menus.GameOverMenu;
import com.example.demo.ui.menus.MainMenu;
import com.example.demo.ui.menus.WinGameMenu;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameUIFactoryTest {

    @Test
    void testCreateMainMenu() {
        GameUIFactory factory = new GameUIFactory();
        MainMenu menu = factory.createMainMenu(new Stage(), () -> {}, 1300, 750);
        assertNotNull(menu);
    }

    @Test
    void testCreateGameOverMenu() {
        GameUIFactory factory = new GameUIFactory();
        GameOverMenu menu = factory.createGameOver(new Stage(), () -> {}, 1300, 750);
        assertNotNull(menu);
    }

    @Test
    void testCreateWinGameMenu() {
        GameUIFactory factory = new GameUIFactory();
        WinGameMenu menu = factory.createWinGame(new Stage(), () -> {}, 1300, 750);
        assertNotNull(menu);
    }
}
