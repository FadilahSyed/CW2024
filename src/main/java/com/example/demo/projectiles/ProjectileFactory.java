package com.example.demo.projectiles;

public class ProjectileFactory {
    public static Projectile createProjectile(String type, double x, double y) {
        switch(type.toLowerCase()) {
            case "boss":
                return new BossProjectile(y);
            case "enemy":
                return new EnemyProjectile(x, y);
            case "miniboss":
                return new MiniBossProjectile(x, y);
            case "user": {
                System.out.println("firefire");
                return new UserProjectile(x,y);
            }
            default:
                throw new IllegalArgumentException("Unknown projectile type: " + type);
        }
    }

}
