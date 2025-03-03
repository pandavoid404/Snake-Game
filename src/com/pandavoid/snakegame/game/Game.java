package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.game.snake.Snake;

public class Game {
	private final GameConfig config;
	private final int Players;
	private final Snake[] snakes = new Snake[2];
	public Game(GameConfig config) {
		this.config = config;
		this.Players = config.getPlayers();
		Board board = new Board(10, 20);
		snakes[0] = new Snake(this,config.getPlayerConfig(0));
		if (config.getPlayers()==2) {
			snakes[1] = new Snake(this,config.getPlayerConfig(1));
		}
	}
	public void TurnSnake() {

	}
	public void Move() {
		for (Snake snake : snakes) {
			snake.Move();
		}
	}
	public Snake[] getSnakes() {
		return snakes;
	}

	public int getPlayers() {
		return Players;
	}
}
