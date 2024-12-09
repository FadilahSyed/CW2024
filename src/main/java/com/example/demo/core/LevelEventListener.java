package com.example.demo.core;
/**
 * defines a listener interface for handling level-related events
 * (replaces observer + observable)
 */
public interface LevelEventListener {
    /**
     * called when a specific event occurs in the level
     *
     * @param event a string representing the event name (eg. "gameover" or "win").
     */
    void onLevelEvent(String event);
}
