package com.pandavoid.snakegame.game.snake;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.enums.SnakePart;

import java.awt.*;

public class SnakeCell {
	private final Snake snake;
	private final int x;
	private final int y;
	private SnakePart part;
	private final Direction fromDirection;
	private Direction toDirection;
	public SnakeCell(int x, int y, Snake snake, Direction fromDirection) {
		this.x = x;
		this.y = y;
		this.snake = snake;
		this.part = SnakePart.HEAD;
		this.snake.getGame().takeCell(this.x,this.y,this.snake);
		this.fromDirection = fromDirection;

	}
	public Point getPosition() {
		return new Point(x,y);
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
}
