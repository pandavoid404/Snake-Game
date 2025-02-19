package com.pandavoid.snakegame.game.config;

public class GameConfig {
	private int players;
	private final PlayerConfig[] playerConfigs = new PlayerConfig[2];
	public GameConfig() {
		players = 1;
	}
	public void setPlayers(int amount) {
		players = amount;
		playerConfigs[0] = new PlayerConfig();
		if (players == 1) {
			playerConfigs[1] = null;
		} else if (players == 2) {
			playerConfigs[1] = new PlayerConfig();
		}
	}
	public int getPlayers() {
		return players;
	}

	public PlayerConfig getPlayerConfig(int player) {
		return playerConfigs[player];
	}
}
