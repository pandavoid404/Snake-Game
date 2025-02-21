package com.pandavoid.snakegame.game.snake;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.config.PlayerConfig;

import java.awt.*;

public class Snake {
	private final Game game;
	private final PlayerConfig config;
	private Direction currentDirection;
	private Direction newDirection;
	private Point position;
	public Snake(Game game, PlayerConfig config) {
		this.game = game;
		this.config = config;
		this.newDirection = config.getDirection();
		this.position = config.getPosition();
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
	public void Move() {
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
		position = newPosition;
	}
}
