package com.example.demo.core;

import com.example.demo.core.levels.*;

public class LevelFactory {
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
