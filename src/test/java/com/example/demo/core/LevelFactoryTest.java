package com.example.demo.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelFactoryTest {

    @Test
    void testCreateValidLevel() {
        AbstractLevel level = LevelFactory.createLevel("LevelOne", 750, 1300);
        assertNotNull(level);
    }

    @Test
    void testInvalidLevelName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                LevelFactory.createLevel("InvalidLevel", 750, 1300));

        assertEquals("Invalid level name: InvalidLevel", exception.getMessage());
    }
}
