package com.example.demo.actors;

public class PlaneConstants {

    //Movement
    public static final int VERTICAL_VELOCITY = 8;
    public static final int MAX_FRAMES_WITH_SAME_MOVE = 10;
    public static final int ENEMY2_HORIZONTAL_VELOCITY = -5;
    public static final int ENEMY_HORIZONTAL_VELOCITY = -6;

    //health
    public static final int BOSS_INITIAL_HEALTH = 50;
    public static final int ENEMY_INITIAL_HEALTH = 1;
    public static final int MINIBOSS_INITIAL_HEALTH = 10;

    //firerates
    public static final double BOSS_FIRE_RATE = .04;
    public static final double ENEMY_FIRE_RATE = .01;
    public static final double MINIBOSS_FIRE_RATE = .02;

    //positions

    public static final double INITIAL_X_POSITION = 1000.0;
    public static final double INITIAL_Y_POSITION = 400;
    public static final double USER_INITIAL_X_POSITION = 5.0;
    public static final double USER_INITIAL_Y_POSITION = 300.0;


    //shield
    public static final double SHIELD_PROBABILITY = .002;
    public static final int MAX_FRAMES_WITH_SHIELD = 100;

    //levelbounds
    public static final int Y_POSITION_UPPER_BOUND = 100;
    public static final int Y_POSITION_LOWER_BOUND = 475;
    public static final double Y_UPPER_BOUND = -40;
    public static final double Y_LOWER_BOUND = 600.0;
    public static final double X_LEFT_BOUND=5.0;
    public static final double X_RIGHT_BOUND=1200.0;


    //projectile offsets
    public static final double BOSS_PROJECTILE_Y_POSITION_OFFSET = 75.0;
    public static final double PROJECTILE_X_POSITION_OFFSET = -100.0;
    public static final double MINIBOSS_PROJECTILE_X_POSITION_OFFSET = -50.0;
    public static final double PROJECTILE_Y_POSITION_OFFSET = 50.0;
    public static final int PROJECTILE_X_POSITION = 110;
    public static final int USER_PROJECTILE_Y_POSITION_OFFSET = 20;


    //image heights
    public static final int BOSS_IMAGE_HEIGHT = 59;
    public static final int ENEMY2_IMAGE_HEIGHT = 45;
    public static final int ENEMY_IMAGE_HEIGHT = 56;
    public static final int MINIBOSS_IMAGE_HEIGHT = 65;
    public static final int USER_IMAGE_HEIGHT = 42;


    public static final int MOVE_FREQUENCY_PER_CYCLE = 5;


    private PlaneConstants() {
        // Prevent instantiation
    }


}
