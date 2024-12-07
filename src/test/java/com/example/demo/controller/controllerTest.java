package com.example.demo.controller;

import com.example.demo.controller.Controller;
import com.example.demo.ui.GameUIFactory;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class controllerTest {
    private Stage stage;
    private GameUIFactory uiFactory;
    private Controller controller;

    @BeforeEach
    void setUp() {
        stage=new Stage();
        uiFactory =new GameUIFactory();
        controller= new Controller(stage, uiFactory);
    }


    @Test
    void testLaunchMainMenu() {
        controller.launchMainMenu();
        assert(stage.getTitle()!=null);
        assert(stage.isShowing());
    }

    @Test
    void testLaunchGame() {
        controller.launchGame();
        assert(stage.getScene()!=null);
    }

    @Test
    void testHandleGameOver() {
        controller.showGameOver();
        assert(stage.getScene()!=null);
    }

    @Test
    void testHandleWinGame() {
        controller.showWinGame();
        assert(stage.getScene()!=null);
    }



}
