package com.example.demo.actors.shield;

/**
 * Interface defining the behavior of shields in the game.
 */
public interface ShieldStrategy {

    /**
     * Updates the shield state, such as activating or deactivating it.
     */
    void updateShield();

    /**
     * Determines if the shield is currently active.
     *
     * @return {@code true} if the shield is active, otherwise {@code false}.
     */
    boolean isShielded();

    /**
     * Updates the position of the shield based on the plane's position.
     *
     * @param x the X-coordinate of the plane.
     * @param y the Y-coordinate of the plane.
     */
    void updateShieldPosition(double x, double y);


}
