package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.game.snake.Snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Game {
	private final GameConfig config;
	private final int Players;
	private final ArrayList<Snake> snakes = new ArrayList<>();
	private final Board board;
	private int tick = 0;

	public Game(GameConfig config, ActionMap actionMap) {
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
			tick+= 1;
			System.out.println("tick: " + tick);
		}
	}
}
