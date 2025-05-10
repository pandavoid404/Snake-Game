package com.pandavoid.snakegame.game.board;

import com.pandavoid.snakegame.game.food.Food;

import java.awt.*;

public class Cell {
	private boolean occupied;
	private Food food;
	private final Point position;
	public Cell(Point position) {
		occupied = false;
		food = null;
		this.position = position;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public Point getPosition() {
		return position;
	}
}
