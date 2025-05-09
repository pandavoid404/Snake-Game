package com.pandavoid.snakegame.game.snake;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.enums.SnakePart;
import com.pandavoid.snakegame.ui.window.Snakepaint;

import java.awt.*;

public class SnakeCell {
	private final Snake snake;
	private Point position;
	private SnakePart part;
	private final Direction fromDirection;
	private Direction toDirection;
	private Snakepaint snakepaint;
	public SnakeCell(Point position,Snake snake, Direction fromDirection) {
		this.position = position;
		this.snake = snake;
		this.part = SnakePart.HEAD;
		this.snake.getGame().takeCell(position.x,position.y,this.snake);
		this.fromDirection = fromDirection;
		this.snakepaint = snake.getGame().getGamePanel().createSnakeBlock(position);
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
	public Snakepaint getSnakepaint() {
		return snakepaint;
	}
}
