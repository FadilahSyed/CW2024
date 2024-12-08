package com.example.demo.actors.movement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.utils.PlaneConstants;

public class RandomMovementPattern implements MovementStrategy {
    private static final int VERTICAL_VELOCITY = PlaneConstants.VERTICAL_VELOCITY;
    private static final int MOVE_FREQUENCY_PER_CYCLE = PlaneConstants.MOVE_FREQUENCY_PER_CYCLE;
    private static final int MAX_FRAMES_WITH_SAME_MOVE = PlaneConstants.MAX_FRAMES_WITH_SAME_MOVE;
    private static final int ZERO = 0;

    private final List<Integer> movePattern;
    private int consecutiveMovesInSameDirection;
    private int indexOfCurrentMove;

    public RandomMovementPattern() {
        movePattern = new ArrayList<>();
        consecutiveMovesInSameDirection = 0;
        indexOfCurrentMove = 0;
        initializeMovePattern();
    }
    public int getNextMove() {
        int currentMove = movePattern.get(indexOfCurrentMove);
        consecutiveMovesInSameDirection++;
        if (consecutiveMovesInSameDirection == getMaxFramesWithSameMove()) {
            Collections.shuffle(movePattern);
            consecutiveMovesInSameDirection = 0;
            indexOfCurrentMove++;
        }
        if (indexOfCurrentMove == movePattern.size()) {
            indexOfCurrentMove = 0;
        }
        return currentMove;
    }
    private void initializeMovePattern() {
        for (int i = 0; i < MOVE_FREQUENCY_PER_CYCLE; i++) {
            movePattern.add(getVerticalVelocity());
            movePattern.add(-getVerticalVelocity());
            movePattern.add(ZERO);
        }
        Collections.shuffle(movePattern);
    }

    public static int getVerticalVelocity() {
        return VERTICAL_VELOCITY;
    }
    public static int getMaxFramesWithSameMove() {
        return MAX_FRAMES_WITH_SAME_MOVE;
    } //encapsulation???
}
