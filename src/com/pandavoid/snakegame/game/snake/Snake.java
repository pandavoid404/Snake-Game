package com.pandavoid.snakegame.game.snake;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.config.PlayerConfig;

import java.awt.*;

public class Snake {
	private final Game game;
	private final PlayerConfig config;
	private Direction direction;
	private Point position;
	public Snake(Game game, PlayerConfig config) {
		this.game = game;
		this.config = config;
		this.direction = config.getDirection();
		this.position = config.getPosition();
	}
	public void Move() {
		Point newPosition = new Point(position);
		switch (direction) {
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
