package com.example.demo.actors.shield;

public interface ShieldStrategy {
    void updateShield();
    boolean isShielded();

    void updateShieldPosition(double x, double y);


}
