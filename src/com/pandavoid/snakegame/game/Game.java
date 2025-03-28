package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.game.snake.Snake;

import java.util.ArrayList;

public class Game {
	private final GameConfig config;
	private final int Players;
	private final ArrayList<Snake> snakes = new ArrayList<>();
	private final Board board;

	public Game(GameConfig config) {
		this.config = config;
		this.Players = config.getPlayers();
		this.board = new Board(10, 20);
		snakes.add(new Snake(this,config.getPlayerConfig(0)));
		if (config.getPlayers()==2) {
			snakes.add(new Snake(this,config.getPlayerConfig(1)));
		}
	}

	private void placeFood() {
		board.FindFreeCell().setFood(true);
	}

	public void takeCell(int x, int y,Snake snake) {
		if (board.GetCell(x, y).isFood()) {
			board.GetCell(x, y).setFood(false);
			placeFood();
			snake.increaseLength();
		}
		if (board.GetCell(x, y).isOccupied()) {
			snake.Collision();
		} else {
			board.GetCell(x, y).setOccupied(true);
		}
	}

	public void leaveCell(int x, int y,Snake snake) {
		board.GetCell(x, y).setOccupied(false);
	}

	public ArrayList<Snake> getSnakes() {
		return snakes;
	}

	public int getPlayers() {
		return Players;
	}

	public void tick() {
		for (Snake snake : snakes) {
			snake.Move();
		}
	}
}
