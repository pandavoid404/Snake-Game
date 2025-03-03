package com.pandavoid.snakegame.game.config;

import java.awt.*;

public class PlayerConfig {
	private int colorIndex;
	private final GameConfig gameConfig;
	public PlayerConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
		this.colorIndex = 0;
	}
	public Color getColor() {
		return gameConfig.getColors()[colorIndex];
	}

	public void ChangeColor(int amount) {
		colorIndex += amount;
		if (colorIndex < 0) {
			colorIndex = gameConfig.getColors().length - 1;
		}
		else if (colorIndex >= gameConfig.getColors().length) {
			colorIndex = 0;
		}
	}
}
