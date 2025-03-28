package com.pandavoid.snakegame.game.snake;

import java.awt.*;

public class SnakeCell {
	private Snake snake;
	private int x;
	private int y;
	private int nextX;
	private int nextY;
	public SnakeCell(int x, int y, Snake snake) {
		this.x = x;
		this.y = y;
		this.snake = snake;
		this.snake.getGame().takeCell(this.x,this.y,this.snake);
	}
	public Point getCurrentPosition(Float progress,int BoxSize) {
		int differenceX = this.nextX-this.x;
		int differenceY = this.nextY-this.y;
		int newX = Math.round((differenceX * progress + this.x) * BoxSize);
		int newY = Math.round((differenceY * progress + this.y) * BoxSize);
		return new Point(newX,newY);
	}
	public void setNextPosition(int x, int y) {
		this.x = this.nextX;
		this.y = this.nextY;
		this.nextX = x;
		this.nextY = y;
	}
}
