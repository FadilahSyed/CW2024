package com.example.demo.core;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.ui.LevelView;
import javafx.scene.Group;

public class TestLevel extends AbstractLevel {

    public TestLevel(LevelConfig config, double screenHeight, double screenWidth) {
        super(config, screenHeight, screenWidth);
    }

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

    @Override
    protected void checkIfGameOver() {
        if (userIsDestroyed()) {
            loseGame();
        }
    }

    @Override
    protected void spawnEnemyUnits() {
        // Add a simple enemy for testing purposes
        ActiveActorDestructible testEnemy = new ActiveActorDestructible("enemy.png", 50, 100, 100) {
            @Override
            public void updatePosition() {}

            @Override
            public void updateActor() {}

            @Override
            public void takeDamage() {
                destroy();
            }
        };
        addEnemyUnit(testEnemy);
    }

    @Override
    protected LevelView instantiateLevelView(LevelConfig config) {
        return new LevelView(new Group(), 5);
    }
}
