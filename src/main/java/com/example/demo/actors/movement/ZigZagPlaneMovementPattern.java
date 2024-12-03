package com.example.demo.actors.movement;

import com.example.demo.projectiles.Projectile;

public class ZigZagPlaneMovementPattern implements MovementStrategy {
    //private static final int HORIZONTAL_VELOCITY=-10;
    //private static final int VERTICAL_VELOCITY=5;

    private static final int AMPLITUDE=50;
    private static final int FREQUENCY=2;
    private static final int VERTICAL_CYCLE=180;

    private int frameCount=0;

    @Override
    public int getNextMove() {
        frameCount++;
        return(int)(AMPLITUDE*Math.sin(FREQUENCY*Math.PI*frameCount/VERTICAL_CYCLE));
    }


}
