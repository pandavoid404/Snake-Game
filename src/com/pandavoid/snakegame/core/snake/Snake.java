package com.pandavoid.snakegame.core.snake;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.config.PlayerConfig;
import com.pandavoid.snakegame.enums.LogType;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
	private final Game game;
	private final Color snakeColor;
	private final ArrayList<SnakeCell> snakeCells = new ArrayList<>();

	private Direction currentDirection;
	private Direction newDirection;
	private Point position;
	private int maxLength;
	private int score = 0;
	private boolean alive = true;

	public Snake(Game game, PlayerConfig config) {
		this.game = game;
		this.newDirection = config.getDirection();
		this.position = config.getPosition();
		this.snakeColor = config.getColor();
		this.maxLength = config.getBaseLength();
		this.snakeCells.add(new SnakeCell(new Point(config.getPosition().x, config.getPosition().y),this,newDirection));
		move();
		move();
	}

	public Color getColor() {
		return snakeColor;
	}

	public Point getPosition() {
		return position;
	}

	public ArrayList<SnakeCell> getSnakeCells() {
		return snakeCells;
	}

	public int getScore() {

		return score;
	}
	public int getAliveBonus() {
		Logger.debug(LogType.SCORE, "Alive: " + alive);
		Logger.debug(LogType.SCORE,"Game running: " + game.isGameRunning());
		if (!game.isGameRunning()){
			if(alive) {
				return 2;
			}
		}
		return 0;
	}
	public Game getGame() {
		return game;
	}

	public boolean isAlive() {
		return alive;
	}

	public void turnSnake(Direction direction) {
		Logger.debug(LogType.MOVE,"Turning snake to " + direction + " from " + currentDirection);
		switch (direction) {
			case UP:
				if (this.currentDirection != Direction.DOWN && this.currentDirection != Direction.UP) {
					this.newDirection = direction;
				}
				break;
			case DOWN:
				if (this.currentDirection != Direction.UP && this.currentDirection != Direction.DOWN) {
					this.newDirection = direction;
				}
				break;
			case LEFT:
				if (this.currentDirection != Direction.RIGHT && this.currentDirection != Direction.LEFT) {
					this.newDirection = direction;
				}
			case RIGHT:
				if (this.currentDirection != Direction.LEFT && this.currentDirection != Direction.RIGHT) {
					this.newDirection = direction;
				}
				break;
		}
	}

	public boolean move() {
		Point newPosition = new Point(position);
		currentDirection = newDirection;
		switch (currentDirection) {
			case UP:
				newPosition.y--;
				break;
			case DOWN:
				newPosition.y++;
				break;
			case LEFT:
				newPosition.x--;
				break;
			case RIGHT:
				newPosition.x++;
				break;
		}
		Logger.debug(LogType.MOVE,"Moving snake to " + newPosition);
		if (game.getBoard().isOutsideArea(newPosition.x, newPosition.y)) {
			Logger.debug(LogType.MOVE,"Out of area");
			collision();
			return false;
		}
		position = newPosition;
		snakeCells.addFirst(new SnakeCell(new Point(position.x,position.y),this,currentDirection));
		Logger.debug(LogType.SNAKE,"Snake head added at x: "+position.x+" and y: "+position.y+" with direction: "+currentDirection.toString());
		updateHead(currentDirection);
		if (snakeCells.size() > maxLength) {
			SnakeCell lastCell = snakeCells.getLast();
			game.leaveCell(lastCell.getPosition().x, lastCell.getPosition().y, this);
			game.getGamePanel().removeSnakeBlock(snakeCells.getLast().getSnakepaint());
			game.getGamePanel().removeSnakeBlock(lastCell.getSnakepaint());
			updateTail();
			snakeCells.remove(lastCell);
			Logger.debug(LogType.SNAKE,"Snake tail removed and tail updated because snake is longer than " + maxLength);
		}
		return true;
	}

	public void collision() {
		alive = false;
		Logger.info(LogType.SNAKE,"Snake collision");
	}
	
	public void increaseLength(int amount) {
		maxLength+=amount;
		score+=amount;
	}

	private void updateTail() {
		if (snakeCells.size() > 1) {
			snakeCells.getLast().isTail();
		}
	}
	private void updateHead(Direction direction) {
		if (snakeCells.size() > 1) {
			snakeCells.get(1).setNextDirection(direction);
			Logger.debug(LogType.SNAKE," old snake head updated with direction: " + direction);
		}
	}
}
