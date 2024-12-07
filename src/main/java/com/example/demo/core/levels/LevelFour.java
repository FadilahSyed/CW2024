package com.example.demo.core.levels;

import com.example.demo.core.LevelConfig;
import com.example.demo.core.LevelConfigFactory;
import com.example.demo.core.AbstractLevel;
import com.example.demo.ui.LevelView;

public class LevelFour extends AbstractLevel {
    private final LevelConfig config;

    public LevelFour(double screenHeight, double screenWidth) {
        super(LevelConfigFactory.getConfig("LevelFour"),screenHeight,screenWidth);
        this.config = LevelConfigFactory.getConfig("LevelFour");
    }

    @Override
    protected void checkIfGameOver() {
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
