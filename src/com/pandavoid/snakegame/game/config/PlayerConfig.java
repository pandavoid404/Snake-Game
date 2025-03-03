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
	public void nextColor() {
		colorIndex++;
		if (colorIndex >= gameConfig.getColors().length) {
			colorIndex = 0;
		}
	}
	public void previousColor(){
		colorIndex--;
	}
}
