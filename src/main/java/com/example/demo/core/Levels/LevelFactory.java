package com.example.demo.core.Levels;

import com.example.demo.core.Management.LevelParent;

public class LevelFactory {
    public static LevelParent createLevel(String levelName, double screenHeight, double screenWidth) {
        switch(levelName.toLowerCase()) {
            case "levelone":
                return new LevelOne(screenHeight,screenWidth);
            case "leveltwo":
                return new LevelTwo(screenHeight,screenWidth);
            case "levelthree":
                return new LevelThree(screenHeight,screenWidth);
            case "levelfour":
                return new LevelFour(screenHeight,screenWidth);
            case "levelfive":
                return new LevelFive(screenHeight,screenWidth);
            default:
                throw new IllegalArgumentException("Invalid level name: "+levelName);
        }
    }
}
