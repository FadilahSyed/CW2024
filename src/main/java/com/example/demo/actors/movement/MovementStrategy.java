package com.example.demo.actors.movement;

/**
 * defines a strategyfor actor(enemy planes) movement behaviour
 */
public interface MovementStrategy {

    /**
     * determines the next movement direction or velocity.
     *
     * @return an integer value representing the next movement action.
     */
    int getNextMove();
}
