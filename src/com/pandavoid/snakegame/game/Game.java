package com.pandavoid.snakegame.game;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.board.Board;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.game.food.Food;
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
		this.board = new Board(33, 60);
		snakes.add(new Snake(this,config.getPlayerConfig(0)));
		addSnakeControls(actionMap,snakes.get(0),1);
		if (config.getPlayers()==2) {
			snakes.add(new Snake(this,config.getPlayerConfig(1)));
			addSnakeControls(actionMap,snakes.get(1),2);
		}
		for (int I = 0; I < config.getStartingFood();I++) {
			spawnFood();
		}
	}
	private void addSnakeControls(ActionMap actionMap,Snake snake,int SnakeNumber){
		actionMap.put("Move UP snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.TurnSnake(Direction.UP);
			}
		});
		actionMap.put("Move DOWN snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.TurnSnake(Direction.DOWN);
			}
		});
		actionMap.put("Move LEFT snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.TurnSnake(Direction.LEFT);
			}
		});
		actionMap.put("Move RIGHT snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.TurnSnake(Direction.RIGHT);
			}
		});
	}
	private void spawnFood(){
		new Food(this,board.FindFreeCell().getPosition());
	}

	public void takeCell(int x, int y,Snake snake) {
		Food food = board.GetCell(x, y).getFood();
		if (food != null) {
			getGamePanel().removeSnakeBlock(food.getAssetPaint());
			board.GetCell(x, y).setFood(null);
			spawnFood();
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
		System.out.println("tick: " + tick);
		for (Snake snake : snakes) {
			snake.Move();
			tick+= 1;
		}
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}
	public Board getBoard() {
		return board;
	}
}
