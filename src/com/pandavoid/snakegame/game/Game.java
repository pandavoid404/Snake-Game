package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.game.config.PlayerConfig;
import com.pandavoid.snakegame.game.snake.Snake;

public class Game {
	public Game(GameConfig config) {
		Board board = new Board(10, 20);
		Snake snake = new Snake(this,new PlayerConfig());
	}
}
