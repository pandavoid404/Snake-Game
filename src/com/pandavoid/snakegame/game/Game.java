package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.game.snake.Snake;

public class Game {
	private final GameConfig config;
	public Game(GameConfig config) {
		this.config = config;
		Board board = new Board(10, 20);
		Snake snake1 = new Snake(this,config.getPlayerConfig(0));
		if (config.getPlayers()==2) {
			Snake snake2 = new Snake(this,config.getPlayerConfig(1));
		}
	}
}
