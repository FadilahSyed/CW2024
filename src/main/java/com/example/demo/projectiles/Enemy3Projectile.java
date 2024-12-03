package com.example.demo.projectiles;

import com.example.demo.projectiles.Projectile;
import com.example.demo.projectiles.movement.ProjectileMovementStrategy;
import com.example.demo.projectiles.movement.StraightMovement;

public class Enemy3Projectile extends Projectile {

    private static final String IMAGE_NAME = "enemyFire.png";
    private static final int IMAGE_HEIGHT = 10; //reduced the hitbox of normal enemy's projectile
    private static final int HORIZONTAL_VELOCITY = -10;
    private double velocityX;
    private double velocityY;


    private final ProjectileMovementStrategy movementStrategy;

    public Enemy3Projectile(double initialXPos, double initialYPos,double angleOffset) {
        super(IMAGE_NAME, IMAGE_HEIGHT, initialXPos, initialYPos);
        this.movementStrategy=new StraightMovement(HORIZONTAL_VELOCITY);


        double radians = Math.toRadians(angleOffset);
        this.velocityX=HORIZONTAL_VELOCITY*Math.cos(radians);
        this.velocityY=HORIZONTAL_VELOCITY*Math.sin(radians);
    }

    @Override
    public void updatePosition() {
        //movementStrategy.updatePosition(this);
        moveHorizontally(velocityX);
        moveVertically(velocityY);
    }

    @Override
    public void updateActor() {
        updatePosition();
    }


}
