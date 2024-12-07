package com.example.demo.core;

import org.junit.jupiter.api.Test;

public class LevelConfigFactoryTest {
    @Test
    void testValidLevelConfig() {
        LevelConfig config=LevelConfigFactory.getConfig("LevelOne");
        assert(config.getBackgroundImage().equals("background1.jpeg"));
        assert(config.getPlayerInitialHealth()==5);
    }
    @Test
    void testInvalidLevelConfig(){
        try{
            LevelConfigFactory.getConfig("InvalidLevel");
            assert(false);
        } catch(IllegalArgumentException e) {
            assert(e.getMessage().contains("Invalid level name"));
        }
    }
}
