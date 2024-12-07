package com.example.demo.actors.movement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMovementPatternTest {

    @Test
    void testGetNextMove() {
        RandomMovementPattern movement = new RandomMovementPattern();

        int move = movement.getNextMove();
        assertTrue(move == 0 || move == 8 || move == -8);
    }

    @Test
    void testMaxFramesWithSameMove() {
        assertEquals(10, RandomMovementPattern.getMaxFramesWithSameMove());
    }
}
