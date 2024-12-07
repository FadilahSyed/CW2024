package com.example.demo.ui.menus;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMenuTest {

    @Test
    void testCreateImageButton() {
        Stage stage = new Stage();
        AbstractMenu menu = new TestMenu(stage);
        boolean[] actionTriggered = {false};

        Button button = menu.createImageButton("test.png", 100, 50, () -> actionTriggered[0] = true);

        assertNotNull(button.getGraphic());
        assertEquals(100, button.getGraphic().getLayoutBounds().getWidth());
        assertEquals(50, button.getGraphic().getLayoutBounds().getHeight());

        button.fire();
        assertTrue(actionTriggered[0]);
    }

    static class TestMenu extends AbstractMenu {
        public TestMenu(Stage stage) {
            super(stage, "testBackground.png", 1300, 750);
        }
    }
}
