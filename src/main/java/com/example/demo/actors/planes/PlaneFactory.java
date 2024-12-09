package com.example.demo.actors.planes;

/**
 * factory class for creating different types of fighter planes.
 */
public class PlaneFactory {
    /**
     * creates a fighter plane/actor based on the specified type.
     *
     * @param type   the type of plane (eg. enemy,enemy2,miniboss,boss,user).
     * @param x      the initial X-coordinate of the plane.
     * @param y      the initial Y-coordinate of the plane.
     * @param health the initial health of the plane.
     * @return an instance of a {@code FighterPlane}.
     * @throws IllegalArgumentException if the specified plane type is unknown.
     */
   public static FighterPlane createPlane(String type, double x, double y, int health) {
        switch (type.toLowerCase()) {
            case "user":
                return new UserPlane(health);
            case "enemy":
                return new EnemyPlane(x, y);
            case "enemy2":
                return new Enemy2Plane(x, y);
            case "miniboss":
                return new MiniBoss(y);
            default:
                throw new IllegalArgumentException("Unknown plane type: " + type);
        }
    }
}
