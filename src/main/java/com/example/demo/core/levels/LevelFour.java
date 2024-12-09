package com.example.demo.core.levels;

import com.example.demo.core.LevelConfig;
import com.example.demo.core.LevelConfigFactory;
import com.example.demo.core.AbstractLevel;
import com.example.demo.ui.LevelView;

/**
 * level 4 of the game
 * --> initialises player's plane,
 * spawns 2 type of planes - enemyplane + enemy2plane
 * checks game-over conditions
 */
public class LevelFour extends AbstractLevel {
    private final LevelConfig config;

    /**
     * constructs a {@code LevelFour} instance with specified screen dimensions
     * initialises level configurations
     * @param screenHeight height of game screen
     * @param screenWidth  width of game screen
     */
    public LevelFour(double screenHeight, double screenWidth) {
        super(LevelConfigFactory.getConfig("LevelFour"),screenHeight,screenWidth);
        this.config = LevelConfigFactory.getConfig("LevelFour");
    }

    /**
     * checks if game is over by evaluating 2 conditions:
     * 1) if the user's plane is destroyed --> game is lost
     * 2) if the user has reached the kill target --> game is won
     */
    @Override
    protected void checkIfGameOver() {
        if (getUser().isDestroyed()) {
            loseGame();
        }
        else if (userHasReachedKillTarget()) {
            goToNextLevel(config.getNextLevel()); }
    }

    /**
     * initialises player's plane + adds it to game root
     * -- this is the primary friendly unit for the level
     */
    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

    /**
     * spawns enemy units for the levels based on level configurations
     */
    @Override
    protected void spawnEnemyUnits() {
        spawnEnemies(config);
    }

    /**
     * instantiates level view for this level
     * The {@code LevelView} view is used to display game-related elements like the health display
     * @param config the level configuration for the current level
     * @return An instance of {@code LevelView}
     */
    @Override
    protected LevelView instantiateLevelView(LevelConfig config) {
        return new LevelView(getRoot(), config.getPlayerInitialHealth());
    }

    /**
     * checks if the user has reached the required kill target to advance to the next level
     * @return {@code true} if the kill target is reached, otherwise {@code false}
     */
    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= config.getKillsToAdvance();
    }

}
