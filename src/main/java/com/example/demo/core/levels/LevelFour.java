package com.example.demo.core.levels;

import com.example.demo.core.LevelConfig;
import com.example.demo.core.LevelConfigFactory;
import com.example.demo.core.AbstractLevel;
import com.example.demo.ui.LevelView;

public class LevelFour extends AbstractLevel {

    /*private static final String BACKGROUND_IMAGE_NAME = "background2.jpeg";
    private static final String NEXT_LEVEL = "LevelFinal";
    private static final int TOTAL_ENEMIES = 7;
    private static final int KILLS_TO_ADVANCE = 15;
    private static final double ENEMY_SPAWN_PROBABILITY = .2;
    private static final double ENEMY3_SPAWN_PROBABILITY = .1;
    private static final int PLAYER_INITIAL_HEALTH = 5;*/
    private final LevelConfig config;

    public LevelFour(double screenHeight, double screenWidth) {
        super(LevelConfigFactory.getConfig("LevelFour"),screenHeight,screenWidth);
        this.config = LevelConfigFactory.getConfig("LevelFour");
    }

    @Override
    protected void checkIfGameOver() {
        //if (userIsDestroyed()) {
        if (getUser().isDestroyed()) {
            System.out.println("userisdestroyed l1");
            loseGame();
        }
        else if (userHasReachedKillTarget()) {
            goToNextLevel(config.getNextLevel()); }
    }

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

    /*@Override
    protected void spawnEnemyUnits() {
        int currentNumberOfEnemies = getCurrentNumberOfEnemies();
        for (int i = 0; i < config.getTotalEnemies() - currentNumberOfEnemies; i++) {
            if (Math.random() < config.getEnemySpawnProbability()) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new EnemyPlane(getScreenWidth(), newEnemyInitialYPosition);
                addEnemyUnit(newEnemy);
            }
            if (Math.random() < config.getEnemy2SpawnProbability()) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new Enemy2Plane(getScreenWidth(), newEnemyInitialYPosition);
                addEnemyUnit(newEnemy);
            }
        }
    }*/
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
