package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.snake.Snake;
import jdk.dynalink.StandardNamespace;

public class Game {
	private final Board board;
	private final Snake snake;
	public Game() {
		board = new Board(10,20);
		snake = new Snake();
	}
}
