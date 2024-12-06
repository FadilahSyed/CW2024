package com.example.demo.core;

import com.example.demo.core.LevelConfig;

import java.util.Map;

public class LevelConfigFactory{
    private static final Map<String, LevelConfig> LEVEL_CONFIGS = Map.of(
            "LevelOne",new LevelConfig(
                    "background1.jpeg","LevelTwo",5,10,0.2,0.0,5
            ),
            "LevelTwo",new LevelConfig(
                    "background1.jpeg","LevelThree",5,10,0.0,0.2,5
            ),
            "LevelThree",new LevelConfig(
                    "background2.jpeg","LevelFour",3,3,0.0,0.0,5
            ),
            "LevelFour",new LevelConfig(
                    "background2.jpeg","LevelFinal",7,15,0.2,0.1,5
            ),
            "LevelFinal",new LevelConfig(
                    "background3.jpeg",null,1,1,0.0,0.0,5
            )
    );

    public static LevelConfig getConfig(String levelName) {
        if(!LEVEL_CONFIGS.containsKey(levelName)) {
            throw new IllegalArgumentException("Invalid level name: "+levelName);        }
        return LEVEL_CONFIGS.get(levelName);
    }
}
