package com.example.demo.core.levels;

import com.example.demo.core.LevelConfig;
import com.example.demo.core.LevelConfigFactory;
import com.example.demo.core.AbstractLevel;
import com.example.demo.ui.LevelView;

public class LevelThree extends AbstractLevel {
    private final LevelConfig config;


    public LevelThree(double screenHeight, double screenWidth) {
        super(LevelConfigFactory.getConfig("LevelThree"),screenHeight,screenWidth);
        this.config = LevelConfigFactory.getConfig("LevelThree");
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
        else if (userHasReachedKillTarget()) {
            goToNextLevel(config.getNextLevel());}

    }
    @Override
    protected void spawnEnemyUnits() {
        spawnEnemies(config);
    }

    @Override
    protected LevelView instantiateLevelView(LevelConfig config) {
        return new LevelView(getRoot(), config.getPlayerInitialHealth());
    }

    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= config.getKillsToAdvance();
    }

}
