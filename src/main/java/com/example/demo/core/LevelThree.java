package com.example.demo.core;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.MiniBoss;
import com.example.demo.ui.LevelView;

public class LevelThree extends LevelParent {
    private static final String BACKGROUND_IMAGE_NAME = "background2.jpeg";
    private static final String NEXT_LEVEL = "com.example.demo.core.LevelFour";
    private static final int TOTAL_ENEMIES = 3;
    private static final int KILLS_TO_ADVANCE = 3;
    private static final int PLAYER_INITIAL_HEALTH = 5;


    public LevelThree(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
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
            goToNextLevel(NEXT_LEVEL);}

    }

    @Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies()==0) {
            for(int i=0;i<TOTAL_ENEMIES;i++) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new MiniBoss(newEnemyInitialYPosition);
                addEnemyUnit(newEnemy);
            }
        }
    }

    @Override
    protected LevelView instantiateLevelView() {
        return new LevelView(getRoot(),PLAYER_INITIAL_HEALTH);
    }

    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
    }

}
