package com.example.demo.actors.movement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.utils.CommonConstants;

/**
 * implements a random movement pattern strategy for game actors.
 */
public class RandomMovementPattern implements MovementStrategy {
    private static final int VERTICAL_VELOCITY = CommonConstants.VERTICAL_VELOCITY;
    private static final int MOVE_FREQUENCY_PER_CYCLE = CommonConstants.MOVE_FREQUENCY_PER_CYCLE;
    private static final int MAX_FRAMES_WITH_SAME_MOVE = CommonConstants.MAX_FRAMES_WITH_SAME_MOVE;
    private static final int ZERO = 0;

    private final List<Integer> movePattern;
    private int consecutiveMovesInSameDirection;
    private int indexOfCurrentMove;

    /**
     * constructs a {@code RandomMovementPattern} with randomized move actions.
     */
    public RandomMovementPattern() {
        movePattern = new ArrayList<>();
        consecutiveMovesInSameDirection = 0;
        indexOfCurrentMove = 0;
        initializeMovePattern();
    }

    /**
     * returns the next movement direction
     *
     * @return An integer representing the movement action.
     */
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

    /**
     * initialises the movement pattern with upward, downward, and no movement actions.
     */
    private void initializeMovePattern() {
        for (int i = 0; i < MOVE_FREQUENCY_PER_CYCLE; i++) {
            movePattern.add(getVerticalVelocity());
            movePattern.add(-getVerticalVelocity());
            movePattern.add(ZERO);
        }
        Collections.shuffle(movePattern);
    }

    /**
     * returns the vertical velocity for movement     *
     * @return The vertical velocity.
     */
    public static int getVerticalVelocity() {
        return VERTICAL_VELOCITY;
    }

    /**
     * returns the max number of frames for consecutive moves in the same direction
     * @return the maximum frames for consecutive moves
     */
    public static int getMaxFramesWithSameMove() {
        return MAX_FRAMES_WITH_SAME_MOVE;
    }
}
