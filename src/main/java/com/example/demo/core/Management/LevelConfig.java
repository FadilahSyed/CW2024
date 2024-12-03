package com.example.demo.core.Management;

public class LevelConfig {
    private final String backgroundImage;
    private final String nextLevel;
    private final int totalEnemies;
    private final int killsToAdvance;
    private final double enemySpawnProbability;
    private final double enemySpecialSpawnProbability; // Optional for advanced levels
    private final int playerInitialHealth;

    public LevelConfig(String backgroundImage, String nextLevel, int totalEnemies,
                       int killsToAdvance, double enemySpawnProbability,
                       double enemySpecialSpawnProbability, int playerInitialHealth) {
        this.backgroundImage=backgroundImage;
        this.nextLevel=nextLevel;
        this.totalEnemies=totalEnemies;
        this.killsToAdvance=killsToAdvance;
        this.enemySpawnProbability=enemySpawnProbability;
        this.enemySpecialSpawnProbability=enemySpecialSpawnProbability;
        this.playerInitialHealth=playerInitialHealth;
    }
    public String getBackgroundImage() {
        return backgroundImage;
    }

    public String getNextLevel() {
        return nextLevel;
    }

    public int getTotalEnemies() {
        return totalEnemies;
    }

    public int getKillsToAdvance() {
        return killsToAdvance;
    }

    public double getEnemySpawnProbability() {
        return enemySpawnProbability;
    }

    public double getEnemySpecialSpawnProbability() {
        return enemySpecialSpawnProbability;
    }

    public int getPlayerInitialHealth() {
        return playerInitialHealth;
    }

}
