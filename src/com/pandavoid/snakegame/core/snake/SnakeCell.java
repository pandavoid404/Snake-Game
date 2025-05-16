package com.pandavoid.snakegame.core.snake;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.enums.SnakePart;
import com.pandavoid.snakegame.ui.AssetPaint;
import com.pandavoid.snakegame.config.AssetConfig;

import java.awt.*;

public class SnakeCell {
	private final Snake snake;
	private Point position;
	private SnakePart part;
	private final Direction fromDirection;
	private Direction toDirection;
	private AssetPaint assetPaint;
	public SnakeCell(Point position,Snake snake, Direction fromDirection) {
		AssetConfig config = new AssetConfig();
		config.setPosition(position);
		config.setColor(snake.getColor());
		this.position = position;
		this.snake = snake;
		this.part = SnakePart.HEAD;
		this.snake.getGame().takeCell(position.x,position.y,this.snake);
		this.fromDirection = fromDirection;
		this.assetPaint = snake.getGame().getGamePanel().createAsset(config);
	}
	public Point getPosition() {
		return position;
	}
	public void isTail() {
		this.part = SnakePart.TAIL;
	}
	public void setNextDirection(Direction direction) {
		this.toDirection = direction;
		this.part = SnakePart.BODY;
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
}
