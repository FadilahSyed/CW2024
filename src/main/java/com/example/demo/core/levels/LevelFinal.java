package com.example.demo.core.levels;

import com.example.demo.actors.planes.Boss;
import com.example.demo.core.LevelConfig;
import com.example.demo.core.LevelConfigFactory;
import com.example.demo.core.AbstractLevel;
import com.example.demo.ui.LevelView;
import com.example.demo.ui.LevelViewLevelTwo;

public class LevelFinal extends AbstractLevel {

	private final Boss boss;
	private LevelViewLevelTwo levelView;
	private LevelConfig config;

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
