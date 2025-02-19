package com.pandavoid.snakegame.game.snake;

import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.config.PlayerConfig;

public class Snake {
	private final Game game;
	private final PlayerConfig config;
	public Snake(Game game, PlayerConfig config) {
		this.game = game;
		this.config = config;
	}
}
