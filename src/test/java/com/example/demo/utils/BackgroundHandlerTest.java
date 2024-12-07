package com.example.demo.utils;

import com.example.demo.actors.planes.UserPlane;
import com.example.demo.core.AbstractLevel;
import com.example.demo.core.LevelConfig;
import com.example.demo.ui.LevelView;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackgroundHandlerTest {

    @Test
    void testInitializeBackground() {
        ImageView background = new ImageView();
        UserPlane user = new UserPlane(5);
        AbstractLevel level = new TestLevel();

        BackgroundHandler handler = new BackgroundHandler(background, user, level);

        Group root = new Group();
        handler.initializeBackground(root, 1300, 750);

        assertTrue(root.getChildren().contains(background));
        assertEquals(1300, background.getFitWidth());
        assertEquals(750, background.getFitHeight());
    }

    static class TestLevel extends AbstractLevel {
        public TestLevel() {
            super(new LevelConfig("bg.jpg", "NextLevel", 5, 3, 0.1, 0.1, 5), 750, 1300);
        }

        @Override
        protected void initializeFriendlyUnits() {}
        @Override
        protected void checkIfGameOver() {}
        @Override
        protected void spawnEnemyUnits() {}
        @Override
        protected LevelView instantiateLevelView(LevelConfig config) { return null; }
    }
}
