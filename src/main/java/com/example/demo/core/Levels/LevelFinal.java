package com.example.demo.core.Levels;

import com.example.demo.actors.planes.Boss;
import com.example.demo.core.Management.LevelConfig;
import com.example.demo.core.Management.LevelConfigFactory;
import com.example.demo.core.Management.LevelParent;
import com.example.demo.ui.LevelView;
import com.example.demo.ui.LevelViewLevelTwo;

public class LevelFinal extends LevelParent {

	/*private static final String BACKGROUND_IMAGE_NAME = "background3.jpeg";
	private static final int PLAYER_INITIAL_HEALTH = 5;*/
	private final Boss boss;
	private LevelViewLevelTwo levelView;
	private LevelConfig config;
	//private MovementPattern movementPattern;
	//private ShieldManager shieldManager;

	public LevelFinal(double screenHeight, double screenWidth) {
		super(LevelConfigFactory.getConfig("LevelFinal"),screenHeight,screenWidth);
		this.config = LevelConfigFactory.getConfig("LevelFinal");
		boss = new Boss(levelView);
	}

	@Override
	protected void initializeFriendlyUnits() {
		getRoot().getChildren().add(getUser());
	}

	@Override
	protected void checkIfGameOver() {
		if (userIsDestroyed()) {
			loseGame();
		}
		else if (boss.isDestroyed()) {
			winGame();
		}
	}

	@Override
	protected void spawnEnemyUnits() {
		if (getCurrentNumberOfEnemies() == 0) {
			addEnemyUnit(boss);
		}
	}


	@Override
	protected LevelView instantiateLevelView(LevelConfig config) {
		levelView = new LevelViewLevelTwo(getRoot(), config.getPlayerInitialHealth());
		return levelView;
	}

}
