package com.pandavoid.snakegame.game.config;

import com.pandavoid.snakegame.enums.Direction;

import java.awt.*;

public class PlayerConfig {
	private int colorIndex;
	private final GameConfig gameConfig;
	private Direction direction;
	private Point position;
	public PlayerConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
		this.colorIndex = 0;
		this.direction = Direction.RIGHT;
		this.position = new Point(10, 10);
	}
	public Color getColor() {
		return gameConfig.getColors()[colorIndex];
	}
	public void nextColor() {
		colorIndex++;
		if (colorIndex >= gameConfig.getColors().length) {
			colorIndex = 0;
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
