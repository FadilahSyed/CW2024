package com.example.demo.ui.menus;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TutorialPopUpTest {

    @Test
    void testShowTutorial() {
        Stage stage = new Stage();
        TutorialPopUp tutorialPopUp = new TutorialPopUp();

        assertDoesNotThrow(() -> tutorialPopUp.show(stage));
    }
}
