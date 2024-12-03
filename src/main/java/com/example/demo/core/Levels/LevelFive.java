package com.example.demo.core.Levels;

import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.planes.EnemyTripleShotPlane;
import com.example.demo.core.Management.LevelParent;
import com.example.demo.ui.LevelView;

public class LevelFive extends LevelParent {

    private static final String BACKGROUND_IMAGE_NAME = "background1.jpeg";
    private static final String NEXT_LEVEL = "com.example.demo.core.Levels.LevelFinal";
    private static final int TOTAL_ENEMIES = 3;
    private static final int KILLS_TO_ADVANCE = 10;
    private static final double ENEMY_SPAWN_PROBABILITY = .20;
    private static final int PLAYER_INITIAL_HEALTH = 5;

    public LevelFive(double screenHeight, double screenWidth) {
        super(BACKGROUND_IMAGE_NAME, screenHeight, screenWidth, PLAYER_INITIAL_HEALTH);
    }

    @Override
    protected void checkIfGameOver() {
        //if (userIsDestroyed()) {
        if (getUser().isDestroyed()) {
            System.out.println("userisdestroyed l1");
            loseGame();
        }
        else if (userHasReachedKillTarget()) {
            goToNextLevel(NEXT_LEVEL); }
    }

    @Override
    protected void initializeFriendlyUnits() {
        getRoot().getChildren().add(getUser());
    }

    @Override
    protected void spawnEnemyUnits() {
        if (getCurrentNumberOfEnemies()==0) {
            for(int i=0;i<TOTAL_ENEMIES;i++) {
                double newEnemyInitialYPosition = Math.random() * getEnemyMaximumYPosition();
                ActiveActorDestructible newEnemy = new EnemyTripleShotPlane(newEnemyInitialYPosition,getRoot());
                addEnemyUnit(newEnemy);
            }
        }
    }

    @Override
    protected LevelView instantiateLevelView() {
        return new LevelView(getRoot(), PLAYER_INITIAL_HEALTH);
    }

    private boolean userHasReachedKillTarget() {
        return getUser().getNumberOfKills() >= KILLS_TO_ADVANCE;
    }

}
