package com.pandavoid.snakegame.core;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.config.AssetConfig;
import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.core.board.Board;
import com.pandavoid.snakegame.config.GameConfig;
import com.pandavoid.snakegame.core.food.Food;
import com.pandavoid.snakegame.core.snake.Snake;
import com.pandavoid.snakegame.enums.FoodType;
import com.pandavoid.snakegame.enums.LogType;
import com.pandavoid.snakegame.ui.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private final GamePanel gamePanel;
	private final int Players;
	private final ArrayList<Snake> snakes = new ArrayList<>();
	private final Board board;
	private int goldenappleChance = 0;
	private final int baseChance;
	private int tick = 0;
	private boolean gameRunning = true;
	public int goldenApplesChance;
	public Game(GameConfig config, ActionMap actionMap,GamePanel gamePanel) {
		this.Players = config.getPlayers();
		this.gamePanel = gamePanel;
		this.board = new Board();
		this.baseChance = config.getGoldenApplesChance();
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

	public ArrayList<Snake> getSnakes() {
		return snakes;
	}

	public int getPlayers() {
		return Players;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public Board getBoard() {
		return board;
	}

	private void addSnakeControls(ActionMap actionMap,Snake snake,int SnakeNumber){
		actionMap.put("Move UP snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.turnSnake(Direction.UP);
			}
		});
		actionMap.put("Move DOWN snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.turnSnake(Direction.DOWN);
			}
		});
		actionMap.put("Move LEFT snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.turnSnake(Direction.LEFT);
			}
		});
		actionMap.put("Move RIGHT snake " + SnakeNumber, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.turnSnake(Direction.RIGHT);
			}
		});
	}

	private void spawnFood(){
		Random r= new Random();
		int r1 = r.nextInt(baseChance);
		int chance = 100/baseChance*goldenappleChance;
		FoodType foodType = FoodType.apple;
		if(r1<goldenappleChance){
			foodType = FoodType.goldenapple;
			goldenappleChance = 0;
			Logger.debug(LogType.APPLE,chance + "% chance of goldenapple");
			Logger.info(LogType.APPLE,"goldenapple generated");
		}
		goldenappleChance++;
		new Food(this,board.findFreeCell().getPosition(),foodType);
	}

	public void takeCell(int x, int y,Snake snake) {
		Food food = board.getCell(x, y).getFood();
		if (food != null) {
			getGamePanel().removeSnakeBlock(food.getAssetPaint());
			board.getCell(x, y).setFood(null);
			spawnFood();
			snake.increaseLength(food.getFoodval());
			snake.getStats().appleEaten(food.getFoodType());
		}
		if (board.getCell(x, y).isOccupied()) {
			snake.collision();
		} else {
			board.getCell(x, y).setOccupied(true);
		}
	}

	public void leaveCell(int x, int y,Snake snake) {
		board.getCell(x, y).setOccupied(false);
	}

	public void tick() {
		tick+= 1;
		Logger.debug(LogType.TICK,"tick: " + tick);
		Logger.setTick(tick);
		for (Snake snake : snakes) {
			snake.move();
		}
		if(getPlayers()==2){
			if(!snakes.getFirst().isAlive()||!snakes.getLast().isAlive()){
				pause();
				Main.gameOverWindow();
			}
		}
		else if(!snakes.getFirst().isAlive()){
			pause();
			Main.gameOverWindow();
		}
	}

	public void pause() {
		gameRunning = false;
		Logger.info(LogType.GAME,"Paused game");
	}

	public void resume() {
		gameRunning = true;
		new Thread(gamePanel).start();
		Logger.info(LogType.GAME,"Resumed game");
	}

	public boolean isGameRunning() {
		return gameRunning;
	}
}
