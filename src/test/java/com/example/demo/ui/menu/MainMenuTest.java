package com.example.demo.ui.menus;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {

    @Test
    void testShowTutorial() {
        Stage stage = new Stage();
        MainMenu menu = new MainMenu(stage, () -> {}, 1300, 750);

        assertDoesNotThrow(menu::showTutorial);
    }
}
