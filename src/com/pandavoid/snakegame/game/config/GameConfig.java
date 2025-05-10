package com.pandavoid.snakegame.game.config;

import java.awt.*;

public class GameConfig {
	private int players;
	private final PlayerConfig[] playerConfigs = new PlayerConfig[2];
	private final static Color[] colors = { new Color(0, 0, 139), Color.RED,new Color(0, 100, 0),Color.MAGENTA,new Color(255, 140, 0),new Color(128, 0, 128)};
	private int startingFood = 5;
	public GameConfig() {
		players = 1;
	}
	public void setPlayers(int amount) {
		players = amount;
		playerConfigs[0] = new PlayerConfig(this);
		playerConfigs[0].setPosition(new Point(5, 30));
		if (players == 1) {
			playerConfigs[1] = null;
		} else if (players == 2) {
			playerConfigs[1] = new PlayerConfig(this);
			playerConfigs[1].setPosition(new Point(55, 30));
		}
	}
	public Color[] getColors() {
		return colors;
	}

	public int getPlayers() {
		return players;
	}

	public PlayerConfig getPlayerConfig(int player) {
		return playerConfigs[player];
	}
	public int getStartingFood() {
		return startingFood;
	}
	public void setStartingFood(int startingFood) {
		this.startingFood = startingFood;
	}
}
