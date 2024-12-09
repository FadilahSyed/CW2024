package com.example.demo.projectiles;

/**
 * factory class for creating different types of projectiles
 */
public class ProjectileFactory {

    /**
     * creates a projectile of the specified type at a given position
     * @param type the type of projectile (eg. user, enemy, boss, miniboss)
     * @param x the initial x-coordinate of the projectile
     * @param y the intitial y-coordinate of the projectile
     * @return a specific instance of {@code Projectile}
     * @throws IllegalArgumentException if the projectile type is unkown
     */
    public static Projectile createProjectile(String type, double x, double y) {
        switch(type.toLowerCase()) {
            case "boss":
                return new BossProjectile(y);
            case "enemy":
                return new EnemyProjectile(x, y);
            case "miniboss":
                return new MiniBossProjectile(x, y);
            case "user": {
                return new UserProjectile(x,y);
            }
            default:
                throw new IllegalArgumentException("Unknown projectile type: " + type);
        }
    }

}
