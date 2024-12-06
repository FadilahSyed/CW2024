package com.example.demo.actors.planes;

import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.actors.planes.*;
import com.example.demo.ui.LevelViewLevelTwo;

public class PlaneFactory {
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
