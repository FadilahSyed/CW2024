package com.example.demo.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.lang.Thread.sleep;
public class GameLoopTest {
    private GameLoop gameLoop;
    private boolean updated;

    @BeforeEach
    void setUp(){
        updated=false;
        gameLoop=new GameLoop(50,()->updated=true);
    }

    @Test
    void testStart() throws InterruptedException {
        gameLoop.start();
        sleep(100);
        assert(updated);
        gameLoop.stop();
    }

    @Test
    void testStop() throws InterruptedException {
        gameLoop.start();
        sleep(50);
        gameLoop.stop();
        boolean wasUpdated=updated;
        sleep(50);
        assert(wasUpdated==updated);
    }
}
