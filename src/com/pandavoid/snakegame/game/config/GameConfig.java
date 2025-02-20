package com.pandavoid.snakegame.game.config;

import java.awt.*;

public class GameConfig {
	private int players;
	private final PlayerConfig[] playerConfigs = new PlayerConfig[2];
	private final static Color[] colors = { new Color(0, 0, 139), Color.RED,new Color(0, 100, 0),Color.MAGENTA,new Color(255, 140, 0),new Color(128, 0, 128)};
	public GameConfig() {
		players = 1;
	}
	public void setPlayers(int amount) {
		players = amount;
		playerConfigs[0] = new PlayerConfig(this);
		if (players == 1) {
			playerConfigs[1] = null;
		} else if (players == 2) {
			playerConfigs[1] = new PlayerConfig(this);
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
}
