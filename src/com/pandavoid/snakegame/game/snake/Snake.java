package com.pandavoid.snakegame.game.snake;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.config.PlayerConfig;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
	private final Game game;
	private final PlayerConfig config;
	private final Color snakeColor;
	private int length;
	private Direction currentDirection;
	private Direction newDirection;
	private Point position;
	private int maxLength = 3;
	private final ArrayList<SnakeCell> snakeCells = new ArrayList<>();
	public Snake(Game game, PlayerConfig config) {
		this.game = game;
		this.config = config;
		this.newDirection = config.getDirection();
		this.position = config.getPosition();
		this.snakeColor = config.getColor();
		this.snakeCells.add(new SnakeCell(new Point(this.config.getPosition().x, this.config.getPosition().y),this,newDirection));
		Move();
		Move();
	}
	public void TurnSnake(Direction direction) {
		switch (direction) {
			case UP:
				if (this.currentDirection != Direction.DOWN) {
					this.newDirection = direction;
				}
				break;
			case DOWN:
				if (this.currentDirection != Direction.UP) {
					this.newDirection = direction;
				}
				break;
			case LEFT:
				if (this.currentDirection != Direction.RIGHT) {
					this.newDirection = direction;
				}
			case RIGHT:
				if (this.currentDirection != Direction.LEFT) {
					this.newDirection = direction;
				}
				break;
		}
	}
	public boolean Move() {
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
		System.out.println("Moving snake to " + newPosition);
		if (game.getBoard().OutsideArea(newPosition.x, newPosition.y)) {
			System.out.println("Out of area");
			return false;
		}
		position = newPosition;
		snakeCells.addFirst(new SnakeCell(new Point(position.x,position.y),this,currentDirection));
		System.out.println("Snake head added at x: "+position.x+" and y: "+position.y+" with direction: "+currentDirection.toString());
		updateHead(currentDirection);
		if (snakeCells.size() > maxLength) {
			game.getGamePanel().removeSnakeBlock(snakeCells.getLast().getSnakepaint());
			snakeCells.removeLast();
			updateTail();
			System.out.println("Snake tail removed and tail updated because snake is longer than " + maxLength);
		}
		return true;
	}
	public Color getColor() {
		return snakeColor;
	}

	public void Collision() {
		System.out.println("Snake collision");
	}
	
	public void increaseLength() {
		length++;
	}

	public Point getPosition() {
		return position;
	}

	public ArrayList<SnakeCell> getSnakeCells() {
		return snakeCells;
	}

	public Game getGame() {
		return game;
	}

	private void updateTail() {
		if (snakeCells.size() > 1) {
			snakeCells.getLast().isTail();
		}
	}
	private void updateHead(Direction direction) {
		if (snakeCells.size() > 1) {
			snakeCells.get(1).setNextDirection(direction);
			System.out.println(" old snake head updated with direction: " + direction);
		}
	}
}
