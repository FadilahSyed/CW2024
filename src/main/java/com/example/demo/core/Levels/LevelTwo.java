package com.example.demo.core.Levels;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.Enemy2Plane;
import com.example.demo.core.Management.LevelConfig;
import com.example.demo.core.Management.LevelConfigFactory;
import com.example.demo.core.Management.LevelParent;
import com.example.demo.ui.LevelView;

public class LevelTwo extends LevelParent {
    /*
    private static final String BACKGROUND_IMAGE_NAME = "background1.jpeg";
    private static final String NEXT_LEVEL = "LevelThree";
    private static final int TOTAL_ENEMIES = 5;
    private static final int KILLS_TO_ADVANCE = 10;
    private static final double ENEMY_SPAWN_PROBABILITY = .20;
    private static final int PLAYER_INITIAL_HEALTH = 5;*/

    private final LevelConfig config;

    public LevelTwo(double screenHeight, double screenWidth) {
        super(LevelConfigFactory.getConfig("LevelTwo"), screenHeight, screenWidth);
        this.config = LevelConfigFactory.getConfig("LevelTwo");
    }

        @Override
        protected void checkIfGameOver() {
        //if (userIsDestroyed()) {
        if (getUser().isDestroyed()) {
            loseGame();
        }
        else if (userHasReachedKillTarget()) {
            goToNextLevel(config.getNextLevel()); }
    }

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

    @Override
    protected void spawnEnemyUnits() {
        int currentNumberOfEnemies = getCurrentNumberOfEnemies();
        for (int i = 0; i < config.getTotalEnemies() - currentNumberOfEnemies; i++) {
            if (Math.random() < config.getEnemySpawnProbability()) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new Enemy2Plane(getScreenWidth(), newEnemyInitialYPosition);
                addEnemyUnit(newEnemy);
            }
        }
    }

    @Override
    protected LevelView instantiateLevelView(LevelConfig config) {
        return new LevelView(getRoot(), config.getPlayerInitialHealth());
    }

    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= config.getKillsToAdvance();
    }

}
