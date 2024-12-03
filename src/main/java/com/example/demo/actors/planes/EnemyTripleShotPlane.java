package com.example.demo.actors.planes;


import com.example.demo.actors.ActiveActorDestructible;
import com.example.demo.actors.movement.MovementStrategy;
import com.example.demo.actors.movement.ZigZagPlaneMovementPattern;
import com.example.demo.projectiles.Enemy3Projectile;
import com.example.demo.projectiles.ProjectileFactory;
import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class EnemyTripleShotPlane extends FighterPlane {


    private static final String IMAGE_NAME = "enemyplane.png";
    private static final int IMAGE_HEIGHT = 65;
    private static final double INITIAL_X_POSITION = 1000.0;
    private static final int HORIZONTAL_VELOCITY = -5;
    private static final double PROJECTILE_X_POSITION_OFFSET = -50.0;
    private static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;
    private static final int INITIAL_HEALTH = 10;
    private static final double FIRE_RATE = .02;

    private final MovementStrategy movementStrategy;
    private final Group root;
    public EnemyTripleShotPlane(double initialYPos, Group root) {
        super(IMAGE_NAME, IMAGE_HEIGHT, INITIAL_X_POSITION, initialYPos, INITIAL_HEALTH);
        this.movementStrategy=new ZigZagPlaneMovementPattern();
        this.root=root;
    }

    public static double getProjectileXPositionOffset() {
        return PROJECTILE_X_POSITION_OFFSET;
    }

    @Override
    public void updatePosition() {
        double initialTranslateY = getTranslateY();
        double initialTranslateX=getTranslateX();

        moveHorizontally(HORIZONTAL_VELOCITY);
        moveVertically(movementStrategy.getNextMove());
        //movementStrategy.getNextMove();
        double currentPosition = getLayoutY() + getTranslateY();
        if (isWithinBounds(currentPosition)) {
            setTranslateY(initialTranslateY);
        }
    }

    /*@Override
    public ActiveActorDestructible fireProjectile() {
        if (Math.random() < FIRE_RATE) {
            return ProjectileFactory.createProjectile("enemy",
                    getProjectileXPosition(getProjectileXPositionOffset()),
                    getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET));
        }
        return null;
    }*/

    @Override
    public ActiveActorDestructible fireProjectile(){
        if(Math.random()<FIRE_RATE) {
            spawnProjectile(0);
            spawnProjectile(-20);
            spawnProjectile(20);
        }
        return null;
    }
    private void spawnProjectile(double angleOffset) {
        ActiveActorDestructible projectile=new Enemy3Projectile(
                getProjectileXPosition(PROJECTILE_X_POSITION_OFFSET),
                getProjectileYPosition(PROJECTILE_Y_POSITION_OFFSET),
                angleOffset
        );
        root.getChildren().add(projectile);
    }




    @Override
    public void updateActor() {
        updatePosition();
    }

}
