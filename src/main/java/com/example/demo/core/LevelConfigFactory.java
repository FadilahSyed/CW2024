package com.example.demo.core;

import java.util.Map;
/**
 * factory class that provides pre-configured {@code LevelConfig} objects for specific levels
 * level configuration includes: background image, next level, enemy count, spawn probabilities, player health
 */
public class LevelConfigFactory{

    /**
     * a static map that stores the configurations for each level.
     * Key - name of the level (eg. LevelOne)
     * Value - A {@link LevelConfig} object containing the configs for that level
     *
     * the configurations for each level include:
     * <ul>
     *     <li>background image filename</li>
     *     <li>next level's name</li>
     *     <li>total cap of enemies</li>
     *     <li>kill count required to go to next level</li>
     *     <li>spawn probabilities for different enemies</li>
     *     <li>initial player health</li>
     * </ul>
     */
    private static final Map<String, LevelConfig> LEVEL_CONFIGS = Map.of(
            "LevelOne",new LevelConfig(
                    "background2.gif","LevelTwo",5,10,0.2,0.0,5
            ),
            "LevelTwo",new LevelConfig(
                    "background2.gif","LevelThree",5,10,0.0,0.2,5
            ),
            "LevelThree",new LevelConfig(
                    "background3.jpg","LevelFour",3,3,0.0,0.0,5
            ),
            "LevelFour",new LevelConfig(
                    "background4.gif","LevelFinal",7,15,0.2,0.1,5
            ),
            "LevelFinal",new LevelConfig(
                    "background5.jpg",null,1,1,0.0,0.0,5
            )
    );
    /**
     * retrieves the {@code LevelConfig} for a specified level name
     *
     * @param levelName The name of the level
     * @return The {@code LevelConfig} object for the given level
     * @throws IllegalArgumentException if the level name is invalid/not found in map
     */
    public static LevelConfig getConfig(String levelName) {
        if(!LEVEL_CONFIGS.containsKey(levelName)) {
            throw new IllegalArgumentException("Invalid level name: "+levelName);        }
        return LEVEL_CONFIGS.get(levelName);
    }
}
