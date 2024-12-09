package com.example.demo.core;


/**
 * the configuration settings for a level, including enemy properties, background image,
 * and player health.
 */
public class LevelConfig {
    private final String backgroundImage;
    private final String nextLevel;
    private final int totalEnemies;
    private final int killsToAdvance;
    private final double enemySpawnProbability;
    private final double enemy2SpawnProbability;
    private final int playerInitialHealth;
    /**
     * constructs a {@code LevelConfig} with specified level settings.
     *
     * @param backgroundImage         path to the background image
     * @param nextLevel               name of the next level
     * @param totalEnemies            total number of enemies in the level
     * @param killsToAdvance          no of kills required to advance to the next level
     * @param enemySpawnProbability   spawn probability for enemyplane
     * @param enemy2SpawnProbability  spawn probability for enemy2plane
     * @param playerInitialHealth     initial health of the player
     */
    public LevelConfig(String backgroundImage, String nextLevel, int totalEnemies,
                       int killsToAdvance, double enemySpawnProbability,
                       double enemy2SpawnProbability, int playerInitialHealth) {
        this.backgroundImage=backgroundImage;
        this.nextLevel=nextLevel;
        this.totalEnemies=totalEnemies;
        this.killsToAdvance=killsToAdvance;
        this.enemySpawnProbability=enemySpawnProbability;
        this.enemy2SpawnProbability=enemy2SpawnProbability;
        this.playerInitialHealth=playerInitialHealth;
    }
    /**
     * retrieves the file path of the background image for the level.
     * @return background image file name as a {@code String}.
     */
    public String getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * retrieves the name of the next level
     *
     * @return next level's name as a {@code String}.
     */
    public String getNextLevel() {
        return nextLevel;
    }

    /**
     * Retrieves the cap of enemies in the level
     *
     * @return  cap of enemies as an integer.
     */
    public int getTotalEnemies() {
        return totalEnemies;
    }

    /**
     * retrieves the number of kills required to go to the next level
     *
     * @return  number of kills to advance as an int
     */
    public int getKillsToAdvance() {
        return killsToAdvance;
    }

    /**
     * retrieves the probability of spawning enemyplane
     *
     * @return enemy spawn probability as a double value
     */
    public double getEnemySpawnProbability() {
        return enemySpawnProbability;
    }

    /**
     * retrieves probability of spawning enemy2plane
     * @return enemy2 spawn probability as a double value
     */
    public double getEnemy2SpawnProbability() {
        return enemy2SpawnProbability;
    }

    /**
     * retrieves initial health of player
     * @return players intital health
     */
    public int getPlayerInitialHealth() {
        return playerInitialHealth;
    }

}
