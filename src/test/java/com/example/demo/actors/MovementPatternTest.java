package com.example.demo.actors;

import com.example.demo.actors.movement.RandomMovementPattern;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementPatternTest {

    @Test
    void testRandomMovementPattern() {
        RandomMovementPattern movementPattern = new RandomMovementPattern();

        for (int i = 0; i < 100; i++) {
            int move = movementPattern.getNextMove();
            assertTrue(move == 0 || move == 8 || move == -8,
                    "Move should be one of the predefined velocities (0, 8, -8)");
        }
    }
}
