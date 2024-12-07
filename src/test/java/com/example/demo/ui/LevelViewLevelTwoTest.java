package com.example.demo.ui;

import javafx.scene.Group;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelViewLevelTwoTest {

    @Test
    void testUpdateShieldPosition() {
        Group root = new Group();
        LevelViewLevelTwo levelView = new LevelViewLevelTwo(root, 3);

        levelView.updateShieldPosition(100, 100);
        assertEquals(-50, root.getChildren().get(1).getLayoutX());
        assertEquals(20, root.getChildren().get(1).getLayoutY());
    }

    @Test
    void testShowAndHideShield() {
        Group root = new Group();
        LevelViewLevelTwo levelView = new LevelViewLevelTwo(root, 3);

        assertDoesNotThrow(levelView::showShield);
        assertDoesNotThrow(levelView::hideShield);
    }
}
