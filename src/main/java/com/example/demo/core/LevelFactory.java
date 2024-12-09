package com.example.demo.core;

import com.example.demo.core.levels.*;

/**
 * a factory class for creating instances of levels based on their names.
 */
public class LevelFactory {

    /**
     * creates and returns an {@code AbstractLevel} instance for the specified level name
     *
     * @param levelName     the name of the level
     * @param screenHeight  the height of the game screen
     * @param screenWidth   the width of the game screen
     * @return              an instance of {@code AbstractLevel}
     * @throws IllegalArgumentException if the level name is invalid
     */
    public static AbstractLevel createLevel(String levelName, double screenHeight, double screenWidth) {
        switch(levelName.toLowerCase()) {
            case "levelone":
                return new LevelOne(screenHeight,screenWidth);
            case "leveltwo":
                return new LevelTwo(screenHeight,screenWidth);
            case "levelthree":
                return new LevelThree(screenHeight,screenWidth);
            case "levelfour":
                return new LevelFour(screenHeight,screenWidth);
            case "levelfinal":
                return new LevelFinal(screenHeight,screenWidth);
            default:
                throw new IllegalArgumentException("Invalid level name: "+levelName);
        }
    }
}
