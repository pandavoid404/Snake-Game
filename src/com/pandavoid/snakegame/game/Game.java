package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.game.snake.Snake;
import com.pandavoid.snakegame.ui.window.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Game {
	private final GamePanel gamePanel;
	private final GameConfig config;
	private final int Players;
	private final ArrayList<Snake> snakes = new ArrayList<>();
	private final Board board;
	private int tick = 0;

	public Game(GameConfig config, ActionMap actionMap,GamePanel gamePanel) {
		this.config = config;
		this.Players = config.getPlayers();
		this.gamePanel = gamePanel;
		this.board = new Board(10, 20);
		snakes.add(new Snake(this,config.getPlayerConfig(0)));
		actionMap.put("Move UP snake 1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snakes.getFirst().TurnSnake(Direction.UP);
				System.out.println("moving snake 1 up");
			}
		});
		actionMap.put("Move DOWN snake 1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snakes.getFirst().TurnSnake(Direction.DOWN);
				System.out.println("moving snake 1 down");
			}
		});
		actionMap.put("Move LEFT snake 1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snakes.getFirst().TurnSnake(Direction.LEFT);
				System.out.println("moving snake 1 left");
			}
		});
		actionMap.put("Move RIGHT snake 1", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snakes.getFirst().TurnSnake(Direction.RIGHT);
				System.out.println("moving snake 1 right");
			}
		});
		if (config.getPlayers()==2) {
			snakes.add(new Snake(this,config.getPlayerConfig(1)));
			actionMap.put("Move UP snake 2", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					snakes.getLast().TurnSnake(Direction.UP);
					System.out.println("moving snake 2 up");
				}
			});
			actionMap.put("Move DOWN snake 2", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					snakes.getLast().TurnSnake(Direction.DOWN);
					System.out.println("moving snake 2 down");
				}
			});
			actionMap.put("Move LEFT snake 2", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					snakes.getLast().TurnSnake(Direction.LEFT);
					System.out.println("moving snake 2 left");
				}
			});
			actionMap.put("Move RIGHT snake 2", new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					snakes.getLast().TurnSnake(Direction.RIGHT);
					System.out.println("moving snake 2 right");
				}
			});
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

	public GamePanel getGamePanel() {
		return gamePanel;
	}
}
