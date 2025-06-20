package com.pandavoid.snakegame.core.board;

import com.pandavoid.snakegame.core.crate.Crate;
import com.pandavoid.snakegame.core.food.Food;

import java.awt.*;

public class Cell {
	private final Point position;

	private boolean occupied;
	private Food food;
	private Crate crate;

	public Cell(Point position) {
		occupied = false;
		food = null;
		crate = null;
		this.position = position;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public Food getFood() {
		return food;
	}

	public Point getPosition() {
		return position;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public void setCrate(Crate crate) {
		this.crate = crate;
		this.occupied = true;
	}

	public Crate getCrate() {
		return crate;
	}
}
