package com.pandavoid.snakegame.config;

import com.pandavoid.snakegame.enums.Direction;

import java.awt.*;

public class PlayerConfig {
	private static final int BASE_LENGTH = 5;

	private final GameConfig gameConfig;

	private int colorIndex;
	private Direction direction;
	private Point position;

	public PlayerConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
		this.colorIndex = 0;
		this.direction = Direction.UP;
		this.position = new Point(5, 30);
	}

	public Color getColor() {
		return gameConfig.getColors()[colorIndex];
	}

	public Direction getDirection() {
		return direction;
	}

	public int getBaseLength() {
		return BASE_LENGTH;
	}

	public Point getPosition() {
		return position;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void changeColor(int amount) {
		colorIndex += amount;
		if (colorIndex < 0) {
			colorIndex = gameConfig.getColors().length - 1;
		}
		else if (colorIndex >= gameConfig.getColors().length) {
			colorIndex = 0;
		}
	}
}
