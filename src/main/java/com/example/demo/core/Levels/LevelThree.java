package com.example.demo.core.Levels;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.MiniBoss;
import com.example.demo.core.Management.LevelConfig;
import com.example.demo.core.Management.LevelConfigFactory;
import com.example.demo.core.Management.LevelParent;
import com.example.demo.ui.LevelView;

public class LevelThree extends LevelParent {
    /*private static final String BACKGROUND_IMAGE_NAME = "background2.jpeg";
    private static final String NEXT_LEVEL = "LevelFour";
    private static final int TOTAL_ENEMIES = 3;
    private static final int KILLS_TO_ADVANCE = 3;
    private static final int PLAYER_INITIAL_HEALTH = 5;*/
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
            System.out.println("userisdestroyed l3");
            loseGame();
        }
        else if (userHasReachedKillTarget()) {
            goToNextLevel(config.getNextLevel());}

    }

    /*@Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies()==0) {
            for(int i=0;i< config.getTotalEnemies();i++) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new MiniBoss(newEnemyInitialYPosition);
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
