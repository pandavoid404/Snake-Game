package com.pandavoid.snakegame.core.snake;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.enums.SnakePart;
import com.pandavoid.snakegame.ui.AssetPaint;
import com.pandavoid.snakegame.config.AssetConfig;

import java.awt.*;

public class SnakeCell {
	private final AssetPaint assetPaint;
	private final Point position;
	private final Direction fromDirection;

	private SnakePart part;
	private Direction toDirection;

	public SnakeCell(Point position,Snake snake, Direction fromDirection) {
		AssetConfig config = new AssetConfig();
		config.setPosition(position);
		config.setColor(snake.getColor());
		this.position = position;
		this.part = SnakePart.HEAD;
		snake.getGame().takeCell(position.x,position.y, snake);
		this.fromDirection = fromDirection;
		this.assetPaint = snake.getGame().getGamePanel().createAsset(config);
	}

	public void isTail() {
		this.part = SnakePart.TAIL;
	}

	public Direction getFromDirection() {
		return fromDirection;
	}

	public Direction getToDirection() {
		return toDirection;
	}

	public SnakePart getPart() {
		return part;
	}
	public AssetPaint getSnakepaint() {
		return assetPaint;
	}

	public Point getPosition() {
		return position;
	}

	public void setNextDirection(Direction direction) {
		this.toDirection = direction;
		this.part = SnakePart.BODY;
	}
}
